package semplest.server.protocol.msn;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import semplest.server.protocol.RetriableOperation;
import semplest.server.protocol.google.MsnEditorialApiFaultDetail;
import semplest.util.SemplestUtils;

import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.v8.EditorialApiFaultDetail;
import com.microsoft.adcenter.v8.EditorialError;

public abstract class AbstractRetriableMsnOperation<T> implements RetriableOperation<T>
{
	private static final Logger logger = Logger.getLogger(AbstractRetriableMsnOperation.class);
	
	protected final Integer maxRetries;
	
	protected AbstractRetriableMsnOperation(final Integer maxRetries)
	{
		this.maxRetries = maxRetries;
	}

	@Override
	public T performOperation() throws Exception 
	{			
		for (int i = 1; i <= maxRetries; ++i)
		{
			try 
			{
				logger.info("Attempt #" + i);
				return porformCustomOperation();					
			}
			catch (AdApiFaultDetail e)
			{
				throw new RemoteException(e.dumpToString(), e);
			}
			catch (EditorialApiFaultDetail e)
			{
				handleEditorialApiFaultDetailException(e);
			}
		}
		throw new Exception("Problem performing operation because maximum num of retries reached [" + maxRetries + "]");
	}
	
	protected abstract T porformCustomOperation() throws AdApiFaultDetail, EditorialApiFaultDetail, RemoteException;
	
	protected abstract void filterRequest(final List<MsnEditorialApiFaultDetail> msnList);
	
	protected void handleEditorialApiFaultDetailException(final EditorialApiFaultDetail e) throws RemoteException
	{
		final String errMsg = "Problem performing operation because MSN encountered content that it doesn't accept: " + e.dumpToString();
		final List<MsnEditorialApiFaultDetail> msnList = getMsnEditorialApiFaultDetail(e);			
		logger.error(errMsg + "\n" + SemplestUtils.getEasilyReadableString(msnList));
		if (msnList.isEmpty())
		{
			throw new RemoteException(errMsg + ". Turns out the problem happened not because of illegal content, but something else, so will not retry", e);
		}
		filterRequest(msnList);
	}
	
	public static Set<Integer> getIndexesOfBadItems(final List<MsnEditorialApiFaultDetail> msnList)
	{
		final Set<Integer> badIndeces = new HashSet<Integer>();
		for (final MsnEditorialApiFaultDetail faultDetail : msnList)
		{
			final Integer index = faultDetail.getIndex();
			badIndeces.add(index);
		}
		return badIndeces;
	}
	
	public List<MsnEditorialApiFaultDetail> getMsnEditorialApiFaultDetail(final EditorialApiFaultDetail e)
	{
		final List<MsnEditorialApiFaultDetail> msnList = new ArrayList<MsnEditorialApiFaultDetail>();
		final EditorialError[] editorialErrors = e.getEditorialErrors();
		for (final EditorialError editorialError : editorialErrors)
		{
			final Integer code = editorialError.getCode();
			final String errorCode = editorialError.getErrorCode();
			final Integer index = editorialError.getIndex();
			final String disapprovedText = editorialError.getDisapprovedText();
			final String message = editorialError.getMessage();
			final String publisherCountry = editorialError.getPublisherCountry();
			final MsnEditorialApiFaultDetail msnFaultDetails = new MsnEditorialApiFaultDetail(code, errorCode, index, disapprovedText, message, publisherCountry);
			msnList.add(msnFaultDetails);
		}
		return msnList;
	}
}