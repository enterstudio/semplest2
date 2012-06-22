package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.PromotionObj;

public class GetAllPromotionDataSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetAllPromotionData";
	private static final RowMapper<PromotionObj> promotionObjMapper = new BeanPropertyRowMapper<PromotionObj>(PromotionObj.class);
	private static final RowMapper<AdsObject> adsObjMapper = new BeanPropertyRowMapper<AdsObject>(AdsObject.class);
	private static final RowMapper<GeoTargetObject> geoTargetObjectMapper = new BeanPropertyRowMapper<GeoTargetObject>(GeoTargetObject.class);
	private Map<String, Object> results = null;
	private Map<Integer,HashMap<String,AdEngineID>> PromotionAdEngineID = new HashMap<Integer,HashMap<String,AdEngineID>>();
	
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
	public void execute(Integer promotionID)
	{
		results = super.execute(new Object[] {promotionID}); //,new HashMap());
		if (results.get("promotion") != null)
		{
			List<PromotionObj> res = (List<PromotionObj>) results.get("promotion");
			for (PromotionObj onePromo : res)
			{
				Integer promoID = onePromo.getPromotionPK();
				if (PromotionAdEngineID.containsKey(promoID) && onePromo.getAdvertisingEngine() != null)
				{
					HashMap<String,AdEngineID> adEngineData = PromotionAdEngineID.get(promoID);
					AdEngineID data = new AdEngineID();
					data.setAccountID(onePromo.getAdvertisingEngineAccountPK());
					data.setAdGroupID(onePromo.getAdvertisingEngineAdGroupID());
					data.setCampaignID(onePromo.getAdvertisingEngineCampaignPK());
					adEngineData.put(onePromo.getAdvertisingEngine(), data);
					
				}
				else if (onePromo.getAdvertisingEngine() != null)
				{
					HashMap<String,AdEngineID> adEngineData = new HashMap<String,AdEngineID>();
					AdEngineID data = new AdEngineID();
					data.setAccountID(onePromo.getAdvertisingEngineAccountPK());
					data.setAdGroupID(onePromo.getAdvertisingEngineAdGroupID());
					data.setCampaignID(onePromo.getAdvertisingEngineCampaignPK());					
					final String adEngineAccountNumber = onePromo.getAdvertisingEngineAccountNumber();
					data.setAccountNumber(adEngineAccountNumber);
					adEngineData.put(onePromo.getAdvertisingEngine(), data);
					PromotionAdEngineID.put(promoID, adEngineData);
				}				
			}
		}		
	}
	
	public PromotionObj getPromotionData()
	{
		if (results.get("promotion") == null)
		{
			return null;
		}
		else
		{
			List<PromotionObj> res = (List<PromotionObj>) results.get("promotion");
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
			return (List<AdsObject>) results.get("ads");
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
			return (List<GeoTargetObject>) results.get("geotarget");
		}
	}
	
	public Map<String,AdEngineID> getPromotionAdEngineID(Integer promotionID)
	{
		if (PromotionAdEngineID.containsKey(promotionID))
		{
			return PromotionAdEngineID.get(promotionID);
		}
		else
		{
			return null;
		}
	}
}