package semplest.server.protocol.msn;

import java.util.Arrays;
import java.util.List;

import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.GoalError;
import org.w3c.dom.Element;

import semplest.util.SemplestUtils;

import com.microsoft.adapi.AdApiError;
import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
import com.microsoft.adcenter.v8.AnalyticsApiFaultDetail;
import com.microsoft.adcenter.v8.ApiFaultDetail;
import com.microsoft.adcenter.v8.EditorialApiFaultDetail;
import com.microsoft.adcenter.v8.EditorialError;

public class MsnCloudException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MsnCloudException(Exception e) {
		super("Problem", e);
	}
	
	public MsnCloudException(String string, AdApiFaultDetail e) {
		super(string + " because AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " adApi errors: " + toString(e.getErrors()), e);
	}
	
	public MsnCloudException(String string, AnalyticsApiFaultDetail e) {
		super(string + " because AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " operation errors: " + toString(e.getOperationErrors()) + " goal errors: " + toString(e.getGoalErrors()), e);
	}
	
	public static String getApiFaultString(ApiFault e)
	{		
		final String faultActor = e.getFaultActor();
		final String faultReason = e.getFaultReason();
		final String faultRole = e.getFaultRole();
		final String faultString = e.getFaultString();
		final Element[] faultDetails = e.getFaultDetails();
		final String faultDetailsString;
		if (faultDetails != null)
		{
			final List<Element> faultDetailsList = Arrays.asList(faultDetails);
			faultDetailsString = SemplestUtils.getEasilyReadableString(faultDetailsList);
		}
		else
		{
			faultDetailsString = "";
		}		
		final String apiFaultString = "Fault Actor [" + faultActor + "], Fault Reason [" + faultReason + "], Fault Role [" + faultRole + "], Fault String [" + faultString + "], Fault Details [" + faultDetailsString + "]";
		return apiFaultString;
	}
	
	public MsnCloudException(String string, ApiFault e) 
	{
		super(string + " because AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " operation errors: " + toString(e.getOperationErrors()) + "\nOther Details:\n" + getApiFaultString(e), e);				
	}
	
	public MsnCloudException(String string, ApiFaultDetail e) {
		super(string + " because AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " operation errors: " + toString(e.getOperationErrors()) + " batch errors: " + toString(e.getBatchErrors()), e);
	}
	
	public MsnCloudException(String string, EditorialApiFaultDetail e) {
		super(string + " because AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " batch errors: " + toString(e.getBatchErrors()) + " editorial errors: " + toString(e.getEditorialErrors()) + " operation errors: " + toString(e.getOperationErrors()), e);
	}
	
	public MsnCloudException(String string) {
		super(string);
	}
	
	public MsnCloudException(String string, Exception e) {
		super(string, e);
	}
	
	private static String toString(EditorialError[] errors) {
		if (errors.length == 0) {
			return "<no EditorialErrors>";
		}
		StringBuilder sb = new StringBuilder();
		for (EditorialError error : errors) {
			sb.append("[code=").append(error.getCode()).append(" errorcode=").append(error.getErrorCode()).append(" index=").append(error.getIndex()).append("] ");
			sb.append(" appealable=").append(error.getAppealable()).append(" ");
			sb.append(" disapprovedText=").append(error.getDisapprovedText()).append(" ");
			sb.append(" message=").append(error.getMessage()).append(" ");
			sb.append(" publisherCountry=").append(error.getPublisherCountry()).append(" ");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private static String toString(GoalError[] errors) {
		if (errors.length == 0) {
			return "<no GoalErrors>";
		}
		StringBuilder sb = new StringBuilder();
		for (GoalError error : errors) {
			sb.append("goal error index=").append(error.getIndex()).append(" [");
			sb.append("batch: ").append(toString(error.getBatchErrors()));
			sb.append("step: ").append(toString(error.getStepErrors()));
			sb.append("]");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private static String toString(AdApiError[] errors) {
		if (errors.length == 0) {
			return "<no AdApiErrors>";
		}
		StringBuilder sb = new StringBuilder();
		for (AdApiError error : errors) {
			sb.append("[code=").append(error.getCode()).append(" errorcode=").append(error.getErrorCode()).append("] ");
			sb.append("'").append(error.getDetail()).append("'").append(" ");
			sb.append("'").append(error.getMessage()).append("'").append(" ");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private static String toString(com.microsoft.adcenter.api.customermanagement.Exception.OperationError[] errors) {
		if (errors.length == 0) {
			return "<no OperationErrors>";
		}
		StringBuilder sb = new StringBuilder();
		for (com.microsoft.adcenter.api.customermanagement.Exception.OperationError error : errors) {
			sb.append("[").append(error.getCode()).append("]").append(" ");
			sb.append("'").append(error.getDetails()).append("'").append(" ");
			sb.append("'").append(error.getMessage()).append("'").append(" ");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private static String toString(com.microsoft.adcenter.v8.OperationError[] errors) {
		if (errors.length == 0) {
			return "<no OperationErrors>";
		}
		StringBuilder sb = new StringBuilder();
		for (com.microsoft.adcenter.v8.OperationError error : errors) {
			sb.append("[code=").append(error.getCode()).append(" errorcode=").append(error.getErrorCode()).append("] ");
			sb.append("'").append(error.getDetails()).append("'").append(" ");
			sb.append("'").append(error.getMessage()).append("'").append(" ");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private static String toString(com.microsoft.adcenter.v8.BatchError[] errors) {
		if (errors.length == 0) {
			return "<no BatchErrors>";
		}
		StringBuilder sb = new StringBuilder();
		for (com.microsoft.adcenter.v8.BatchError error : errors) {
			sb.append("[code=").append(error.getCode()).append(" errorcode=").append(error.getErrorCode()).append(" index=").append(error.getIndex()).append("] ");
			sb.append("'").append(error.getDetails()).append("'").append(" ");
			sb.append("'").append(error.getMessage()).append("'").append(" ");
			sb.append("\n");
		}
		return sb.toString();
	}
}
