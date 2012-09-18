using System.Collections.Generic;
using System.Linq;
using SemplestModel;


namespace Semplest.Core.Models.Repositories
{
    public interface ICategoriesRepository
    {
        void SaveSelectedCategories(int promotionId, IEnumerable<string> selectedCategories);
    }
}