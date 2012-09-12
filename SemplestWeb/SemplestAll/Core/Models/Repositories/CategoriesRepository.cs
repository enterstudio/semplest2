using System.Collections.Generic;
using System.Linq;
using SemplestModel;
namespace Semplest.Core.Models.Repositories
{
    public class CategoriesRepository : ICategoriesRepository
    {
        readonly SemplestModel.Semplest _dbcontext;
        public CategoriesRepository(SemplestModel.Semplest dbcontext)
        {
            _dbcontext = dbcontext;
        }
        public void SaveSelectedCategories(int promotionId, IEnumerable<string> selectedCategories)
        {
                var query = _dbcontext.KeywordCategories.Where(c => c.PromotionFK == promotionId);
                if (!query.Any())
                {
                    foreach (
                        var keyCategory in
                            selectedCategories.Select(
                                category => new KeywordCategory { PromotionFK = promotionId, KeywordCategory1 = category })
                        )
                    {
                        _dbcontext.KeywordCategories.Add(keyCategory);
                    }
                    _dbcontext.SaveChanges();
                }
                else // categories exists so update them
                {
                    // delete them first
                    foreach (KeywordCategory kc in query)
                    {
                        _dbcontext.KeywordCategories.Remove(kc);
                    }
                    _dbcontext.SaveChanges();
                    // add them
                    foreach (
                        var keyCategory in
                            selectedCategories.Select(
                                category => new KeywordCategory { PromotionFK = promotionId, KeywordCategory1 = category })
                        )
                    {
                        _dbcontext.KeywordCategories.Add(keyCategory);
                    }
                    _dbcontext.SaveChanges();
                }
        }
    }
}