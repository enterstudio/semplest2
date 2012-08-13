using System;
using System.Data;

namespace SemplestModel.TVP
{
    public class PromoAdTableType : DataTable
    {
        public PromoAdTableType()
        {
            Columns.Add("AdTitle", typeof(string));
            Columns.Add("AdTextLine1", typeof(string));
            Columns.Add("AdTextLine2", typeof(string));
            Columns.Add("UID", typeof(string));
            Columns.Add("PKEY", typeof(int));
            Columns.Add("Operation", typeof(string));
        }

        public void Add(PromoAdTableTypeRow row)
        { Rows.Add(row); }

        public new PromoAdTableTypeRow NewRow() { return (PromoAdTableTypeRow)base.NewRow(); }

        protected override Type GetRowType()
        {
            //return base.GetRowType();
            return typeof(PromoAdTableTypeRow);
        }

        protected override DataRow NewRowFromBuilder(DataRowBuilder builder)
        {
            //return base.NewRowFromBuilder(builder);
            return new PromoAdTableTypeRow(builder);
        }
    }

    public class PromoAdTableTypeRow : DataRow
    {
        internal PromoAdTableTypeRow(DataRowBuilder builder) : base(builder) { }
        public string AdTitle { get { return (string)base["AdTitle"]; } set { base["AdTitle"] = value; } }
        public string AdTextLine1 { get { return (string)base["AdTextLine1"]; } set { base["AdTextLine1"] = value; } }
        public string AdTextLine2 { get { return (string)base["AdTextLine2"]; } set { base["AdTextLine2"] = value; } }
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
