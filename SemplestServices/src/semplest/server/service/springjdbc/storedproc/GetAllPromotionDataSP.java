package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.PromotionObj;

public class GetAllPromotionDataSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetAllPromotionData";
	private static final RowMapper<PromotionObj> promotionObjMapper = new BeanPropertyRowMapper(PromotionObj.class);
	private static final RowMapper<AdsObject> adsObjMapper = new BeanPropertyRowMapper(AdsObject.class);
	private static final RowMapper<GeoTargetObject> geoTargetObjectMapper = new BeanPropertyRowMapper(GeoTargetObject.class);
	private Map<String, Object> results = null;
	
	public GetAllPromotionDataSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlReturnResultSet("promotion", promotionObjMapper));
		declareParameter(new SqlReturnResultSet("ads", adsObjMapper));
		declareParameter(new SqlReturnResultSet("geotarget",geoTargetObjectMapper));
		compile();
	}

	/*
	 * store the resits oin a hashmap
	 */
	public void execute(int promotionID)
	{
		results = super.execute(new Object[] {promotionID},new HashMap());
	}
	
	public PromotionObj getPromotionData()
	{
		if (results.get("promotion") == null)
		{
			return null;
		}
		else
		{
			List<PromotionObj> res = (ArrayList<PromotionObj>) results.get("promotion");
			if (res.size() > 0)
			{
				return res.get(0);
			}
			else
			{
				return null;
			}
		}
	}
	public List<AdsObject> getAds()
	{
		if (results.get("ads") == null)
		{
			return null;
		}
		else
		{
			return (ArrayList<AdsObject>) results.get("ads");
		}
	}
	public List<GeoTargetObject> getGeoTargets()
	{
		if (results.get("geotarget") == null)
		{
			return null;
		}
		else
		{
			return (ArrayList<GeoTargetObject>) results.get("geotarget");
		}
	}
}