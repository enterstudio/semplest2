using System.Linq;


namespace SharedResources.Models.Repositories
{
    public class TransactionRepository : ITransactionRepository
    {
        private readonly SemplestModel.Semplest _dbcontext;

        public TransactionRepository(SemplestModel.Semplest dbcontext)
        {
            _dbcontext = dbcontext;
        }

        public int GetTransactionTypeCode(string transactionType)
        {
           return _dbcontext.TransactionTypes.Single(t => t.TransactionType1 == transactionType).TransactionTypePK;
        }
    }
}