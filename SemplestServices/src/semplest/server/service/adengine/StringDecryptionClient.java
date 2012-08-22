package semplest.server.service.adengine;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.encryption.AESBouncyCastle;
import semplest.server.protocol.RegistrationLinkDecryptedInfo;
import semplest.server.service.SemplestConfiguration;
import semplest.util.SemplestUtils;

public class StringDecryptionClient
{
	public static void main(final String[] args) throws Exception
	{
		new ClassPathXmlApplicationContext("Service.xml");
		final Object object = new Object();
		final SemplestConfiguration configDB = new SemplestConfiguration(object);
		final Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		final String semplestEncryptionKey = (String) SemplestConfiguration.configData.get("SemplestEncryptionkey");
		final AESBouncyCastle aes = SemplestUtils.getDefaultAESBouncyCastle(semplestEncryptionKey);
		final List<String> encryptedStrings = Arrays.asList("uHZKF9HG53kwjs35uMHjDZATj2crMVq+WndUMT0AHNcz7c2RTe+QJKpiK9OwyrsFPedrvzB+qHKFLkZM0v7vd6Ad4KkKrYJwOFN+bSOpbYA=");
		System.out.println("Encrypted Text -> Decrypted Text");
		Integer counter = 0;
		for (final String encryptedText : encryptedStrings)
		{			
			final String decryptedText = aes.decrypt(encryptedText);
			System.out.println(++counter + ": [" + encryptedText + "] -> [" + decryptedText + "]");			
		}		
	}
}
