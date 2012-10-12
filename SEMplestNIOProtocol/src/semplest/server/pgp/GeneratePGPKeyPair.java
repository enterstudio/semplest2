package semplest.server.pgp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.SignatureException;
import java.util.Date;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSignature;

public class GeneratePGPKeyPair
{
	private long privateKeyID = 0L;
	private long publicKeyID = 0L;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			GeneratePGPKeyPair pgp = new GeneratePGPKeyPair("Semplest", "RSA", 1024, "SEMplest2012", "c:/BC_Keys/SemplestPrivateKey", "c:/BC_Keys/SemplestPublicKey", false);
		}
		catch (InvalidKeyException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchProviderException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SignatureException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (PGPException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public GeneratePGPKeyPair(String identity, String keyType, int keySize, String password, String privateFile, String publicFile,
			boolean asciiArmor) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException, IOException, PGPException
	{
		Security.addProvider(new BouncyCastleProvider());
		KeyPairGenerator kpg = KeyPairGenerator.getInstance(keyType, "BC");
		kpg.initialize(keySize);
		KeyPair kp = kpg.generateKeyPair();
		// identity passphrase
		if (asciiArmor)
		{
			FileOutputStream out1 = new FileOutputStream(privateFile + ".asc");
			FileOutputStream out2 = new FileOutputStream(publicFile + ".asc");
			
			exportKeyPair(out1, out2, kp.getPublic(), kp.getPrivate(), identity, password.toCharArray(), true);
		}
		else
		{
			 FileOutputStream out1 = new FileOutputStream(privateFile + ".bpg");
			 FileOutputStream out2 = new FileOutputStream(publicFile + ".bpg");
			 //write keys to file
			 exportKeyPair(out1, out2, kp.getPublic(), kp.getPrivate(), identity, password.toCharArray(), false);
		} 
	}

	/*
	 * export the keys to files
	 */
	private void exportKeyPair(OutputStream privateOut, OutputStream publicOut, PublicKey publicKey,
			PrivateKey privateKey, String identity, char[] passPhrase, boolean armor) throws IOException,
			InvalidKeyException, NoSuchProviderException, SignatureException, PGPException
	{
		if (armor)
		{
			privateOut = new ArmoredOutputStream(privateOut);
		}

		PGPSecretKey secretKey = new PGPSecretKey(PGPSignature.DEFAULT_CERTIFICATION, PGPPublicKey.RSA_GENERAL,
				publicKey, privateKey, new Date(), identity, PGPEncryptedData.CAST5, passPhrase, null, null,
				new SecureRandom(), "BC");
		secretKey.encode(privateOut);
		privateOut.close();
		privateKeyID = secretKey.getKeyID();

		if (armor)
		{
			publicOut = new ArmoredOutputStream(publicOut);
		}

		PGPPublicKey pubKey = secretKey.getPublicKey();
		pubKey.encode(publicOut);
		publicOut.close();
		publicKeyID = pubKey.getKeyID();
	}

	public long getPrivateKeyID()
	{
		return privateKeyID;
	}

	public long getPublicKeyID()
	{
		return publicKeyID;
	}
}
