package semplest.server.protocol;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface ProtocolOperationsInterface
{
	public ProtocolSocketDataObject createSocketDataObjFromJSON(String JSONStr)  throws JsonParseException, JsonMappingException, IOException;
	public String createJSONFromSocketDataObj(ProtocolSocketDataObject socketObj) throws JsonGenerationException, JsonMappingException, IOException;
	
	public ProtocolMQDataObject createMQDataObjFromJSON(String JSONStr)  throws JsonParseException, JsonMappingException, IOException;
	public String createJSONFromMQDataObj(ProtocolMQDataObject MQObj) throws JsonGenerationException, JsonMappingException, IOException;


}
