using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace SemplestWebApp.Models
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

        public string Product { get; set; }
        public string LandingPage { get; set; }

        public MultiSelectList CategoriesList { get; private set; }

 

        public int[] ItemIds { get; set; }
        public List<CategoriesModel> SelectedCategories{ get; set; }

        public List<CategoriesModel> AllCategories { get; set; }

        public List<KeywordsModel> SelectedKeywords { get; set; }

        public List<KeywordsModel> AllKeywords { get; set; } 

        public MultiSelectList GetCategories(int[] selectedValues)
        {
            return new MultiSelectList(AllCategories, "Id", "Name", selectedValues);
        }
 
        public class CategoriesModel
        {
            public int Id { get; set; }
            public string Name { get; set; }
        }

        public class KeywordsModel
        {
            public string Name { get; set; }
        }

    }
}