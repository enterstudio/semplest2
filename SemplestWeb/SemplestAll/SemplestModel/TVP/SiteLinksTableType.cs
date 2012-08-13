using System.Data;
using System;

namespace SemplestModel.TVP
{
    public class SiteLinksTableType : DataTable
    {
        public SiteLinksTableType()
        {
            Columns.Add("LinkText", typeof (string));
            Columns.Add("LinkUrl", typeof (string));
            Columns.Add("UID", typeof (string));
            Columns.Add("PKEY", typeof (int));
            Columns.Add("Operation", typeof (string));
        }

        public void Add(SiteLinksTableTypeRow row)
        { Rows.Add(row); }

        public new SiteLinksTableTypeRow NewRow() { return (SiteLinksTableTypeRow)base.NewRow(); }

        protected override Type GetRowType()
        {
            //return base.GetRowType();
            return typeof(SiteLinksTableTypeRow);
        }

        protected override DataRow NewRowFromBuilder(DataRowBuilder builder)
        {
            //return base.NewRowFromBuilder(builder);
            return new SiteLinksTableTypeRow(builder);
        }
    }

    public class SiteLinksTableTypeRow : DataRow
    {
        internal SiteLinksTableTypeRow(DataRowBuilder builder) : base(builder) { }
        public string LinkText { get { return (string)base["LinkText"]; } set { base["LinkText"] = value; } }
        public string LinkUrl { get { return (string)base["LinkUrl"]; } set { base["LinkUrl"] = value; } }
        public string UID { get { return (string)base["UID"]; } set { base["UID"] = value; } }
        public int? PKEY
        {
            get { return (int?)base["PKEY"]; }
            set
            {
                if (value == null)
                { base["PKEY"] = DBNull.Value; }
                else
                { base["PKEY"] = value; }
            }
        }
        public string Operation { get { return base["Operation"].ToString(); } set { base["Operation"] = value; } }
    }
}
