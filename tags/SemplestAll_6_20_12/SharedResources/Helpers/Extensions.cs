using SemplestModel;
namespace Semplest.SharedResources.Helpers
{
    public static class Extensions
    {
        public static bool IsAdmin(this Credential c)
        { return string.IsNullOrEmpty(c.User.CustomerFK.ToString().Trim()); }
    }
}