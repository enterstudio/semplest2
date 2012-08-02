package semplest.server.service.springjdbc.storedproc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.PromotionObj;

public class GetAllPromotionDataSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetAllPromotionData";
	private static final RowMapper<PromotionObj> promotionObjMapper = new BeanPropertyRowMapper<PromotionObj>(PromotionObj.class);
	private final RowMapper<AdsObject> adsObjMapper;
	private static final RowMapper<GeoTargetObject> geoTargetObjectMapper = new BeanPropertyRowMapper<GeoTargetObject>(GeoTargetObject.class);
	private Map<String, Object> results = null;
	private Map<Integer,Map<AdEngine,AdEngineID>> PromotionAdEngineID = new HashMap<Integer,Map<AdEngine,AdEngineID>>();
	
	public GetAllPromotionDataSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		adsObjMapper = new RowMapper<AdsObject>() {

			@Override
			public AdsObject mapRow(ResultSet rs, int index) throws SQLException
			{
				final Integer promotionAdsPK = rs.getInt("PromotionAdsPK");
				final Integer promotionFK = rs.getInt("PromotionFK");
				final String adTitle = rs.getString("AdTitle");
				final String adTextLine1 = rs.getString("AdTextLine1");
				final String adTextLine2 = rs.getString("AdTextLine2");
				final Long adEngineAdID = rs.getLong("AdEngineAdID");
				final boolean isDeleted = rs.getBoolean("IsDeleted");
				final java.util.Date createdDate = rs.getTimestamp("CreatedDate");
				final java.util.Date deletedDate = rs.getTimestamp("DeletedDate");
				final int adEngineId = rs.getInt("AdvertisingEngineFK");
				final AdEngine adEngine = AdEngine.getAdEngine(adEngineId);
				final AdsObject ad = new AdsObject(promotionAdsPK, promotionFK, adTitle, adTextLine1, adTextLine2, adEngineAdID, isDeleted, createdDate, deletedDate, adEngine);
				return ad;
			}
			
		};
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlReturnResultSet("promotion", promotionObjMapper));
		declareParameter(new SqlReturnResultSet("ads", adsObjMapper));
		declareParameter(new SqlReturnResultSet("geotarget",geoTargetObjectMapper));
		compile();
	}

	/*
	 * store the resits oin a hashmap
	 */
	public Boolean execute(Integer promotionID)
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
					Map<AdEngine,AdEngineID> adEngineData = PromotionAdEngineID.get(promoID);
					AdEngineID data = new AdEngineID();
					data.setAccountID(onePromo.getAdvertisingEngineAccountPK());
					data.setAdGroupID(onePromo.getAdvertisingEngineAdGroupID());
					data.setCampaignID(onePromo.getAdvertisingEngineCampaignPK());
					final AdEngine adEngine = AdEngine.valueOf(onePromo.getAdvertisingEngine());
					adEngineData.put(adEngine, data);
					
				}
				else if (onePromo.getAdvertisingEngine() != null)
				{
					Map<AdEngine,AdEngineID> adEngineData = new HashMap<AdEngine,AdEngineID>();
					AdEngineID data = new AdEngineID();
					data.setAccountID(onePromo.getAdvertisingEngineAccountPK());
					data.setAdGroupID(onePromo.getAdvertisingEngineAdGroupID());
					data.setCampaignID(onePromo.getAdvertisingEngineCampaignPK());					
					final String adEngineAccountNumber = onePromo.getAdvertisingEngineAccountNumber();
					data.setAccountNumber(adEngineAccountNumber);
					final AdEngine adEngine = AdEngine.valueOf(onePromo.getAdvertisingEngine());
					adEngineData.put(adEngine, data);					
					PromotionAdEngineID.put(promoID, adEngineData);
				}				
			}
		}
		return true;
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
	
	public Map<AdEngine,AdEngineID> getPromotionAdEngineID(Integer promotionID)
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