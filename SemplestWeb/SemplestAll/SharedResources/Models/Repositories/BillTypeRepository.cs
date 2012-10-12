using System.Linq;


namespace SharedResources.Models.Repositories
{
    public class BillTypeRepository : IBillTypeRepository
    {
        private readonly SemplestModel.Semplest _dbcontext;

        public BillTypeRepository(SemplestModel.Semplest dbcontext)
        {
            _dbcontext = dbcontext;
        }

        public int GetBillTypeCode(string billType)
        {
            return _dbcontext.BillTypes.Single(t => t.BillType1 == billType).BillTypePK;
        }
    }
}