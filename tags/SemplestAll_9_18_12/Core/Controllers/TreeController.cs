using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Script.Serialization;
using TreeView.Models;
using Semplest.Core.Models;

namespace Semplest.Core.Controllers
{
    public class TreeController : Controller
    {
        //
        // GET: /Tree/

        public ActionResult Index()
        {
            ViewBag.Message = "Welcome to ASP.NET MVC!";
            //GetTree();
            return View(new ReportIndexModel());
        }

        public ActionResult About()
        {
            return View();
        }
        public ActionResult GetTree()
        {
            const string json = "[\"top/business/financial_services/insurance/agents_and_marketers/travel/mexico\",\"top/business/financial_services/insurance/agents_and_marketers/automotive/united_states/illinois\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line/united_states/washington\",\"top/home/personal_finance/insurance/automotive\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line/united_states/kansas\",\"top/business/financial_services/insurance/agents_and_marketers/automotive/united_states\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line/united_states\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line\",\"top/business/financial_services/insurance/agents_and_marketers\"]";
            var jss = new JavaScriptSerializer();
            var jsonList = jss.Deserialize<List<string>>(json);
            var strs = jsonList.Select(jsl => jsl.Split('/').ToList()).ToList();
            var treeManager = new TreeManager();

            foreach (var row in strs)
            {
                var path = new List<String>();
                foreach (String item in row)
                {
                    path.Add(item);
                    treeManager.AddData(treeManager, path);
                }
            }
            var jsons = jss.Serialize(treeManager);
            jsons = jsons.Replace("\"Key\"", "text").Replace("\"Value\"", "items").Replace(",items:[]", "").Replace("\"", "");
            jsons = jsons.Replace("{text:", "<ul><li>").Replace(",", "</li>").Replace("items:", "<li>");
            //jsons = jsons.Replace("[{text:", "<ul>").Replace(",items:","<li>").Replace("}]","</ul>");
            //
            jsons = jsons.Replace("}", "</li>");
            //.Replace("]", "</ul>").Replace("[", "").Replace("</li><ul>","</li></ul><ul>");






            var productGroupsBar = new NavBar { Name = "Product Groups..", SubItems = new List<NavBar>() };
            foreach (var promotion in treeManager.Select(x => x))
            {
                var promotionBar = new NavBar
                {
                    Name = promotion.GetName(),
                    Id = 1,
                    SubItems = new List<NavBar>()
                };
               
                BuildSubItems(promotionBar, promotion);
                var jss2 = new JavaScriptSerializer();
                var s = jss2.Serialize(promotionBar);
                ////promotionBar.SubItems.Add(new NavBar { Name = prom.PromotionName, Id = prom.PromotionPK, Url = "../Campaign/CampaignSetup?promotionId=" + prom.PromotionPK.ToString() });

                //productGroupsBar.SubItems.Add(promotionBar);
            }
            //navBars.Add(productGroupsBar);
            return Json(jsons, JsonRequestBehavior.AllowGet);
        }

        public ActionResult BuildSubItems()
        {
            const string json = "[\"top/business/financial_services/insurance/agents_and_marketers/travel/mexico\",\"top/business/financial_services/insurance/agents_and_marketers/automotive/united_states/illinois\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line/united_states/washington\",\"top/home/personal_finance/insurance/automotive\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line/united_states/kansas\",\"top/business/financial_services/insurance/agents_and_marketers/automotive/united_states\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line/united_states\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line\",\"top/business/financial_services/insurance/agents_and_marketers\"]";
            var jss = new JavaScriptSerializer();
            var jsonList = jss.Deserialize<List<string>>(json);
            var strs = jsonList.Select(jsl => jsl.Split('/').ToList()).ToList();
            var treeManager = new TreeManager();

            foreach (var row in strs)
            {
                var path = new List<String>();
                foreach (String item in row)
                {
                    path.Add(item);
                    treeManager.AddData(treeManager, path);
                }
            }
            var productGroupsBar = new NavBar {Name = "Product Groups..", SubItems = new List<NavBar>()};
            NavBar promotionBar=null;
            foreach (var promotion in treeManager.Select(x => x))
            {
                Console.WriteLine("as");
                promotionBar = new NavBar
                                       {
                                           Name = promotion.GetName(),
                                           Id = 1,
                                           SubItems = new List<NavBar>()
                                       };

                BuildSubItems(promotionBar, promotion);
            }
            productGroupsBar.SubItems.Add(promotionBar);
            var navBars = new List<NavBar>();
            navBars.Add(productGroupsBar);
            var jss2 = new JavaScriptSerializer();
            return Json(navBars, JsonRequestBehavior.AllowGet);
        }

        private void BuildSubItems(NavBar top, TreeItem next)
        {
            foreach (var child in next.children)
            {
                    var promotionBar = new NavBar
                                           {
                                               Name = child.Value.GetName(),
                                               Id = 1,
                                               SubItems = new List<NavBar>()
                                           };
                    top.SubItems.Add(promotionBar);

                    BuildSubItems(promotionBar, child.Value);
                }
        }
    }
}



namespace TreeView.Models
{
    /**
      * This base class provides the hierarchical property of
      * an object that contains a Map of child objects of the same type.
      * It also has a field - Name
      *
      */
    public abstract class TreeItem : IEnumerable<TreeItem>
    {

        public readonly Dictionary<String, TreeItem> children;
        private String name;

        protected TreeItem()
        {
            children = new Dictionary<String, TreeItem>();
        }

        public String GetName()
        {
            return name;
        }

        public void SetName(String itemName)
        {
            name = itemName;
        }

        public void AddChild(String key, TreeItem data)
        {
            children.Add(key, data);
        }
        public TreeItem GetChild(String key)
        {
            return children[key];
        }

        public bool HasChild(String key)
        {
            return children.ContainsKey(key);
        }

        public IEnumerator GetEnumerator()
        {
            return children.GetEnumerator();
        }


        IEnumerator<TreeItem> IEnumerable<TreeItem>.GetEnumerator()
        {
            return children.Values.GetEnumerator();
        }
    }

    /**
     * This is our special case, root node. It is a TreeItem in itself
     * but contains methods for building and retrieving items from our tree
     *
     */
    public class TreeManager : TreeItem
    {
        /**
         * Will add an Item to the tree at the specified path with the value
         * equal to the last item in the path, unless that Item already exists 
         */
        public void AddData(List<String> path)
        {
            AddData(this, path);
        }

        public void AddData(TreeItem parent, List<String> path)
        {
            // if we're at the end of the path - create a node
            String data = path[0];
            if (path.Count == 1)
            {
                // unless there is already a node with this itemName
                if (!parent.HasChild(data))
                {
                    var group = new Group();
                    group.SetName(data);
                    parent.AddChild(data, group);
                }
            }
            else
            {
                // pass the tail of this path down to the next level in the hierarchy
                AddData(parent.GetChild(data), path.GetRange(1, path.Count - 1));
            }
        }

        public Group GetData(String[] path)
        {
            return (Group)GetData(this, path.ToList());
        }

        public Group GetData(List<String> path)
        {
            return (Group)GetData(this, path);
        }

        public TreeItem GetData(TreeItem parent, List<String> path)
        {
            if (parent == null)
                return null;
            String data = path[0];
            if (path.Count == 1)
                return parent.GetChild(data);
            // pass the tail of this path down to the next level in the hierarchy
            return GetData(parent.GetChild(data), path.GetRange(1, path.Count - 1));
        }
    }

    public class Group : TreeItem
    {
        private readonly Dictionary<String, Object> properties;

        public Object GetValue(Object key)
        {
            return properties[key.ToString()];
        }

        public Object PutValue(String key, Object value)
        {
            properties.Add(key, value);
            return value;
        }

        public Group()
        {
            properties = new Dictionary<String, Object>();
        }
    }
}