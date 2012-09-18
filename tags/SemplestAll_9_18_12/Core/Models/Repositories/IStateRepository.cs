namespace Semplest.Core.Models.Repositories
{
    public interface IStateRepository
    {
        string GetStateNameFromCode(int stateCode);
    }
}