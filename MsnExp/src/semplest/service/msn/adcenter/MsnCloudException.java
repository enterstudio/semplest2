package semplest.service.msn.adcenter;

import org.datacontract.schemas._2004._07.microsoft_adcenter_advertiser_campaignmanagement_api_datacontracts.GoalError;

import com.microsoft.adapi.AdApiError;
import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.api.customermanagement.exception.ApiFault;
import com.microsoft.adcenter.v8.AnalyticsApiFaultDetail;
import com.microsoft.adcenter.v8.ApiFaultDetail;
import com.microsoft.adcenter.v8.EditorialApiFaultDetail;
import com.microsoft.adcenter.v8.EditorialError;

public class MsnCloudException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MsnCloudException(Exception e) {
		super(e);
	}
	
	public MsnCloudException(AdApiFaultDetail e) {
		super("AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " adApi errors: " + e.getErrors().toString());
	}
	
	public MsnCloudException(AnalyticsApiFaultDetail e) {
		super("AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " operation errors: " + e.getOperationErrors().toString() + " goal errors: " + e.getGoalErrors().toString());
	}
	
	public MsnCloudException(ApiFault e) {
		super("AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " operation errors: " + e.getOperationErrors().toString());
	}
	
	public MsnCloudException(ApiFaultDetail e) {
		super("AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " operation errors: " + e.getOperationErrors().toString() + " batch errors: " + e.getBatchErrors().toString());
	}
	
	public MsnCloudException(EditorialApiFaultDetail e) {
		super("AdCenter ApplicationFault trackingId=" + e.getTrackingId() + " batch errors: " + e.getBatchErrors().toString() + " editorial errors: " + e.getEditorialErrors().toString() + " operation errors: " + e.getOperationErrors().toString());
	}
	
	public MsnCloudException(String string) {
		super(string);
	}
	
	public MsnCloudException(String string, NumberFormatException e) {
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
			sb.append("batch: ").append(error.getBatchErrors().toString());
			sb.append("step: ").append(error.getStepErrors().toString());
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
	
	private static String toString(com.microsoft.adcenter.api.customermanagement.exception.OperationError[] errors) {
		if (errors.length == 0) {
			return "<no OperationErrors>";
		}
		StringBuilder sb = new StringBuilder();
		for (com.microsoft.adcenter.api.customermanagement.exception.OperationError error : errors) {
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
