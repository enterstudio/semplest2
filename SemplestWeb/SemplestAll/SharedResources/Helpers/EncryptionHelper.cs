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
    public sealed class AesEncyrption
    {

        private static String _encryptionKey = null;
        private BufferedBlockCipher decrypt = null;
        private BufferedBlockCipher encrypt = null;
        private static AesEncyrption instance = null;
        private static byte[] iv = { 0x43, (byte)0x6d, 0x22, (byte)0x9a, 0x22, (byte)0xf8, (byte)0xcf, (byte)0xfe, 0x15, 0x21, (byte)0x0b, 0x38, 0x01, (byte)0xa7, (byte)0xfc, 0x0e };
        private const string TOKENDELIMITER = "&";
        private const string VALUEDELIMITER = "=";


        private AesEncyrption()
        {

        }

        public static AesEncyrption getInstance()
        {


            if (instance == null)
            {

                try
                {
                    if (string.IsNullOrEmpty(_encryptionKey))
                    {
                        Initalize();
                    }
                    AesEncyrption bcEngine = new AesEncyrption();
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
                return res.Substring(0, len);
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

        const string PARENTID = "parentid";
        const string DATETIME = "datetime";
        const string USERNAME = "username";
        const string PASSWORD = "password";
        public string GenerateToken(string parentid, string datetime, string username, string password)
        {
            AesEncyrption a = AesEncyrption.getInstance();
            StringBuilder s = new StringBuilder();
            s.Append(PARENTID);
            s.Append(VALUEDELIMITER);
            s.Append(parentid);
            s.Append(TOKENDELIMITER);
            s.Append(DATETIME);
            s.Append(VALUEDELIMITER);
            s.Append(datetime);
            s.Append(TOKENDELIMITER);
            s.Append(USERNAME);
            s.Append(VALUEDELIMITER);
            s.Append(username);
            s.Append(TOKENDELIMITER);
            s.Append(PASSWORD);
            s.Append(VALUEDELIMITER);
            s.Append(password);
            return getInstance().EncryptString(s.ToString());
        }

        public void DecryptToken(string encryptedString, out string parentid, out string datetime, out string username, out string password)
        {
            parentid = datetime = username = password = string.Empty;
            try
            {
                AesEncyrption a = AesEncyrption.getInstance();
                string[] decryptedString = a.DecryptString(encryptedString).Split(TOKENDELIMITER.ToCharArray());

                foreach (string s in decryptedString)
                {
                    if (s != TOKENDELIMITER)
                    {
                        string[] nameValue = s.Split(VALUEDELIMITER.ToCharArray());
                        switch (nameValue[0])
                        {
                            case PARENTID:
                                parentid = nameValue[1];
                                break;
                            case DATETIME:
                                datetime = nameValue[1];
                                break;
                            case USERNAME:
                                username = nameValue[1];
                                break;
                            case PASSWORD:
                                password = nameValue[1];
                                break;
                            default:
                                throw new Exception("Invalid Token: " + s + " encryptedString: " + encryptedString + " decryptedString =" + decryptedString);
                        }
                    }
                }
            }
            catch (Exception ex)
            { Semplest.SharedResources.Helpers.ExceptionHelper.LogException(ex); }
        }
    }
}