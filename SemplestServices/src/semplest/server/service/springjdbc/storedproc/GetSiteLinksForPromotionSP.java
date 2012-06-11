package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.protocol.adengine.SiteLink;
import semplest.server.service.springjdbc.BaseDB;

public class GetSiteLinksForPromotionSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetSiteLinksForPromotion";
	private static final RowMapper<SiteLink> siteLinkMapper = new BeanPropertyRowMapper<SiteLink>(SiteLink.class);
	private Map<String, Object> results;
	
	public GetSiteLinksForPromotionSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionID", Types.INTEGER));
		declareParameter(new SqlReturnResultSet("sitelinks", siteLinkMapper));
		compile();
	}

	public void execute(Integer promotionID)
	{
		results = super.execute(new Object[] {promotionID});
	}
	
	public List<SiteLink> getSiteLinks()
	{
		final Object result = results.get("sitelinks");
		if (results == null)
		{
			return null;
		}
		else
		{
			final List<SiteLink> siteLinks = (List<SiteLink>)result;
			return siteLinks;
		}
	}
}