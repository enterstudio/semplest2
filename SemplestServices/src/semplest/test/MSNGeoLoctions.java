package semplest.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import semplest.server.service.springjdbc.SemplestDB;

public class MSNGeoLoctions
{
	public static void main(String[] args)
	{

		try
		{
			BasicConfigurator.configure();
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			//
			File fXmlFile = new File("C:/msn/7103.GeoLocations/Geolocations.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("b:Country");
			System.out.println("-----------------------");

			// go through countries
			for (int countryNum = 0; countryNum < nList.getLength(); countryNum++)
			{

				Node nNode = nList.item(countryNum);
				if (nNode.getNodeType() == Node.ELEMENT_NODE)
				{

					Element countryElement = (Element) nNode;

					String country = getTagValue("b:Name", countryElement);
					if (country.equalsIgnoreCase("United States"))

					{
						System.out.println("Country= " + country);
						System.out.println("Latitude : " + getTagValue("b:Latitude", countryElement));
						//States
						NodeList stateList = countryElement.getElementsByTagName("b:SubGeography");
						for (int stateNum = 0; stateNum < stateList.getLength(); stateNum++)
						{
							Node stateNode = stateList.item(stateNum);
							if (stateNode.getNodeType() == Node.ELEMENT_NODE)
							{
								Element stateElement = (Element) stateNode;
								String state = getTagValue("b:Name", stateElement);
								String state_msnName = getTagValue("b:UniqueName", stateElement);
								String state_longitude = getTagValue("b:Longitude", stateElement);
								String state_latitude = getTagValue("b:Latitude", stateElement);
								String state_locationID = getTagValue("b:LocationId", stateElement);
								System.out.println("State= " + state);
								SemplestDB.addMSNGeolocation(false,true, false,state, state_msnName,Double.valueOf(state_longitude),Double.valueOf(state_latitude),Integer.parseInt(state_locationID),null,
										null,null,state);
								
								//MetroArea
								NodeList metroList = stateElement.getElementsByTagName("b:MetroArea");
								for (int metroNum = 0; metroNum < metroList.getLength(); metroNum++)
								{
									Node metroNode = metroList.item(metroNum);
									if (metroNode.getNodeType() == Node.ELEMENT_NODE)
									{
										Element metroElement = (Element) metroNode;
										String metro = getTagValue("b:Name", metroElement);
										String metro_msnName = getTagValue("b:UniqueName", metroElement);
										String metro_longitude = getTagValue("b:Longitude", metroElement);
										String metro_latitude = getTagValue("b:Latitude", metroElement);
										String metro_locationID = getTagValue("b:LocationId", metroElement);
										System.out.println("Metro= " + metro);
										SemplestDB.addMSNGeolocation(false,false, true,metro, metro_msnName,Double.valueOf(metro_longitude),Double.valueOf(metro_latitude),Integer.parseInt(metro_locationID),null,
												null,null,state);
										//Cities
										NodeList cityList = metroElement.getElementsByTagName("b:City");
										for (int cityNum = 0; cityNum < cityList.getLength(); cityNum++)
										{
											Node cityNode = cityList.item(cityNum);
											if (cityNode.getNodeType() == Node.ELEMENT_NODE)
											{
												Element cityElement = (Element) cityNode;
												String city = getTagValue("b:Name", cityElement);
												String msnName = getTagValue("b:UniqueName", cityElement);
												String longitude = getTagValue("b:Longitude", cityElement);
												String latitude = getTagValue("b:Latitude", cityElement);
												String locationID = getTagValue("b:LocationId", cityElement);
												
												String ParentCountryLocationId = getTagValue("b:ParentCountryLocationId", cityElement);
												String ParentMetroAreaLocationId = getTagValue("b:ParentMetroAreaLocationId", cityElement);
												String ParentSubGeographyLocationId = getTagValue("b:ParentSubGeographyLocationId", cityElement);
												String ParentSubGeographyName = getTagValue("b:ParentSubGeographyName", cityElement);
												
												System.out.println("city= " + city);
												SemplestDB.addMSNGeolocation(true,false, false,city, msnName,Double.valueOf(longitude),Double.valueOf(latitude),Integer.parseInt(locationID),Integer.parseInt(ParentCountryLocationId),
														Integer.parseInt(ParentMetroAreaLocationId),Integer.parseInt(ParentSubGeographyLocationId),ParentSubGeographyName);
											}
										}
										
									}
								}
								
							}
						}

					}

				}
			}

		}
		catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String getTagValue(String sTag, Element eElement)
	{
		if (eElement == null)
		{
			return "";
		}
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}

}
