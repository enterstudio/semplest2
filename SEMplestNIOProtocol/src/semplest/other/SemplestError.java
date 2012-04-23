package semplest.other;

public class SemplestError extends Exception {
	private static final long serialVersionUID = 1L;	
	
	private Error_Level ErrorLevel;
	private String ErrorService;
	private String ErrorMethod;
	private String ErrorMessage;
	private Error_Type ErrorType;
	
	public enum Error_Level {LEVEL_1, LEVEL_2, LEVEL_3, LEVEL_4, LEVEL_5};
	public enum Error_Type {NULL, SEMPLEST_ESB, SEMPLEST_SERVICE, SOAP_GOOGLE, SOAP_MSN};
	
	public SemplestError(){
		
	}
	
	public SemplestError(String serviceName, String methodName, String errorMessage){
		ErrorLevel = Error_Level.LEVEL_1;
		ErrorService = serviceName;
		ErrorMethod = methodName;
		ErrorMessage = errorMessage;
		ErrorType = Error_Type.SEMPLEST_SERVICE;
	}
	
	public SemplestError(Error_Level errorLevel, String serviceName, String methodName, String errorMessage, Error_Type errorType){
		ErrorLevel = errorLevel;
		ErrorService = serviceName;
		ErrorMethod = methodName;
		ErrorMessage = errorMessage;
		ErrorType = errorType;		
	}
	
	public SemplestError(Error_Level errorLevel, String serviceName, String methodName, Exception e, Error_Type errorType) {
		ErrorLevel = errorLevel;
		ErrorService = serviceName;
		ErrorMethod = methodName;
		ErrorMessage = e.getMessage();
		ErrorType = errorType;
	}
	

	public Error_Level getErrorLevel() {
		return ErrorLevel;
	}

	public void setErrorLevel(Error_Level errorLevel) {
		ErrorLevel = errorLevel;
	}

	public String getErrorService() {
		return ErrorService;
	}

	public void setErrorService(String errorService) {
		ErrorService = errorService;
	}

	public String getErrorMethod() {
		return ErrorMethod;
	}

	public void setErrorMethod(String errorMethod) {
		ErrorMethod = errorMethod;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public Error_Type getErrorType() {
		return ErrorType;
	}

	public void setErrorType(Error_Type errorType) {
		ErrorType = errorType;
	}
}
