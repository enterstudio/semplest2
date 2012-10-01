namespace SharedResources.Helpers
{
    public class ReturnState
    {
        public ReturnState(bool isException, bool isValidationError, string reutrnMessage, object returnObject)
        {
            IsException = isException;
            IsValidationError = isValidationError;
            ReturnMessage = reutrnMessage;
            ReturnObject = returnObject;
        }

        public bool IsException { get; set; }
        public bool IsValidationError { get; set; }
        public string ReturnMessage { get; set; }
        public object ReturnObject { get; set; }
    }
}