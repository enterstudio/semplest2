package semplest.server.protocol;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

import org.codehaus.jackson.map.ObjectMapper;

public class ProtocolJSON implements ProtocolOperationsInterface
{
	
	private static  ObjectMapper mapper = null;
	public static final byte SEMplest_REGISTER = 1;
	public static final byte SEMplest_PING = 2;
	public static final byte SEMplest_ERROR = 3;
	public static final byte SEMplest_ACK = 4;
	public static final byte SEMplest_SHUTDOWN = 5;
	
	public ProtocolJSON()
	{
		mapper = new ObjectMapper();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			ProtocolJSON j = new ProtocolJSON();
			
			String testStr = "{ \"header\" : 2 , \"messageQueuePort\" : \"61616\", \"messageQueueIP\" : \"localhost\"}";
			ProtocolSocketDataObject test = j.createSocketDataObjFromJSON(testStr);
			System.out.println(test.getheader());
			System.out.println(j.createJSONFromSocketDataObj(test));
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Json Helper functions
	 * 
	 */
	public <T,S> HashMap<T, S> getHashMapFromJson(String jsonStr) throws Exception
	{
			try
			{
				return mapper.readValue(jsonStr, HashMap.class);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
	}
	public <T> ArrayList<T> getListFromJson(String jsonStr) throws Exception
	{
			try
			{
				return mapper.readValue(jsonStr, ArrayList.class);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
	}
	public <T,S> String createJSONHashmap(HashMap<T,S> map) 
	{
		try
		{
			return mapper.writeValueAsString(map);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public ProtocolSocketDataObject createSocketDataObjFromJSON(String JSONStr) 
	{
		try
		{
			return mapper.readValue(JSONStr, ProtocolSocketDataObject.class);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String createJSONFromSocketDataObj(ProtocolSocketDataObject socketObj)
	{
		try
		{
			return mapper.writeValueAsString(socketObj);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static byte[] createBytePacketFromString(String data)
	{
		ByteBuffer buffer = ByteBuffer.allocate(data.length());
		//if data then append string in bytes
		if (data != null)
		{
			buffer.put(data.getBytes());
		}
		buffer.flip();
		return buffer.array();
	}
	public static String convertbytesToString(byte[] data)
	{
		return new String(data);
	}

	@Override
	public ProtocolMQDataObject createMQDataObjFromJSON(String JSONStr) 
	{
		try
		{
			return mapper.readValue(JSONStr, ProtocolMQDataObject.class);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String createJSONFromMQDataObj(ProtocolMQDataObject MQObj) 
	{
		try
		{
			return mapper.writeValueAsString(MQObj);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
