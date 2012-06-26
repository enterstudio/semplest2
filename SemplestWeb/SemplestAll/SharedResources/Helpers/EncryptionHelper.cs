using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SharedResources.Helpers;
using Org.BouncyCastle.Crypto.Paddings;
using Org.BouncyCastle.Crypto;
using System.Security.Cryptography;
using Org.BouncyCastle.Crypto.Engines;
using System.Text;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Crypto.Modes;


namespace Semplest.SharedResources.Encryption
{
    public sealed class EncryptionHelper
    {

        private static String _encryptionKey = null;
        private BufferedBlockCipher decrypt = null;
        private BufferedBlockCipher encrypt = null;
        private static EncryptionHelper instance = null;
	    private static byte[] iv = { 0x43, (byte) 0x6d, 0x22, (byte) 0x9a, 0x22, (byte) 0xf8, (byte) 0xcf, (byte) 0xfe, 0x15, 0x21, (byte) 0x0b, 0x38, 0x01, (byte) 0xa7, (byte) 0xfc, 0x0e };


        private EncryptionHelper() 
        {
 
        }

        public static EncryptionHelper getInstance()
        {


            if (instance == null)
            {

                try
                {
                    if (string.IsNullOrEmpty(_encryptionKey))
                    {
                        Initalize();
                    }
                    EncryptionHelper bcEngine = new EncryptionHelper();
                    KeyParameter keyParam = new KeyParameter(Encoding.UTF8.GetBytes(_encryptionKey));
                    ICipherParameters param = new ParametersWithIV(keyParam, iv);

                    //create decrypt/encryptor cipher
                    IBlockCipherPadding padding = new Pkcs7Padding();
                    BufferedBlockCipher decrypt = new PaddedBufferedBlockCipher(new CbcBlockCipher(new AesEngine()), padding);
                    decrypt.Reset();
                    decrypt.Init(false, param);
                    bcEngine.setDecryptCipher(decrypt);

                    BufferedBlockCipher encrypt = new PaddedBufferedBlockCipher(new CbcBlockCipher(new AesEngine()), padding);
                    encrypt.Reset();
                    encrypt.Init(true, param);
                    bcEngine.setEncryptCipher(encrypt);

                   instance = bcEngine;
                }
                catch (Exception)
                {
                    
                    throw;
                }

               
                
            }
            return instance;

        }

        public void setDecryptCipher(BufferedBlockCipher decryptCipher)
        {
            decrypt = decryptCipher;
        }
        public BufferedBlockCipher getDecryptCipher()
        {
            return decrypt;
        }

        public void setEncryptCipher(BufferedBlockCipher encryptCipher)
        {
            encrypt = encryptCipher;
        }
        public BufferedBlockCipher getEncryptCipher()
        {
            return encrypt;
        }
        public static bool VerifyPassword(string s)
        {
            return false;
        }

        public string DecryptString(string s)
        {
            try
            {
                BufferedBlockCipher decrypt = instance.getDecryptCipher();
                if (decrypt == null)
                {
                    throw new Exception("Must initialize AES Decrypt Cipher with call to getInstance()");
                }
               
                byte[] strBytes = Convert.FromBase64String(s);
                byte[] decrypted = new byte[decrypt.GetOutputSize(strBytes.Length)];
                int len = decrypt.ProcessBytes(strBytes, 0, strBytes.Length, decrypted, 0);
                len = len + decrypt.DoFinal(decrypted, len);
                String res = Encoding.UTF8.GetString(decrypted);
                return res.Substring(0,len); 
            }
            catch (Exception)
            {
                
                throw;
            }
        }

        public string EncryptString(string s)
        {
            try
            {
                BufferedBlockCipher encrypt = instance.getEncryptCipher();
                if (encrypt == null)
                {
                    throw new Exception("Must initialize AES Encrypt Cipher with call to getInstance()");
                }
                byte[] encryptData = encrypt.DoFinal(Encoding.UTF8.GetBytes(s));
                return Convert.ToBase64String(encryptData);
            }
            catch (Exception)
            {
                
                throw;
            }
        }

        private static void Initalize()
        {
            using (SemplestModel.Semplest dbContext = new SemplestModel.Semplest())
            {
                _encryptionKey = dbContext.Configurations.FirstOrDefault().SemplestEncryptionkey;
            }
        }
    }
}