using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace Semplest.Core.Models
{
    public class SearchKeywordsModel1
    {
        public SearchKeywordsModel1()
        {
            Categories = new List<string>();
            Keywords = new List<string>();
        }


        public List<string> Categories { get; set; }
        public List<string> Keywords { get; set; }
    }

    public class SearchKeywordsModel
    {
        public SearchKeywordsModel()
        {
            AllCategories = new List<CategoriesModel>();
            SelectedCategories = new List<CategoriesModel>();
            AllKeywords = new List<KeywordsModel>();
            SelectedKeywords = new List<KeywordsModel>();
            CategoriesList = GetCategories(null);
        }

        [Required(ErrorMessage = "required field")]
        public string Product { get; set; }

        [Required(ErrorMessage = "required field")]
        public string LandingPage { get; set; }

        [Required(ErrorMessage = "required field")]
        public string Description { get; set; }

        [Required(ErrorMessage = "required field")]
        public string AdCopy { get; set; }

        // this message will be used to show the status of the service while getting Categories and Keywords from the service
        public string StatusMessage { get; set; }

        public MultiSelectList CategoriesList { get; private set; }


        public int[] ItemIds { get; set; }
        public List<CategoriesModel> SelectedCategories { get; set; }

        public List<CategoriesModel> AllCategories { get; set; }

        public List<KeywordsModel> SelectedKeywords { get; set; }

        public List<KeywordsModel> AllKeywords { get; set; }

        public MultiSelectList GetCategories(int[] selectedValues)
        {
            return new MultiSelectList(AllCategories, "Id", "Name", selectedValues);
        }

        #region Nested type: CategoriesModel

        public class CategoriesModel
        {
            public int Id { get; set; }
            public string Name { get; set; }
        }

        #endregion

        #region Nested type: KeywordsModel

        public class KeywordsModel
        {
            public string Name { get; set; }
        }

        #endregion
    }
}