using System.Linq;


namespace SemplestModel.Repositories
{
    public class UserRepository : IUserRepository
    {
        private static Semplest _dbcontext;
        public UserRepository(Semplest dbcontext)
        {
            _dbcontext = dbcontext;
        }
        public UserType GetUserType(string userType)
        {
            return _dbcontext.UserTypes.Single(r => r.UserType1 == userType);
        }
    }
}
