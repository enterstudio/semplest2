namespace SharedResources.Models.Repositories
{
    public interface ITransactionRepository
    {
        int GetTransactionTypeCode(string transactionType);
    }
}