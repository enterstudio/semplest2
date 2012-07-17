package semplest.server.pgp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;

public class PGPEncryptFile
{

	private static final Logger logger = Logger.getLogger(PGPEncryptFile.class);
	private PGPPublicKey publicKey = null;
	private boolean armor = true;
	private boolean withIntegrityCheck = false;

	private static final int sizeofEncryptionBuffer = 65536;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		String pubKeyFilename = "PGPFiles/semplestPublicKey.asc"; 
		String inputFileName = "C:/keyword.txt";
		try
		{
			PGPEncryptFile encrypt = new PGPEncryptFile(pubKeyFilename,-8483756796133403433L, true, true); //
			logger.info(encrypt.publicKey.getCreationTime().toString());
			File input = new File(inputFileName);
			if (input.exists())
			{
				encrypt.encryptFile(input, new File(inputFileName + ".pgp"),false); //compress
			}
			else
			{
				logger.error(inputFileName + " File does Not Exist...");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public PGPEncryptFile(String keyRingFile, long clientKeyID, boolean asciiArmor, boolean integrityCheck) throws FileNotFoundException, IOException, PGPException
	{
		Security.addProvider(new BouncyCastleProvider());
		armor = asciiArmor;
		withIntegrityCheck = integrityCheck;
		publicKey = getPublicKey(keyRingFile, clientKeyID);
	}

	@SuppressWarnings("unchecked")
	private PGPPublicKey getPublicKey(String keyRingFile, long clientKeyID) throws FileNotFoundException, IOException, PGPException
	{
		// get the Input stream where the key ring is stored
		InputStream in = PGPUtil.getDecoderStream(new FileInputStream(keyRingFile));
		PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(in);

		//
		// we just loop through the collection till we match the clientKeyID
		// (stored in database)
		PGPPublicKey key = null;

		//
		// iterate through the key rings.
		//
		Iterator keyRingIterator = pgpPub.getKeyRings();

		while (key == null && keyRingIterator.hasNext())
		{
			// get key ring
			PGPPublicKeyRing keyRing = (PGPPublicKeyRing) keyRingIterator.next();
			// get public keys
			Iterator publicKeyIt = keyRing.getPublicKeys();

			while (key == null && publicKeyIt.hasNext())
			{
				PGPPublicKey aKey = (PGPPublicKey) publicKeyIt.next();
				if (aKey.isEncryptionKey() && aKey.getKeyID() == clientKeyID)
				{
					key = aKey;
					break;
				}
			}
		}
		// make sure the key is found
		if (key == null)
		{
			throw new IllegalArgumentException("Can't find encryption key with " + String.valueOf(clientKeyID) + " in key ring.");
		}

		return key;
	}

	public void encryptFile(File inputFile, File outputFile, boolean compress) throws IOException, NoSuchProviderException
	{
		OutputStream out = new BufferedOutputStream(new FileOutputStream(outputFile));
		if (armor)
		{
			out = new ArmoredOutputStream(out);
		}

		try
		{
			// generate the encrypted file
			PGPEncryptedDataGenerator encryptedDataGenerator = new PGPEncryptedDataGenerator(PGPEncryptedData.CAST5, withIntegrityCheck, new SecureRandom(), "BC");
			// add the public key
			encryptedDataGenerator.addMethod(publicKey);
			// open output stream
			OutputStream encryptOut = encryptedDataGenerator.open(out, new byte[sizeofEncryptionBuffer]);
			// compress data
			if (compress)
			{
				PGPCompressedDataGenerator compressData = new PGPCompressedDataGenerator(PGPCompressedData.ZIP);
				// write compressed encrypted data to output stream from input
				// file
				//
				PGPUtil.writeFileToLiteralData(compressData.open(encryptOut), PGPLiteralData.BINARY, inputFile, new byte[sizeofEncryptionBuffer]);
				// close compression
				compressData.close();
			}
			else
			{
				PGPUtil.writeFileToLiteralData(encryptOut, PGPLiteralData.BINARY, inputFile, new byte[sizeofEncryptionBuffer]);
			}
			// close encypted out stream
			encryptOut.close();
			// close the out stream to file
			out.close();
		}
		catch (PGPException e)
		{
			System.err.println(e);
			if (e.getUnderlyingException() != null)
			{
				e.getUnderlyingException().printStackTrace();
			}
		}
		finally
		{
			if (out != null)
				out.close();
		}
	}

}
