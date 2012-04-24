package semplest.server.service;


/*
 * Template used to inject the appropriate service using Spring
 */
public class SemplestServiceTemplate implements ServiceInterface
{
	private ServiceInterface service;
	/* Spring injectable semplest service
	 * 
	 */
	
	public SemplestServiceTemplate()
	{
		
	}
	public ServiceInterface getService()
	{
		return service;
	}


	public void setService(ServiceInterface service)
	{
		this.service = service;
	}
	
	
	@Override
	public String ServiceGet(String methodName, String jsonStr)
	{
		// TODO Auto-generated method stub
		return "Error calling service implementation";
	}
	
	/*
	 * public static void main(String[] args)
	{
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/Service.xml");
		SemplestServiceTemplate myService = (SemplestServiceTemplate) appContext.getBean("semplestService");
	
		//System.out.println(myService.getService().ServiceGet("Testing the Service injection"));
	}
	 */

}
