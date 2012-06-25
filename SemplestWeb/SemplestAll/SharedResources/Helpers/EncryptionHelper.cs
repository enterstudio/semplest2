using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SharedResources.Helpers;

namespace Semplest.SharedResources.Encryption
{
    public sealed class EncryptionHelper
    {
        private static string _encryptionKey;

        private EncryptionHelper() { }

        public static bool VerifyPassword(string s)
        {
            if (string.IsNullOrEmpty(_encryptionKey))
                Initalize();
            return false;
        }

        public string DecryptString(string s)
        {
            if (string.IsNullOrEmpty(_encryptionKey))
                Initalize();
            return string.Empty;
        }

        public string EncryptString(string s)
        {
            if (string.IsNullOrEmpty(_encryptionKey))
                Initalize();
            return string.Empty;
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