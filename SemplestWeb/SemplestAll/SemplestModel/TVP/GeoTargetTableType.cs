using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace SemplestModel.TVP
{
    public class GeoTargetTableType : DataTable
    {
        public GeoTargetTableType()
        {
            Columns.Add("Address", typeof(string));
            Columns.Add("City", typeof(string));
            Columns.Add("StateCodeFK", typeof(int));
            Columns.Add("Zip", typeof(string));
            Columns.Add("Longitude", typeof(decimal));
            Columns.Add("Latitude", typeof(decimal));
            Columns.Add("ProximityRadius", typeof(decimal));
            Columns.Add("UID", typeof(string));
            Columns.Add("PKEY", typeof(int));
            Columns.Add("Operation", typeof(string));
        }

        public void Add(GeoTargetTableTypeRow row)
        { Rows.Add(row); }

        public new GeoTargetTableTypeRow NewRow() { return (GeoTargetTableTypeRow)base.NewRow(); }

        protected override Type GetRowType()
        {
            //return base.GetRowType();
            return typeof(GeoTargetTableTypeRow);
        }

        protected override DataRow NewRowFromBuilder(DataRowBuilder builder)
        {
            //return base.NewRowFromBuilder(builder);
            return new GeoTargetTableTypeRow(builder);
        }
    }

    public class GeoTargetTableTypeRow : DataRow
    {
        internal GeoTargetTableTypeRow(DataRowBuilder builder) : base(builder) { }
        public string Address { get { return (string)base["Address"]; } set { base["Address"] = value; } }
        public string City { get { return (string)base["City"]; } set { base["City"] = value; } }
        public int? StateCodeFK
        {
            get { return (int?)base["StateCodeFK"]; }
            set
            {
                if (value == null)
                { base["StateCodeFK"] = DBNull.Value; }
                else
                { base["StateCodeFK"] = value; }
            }
        }
        public string Zip { get { return (string)base["Zip"]; } set { base["Zip"] = value; } }
        public decimal? Longitude
        {
            get { return (decimal?)base["Longitude"]; }
            set
            {
                if (value == null)
                { base["Longitude"] = DBNull.Value; }
                else
                { base["Longitude"] = value; }
            }
        }
        public decimal? Latitude
        {
            get { return (decimal?)base["Latitude"]; }
            set
            {
                if (value == null)
                { base["Latitude"] = DBNull.Value; }
                else
                { base["Latitude"] = value; }
            }
        }
        public decimal? ProximityRadius
        {
            get { return (decimal?)base["ProximityRadius"]; }
            set
            {
                if (value == null)
                { base["ProximityRadius"] = DBNull.Value; }
                else
                { base["ProximityRadius"] = value; }
            }
        }
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
