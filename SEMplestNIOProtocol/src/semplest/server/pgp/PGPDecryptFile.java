package semplest.server.pgp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPOnePassSignatureList;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKeyEncryptedData;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;


public class PGPDecryptFile
{

	private static final Logger logger = Logger.getLogger(PGPDecryptFile.class);
	private PGPPrivateKey privateKey = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String pubKeyFilename = "PGPFiles/SemplestPrivateKey.asc"; 
		String filename = "C:/keyword.txt.pgp"; 
		String outfile = "C:/keywordTestDecrypt.txt";
	
		try
		{
			PGPDecryptFile PGPdecrypt = new PGPDecryptFile(pubKeyFilename, -8483756796133403433L,
					"SEMplest2012");
			PGPdecrypt.decrypt(new File(filename), new File(outfile));
		}
		catch (NoSuchProviderException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (PGPException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Password is encrypted
	 */
	public PGPDecryptFile(String privateKeyFile, long keyID, String pass) throws NoSuchProviderException, PGPException,
			IOException
	{
		Security.addProvider(new BouncyCastleProvider());
		privateKey = findSecretKey(privateKeyFile, keyID,pass); 
	}

	public void decrypt(File encryptedInputFile, File outputFile) throws PGPException, NoSuchProviderException, IOException
	{
		try
		{
			FileInputStream input = new FileInputStream(encryptedInputFile);
			InputStream decoder = PGPUtil.getDecoderStream(input);
			PGPObjectFactory pgpFactory = new PGPObjectFactory(decoder);
			PGPEncryptedDataList encryptedDataList;

			//Try to find the Encrypted Data List
			Object o = pgpFactory.nextObject();
			//
			// the first object might be a PGP marker packet.
			//
			if (o instanceof PGPEncryptedDataList)
			{
				encryptedDataList = (PGPEncryptedDataList) o;
			}
			else
			{
				encryptedDataList = (PGPEncryptedDataList) pgpFactory.nextObject();
			}
			Iterator encryptedDataIt = encryptedDataList.getEncryptedDataObjects();
			PGPPublicKeyEncryptedData publicKeyEncryptedData = null;
			while (encryptedDataIt.hasNext())
            {
				publicKeyEncryptedData = (PGPPublicKeyEncryptedData)encryptedDataIt.next();
               
            }

			
			InputStream clear = publicKeyEncryptedData.getDataStream(privateKey, "BC");
			PGPObjectFactory plainFact = new PGPObjectFactory(clear);
			// compressed
			Object message = plainFact.nextObject();
			//check to see if the file is compressed
			if (message instanceof PGPCompressedData)
			{
				PGPCompressedData compressedData = (PGPCompressedData) message;
			//
				InputStream compressedStream = new BufferedInputStream(compressedData.getDataStream());
				PGPObjectFactory pgpFactory2 = new PGPObjectFactory(compressedStream);
				message = pgpFactory2.nextObject();
			}

			if (message instanceof PGPLiteralData)
			{
				PGPLiteralData literalData = (PGPLiteralData) message;
				FileOutputStream fOut = new FileOutputStream(outputFile);
				BufferedOutputStream bOut = new BufferedOutputStream(fOut);

				InputStream unc = literalData.getInputStream();
				int ch;

				while ((ch = unc.read()) >= 0)
				{
					bOut.write(ch);
				}

				bOut.close();
			}
			else if (message instanceof PGPOnePassSignatureList)
			{
				throw new PGPException("encrypted message contains a signed message - not literal data.");
			}
			else
			{
				throw new PGPException("message is not a simple encrypted file - type unknown.");
			}
			//check to see if file has Integrity protection
			if (publicKeyEncryptedData.isIntegrityProtected())
			{
				if (!publicKeyEncryptedData.verify())
				{
					logger.error("message failed integrity check");
				}
				else
				{
					logger.info("message integrity check passed");
				}
			}
			else
			{
				logger.info("no message integrity check");
			}
		}
		catch (FileNotFoundException e)
		{
			throw e;
		}
		catch (IOException e)
		{
			throw e;
		}

	}

	/*
	 * private key - need the file, keyID and password
	 */
	private PGPPrivateKey findSecretKey(String privateKeyFile, long keyID, String pass) throws PGPException,
			NoSuchProviderException, IOException
	{
		FileInputStream input = new FileInputStream(new File(privateKeyFile));
		PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(input));
		
		
		/* PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection( in ); 
		 
		 
		    Iterator<PGPSecretKeyRing> ringIt = pgpSec.getKeyRings(); 
		    PGPSecretKey pgpSecKey = null;
		    while( ringIt.hasNext() ) 
		    { 
		      PGPSecretKeyRing keyRing = ringIt.next(); 
		      pgpSecKey = keyRing.getSecretKey();
		    } 
		*/
		PGPSecretKey pgpSecKey = pgpSec.getSecretKey(keyID);

		if (pgpSecKey == null)
		{
			return null;
		}

		return pgpSecKey.extractPrivateKey(pass.toCharArray(), "BC");
	}
}
