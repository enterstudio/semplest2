package experiment.analyze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.JSONValue;

import semplest.keywords.javautils.TextUtils;

public class Searcher
{

	private int minLengthOfValidContent = 5;
	private Set<String> nextLevelSearchUrls = new HashSet<String>();

	public static void main(String[] args)
	{
		try
		{
			String homepageUrl = "http://susansilverantiques.com/";

			Searcher s = new Searcher();

			String content = s.getContentOfWebsite(homepageUrl);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getContentOfWebsite(String homepageUrl) throws Exception
	{
		String allContent = "";

		Set<String> allUrls = getUrlsOfWebsite(homepageUrl);
		for (String url : allUrls)
		{
			String htmlContent = processHTML(url);
			if (!htmlContent.isEmpty())
			{
				allContent = allContent + htmlContent;
			}
		}

		return allContent;
	}

	public Set<String> getUrlsOfWebsite(String startUrl) throws Exception
	{
		String searchTerm = "site:" + startUrl;

		Set<String> returnUrls = new HashSet<String>();
		String Referer = "http://www.semplest.com";

		returnUrls.add(startUrl);
		nextLevelSearchUrls.add(startUrl);
		while (!nextLevelSearchUrls.isEmpty())
		{
			Set<String> foundUrls = new HashSet<String>();
			for (String url : nextLevelSearchUrls)
			{
				searchTerm = "site:" + url;
				URL googleUrl = new URL("https://ajax.googleapis.com/ajax/services/search/web?v=1.0&" + "q=" + searchTerm + "&userip=USERS-IP-ADDRESS");
				URLConnection connection = googleUrl.openConnection();
				connection.addRequestProperty("Referer", Referer);

				String line;
				StringBuilder builder = new StringBuilder();
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null)
				{
					builder.append(line);
				}

				JSONObject json = new JSONObject(builder.toString());
				if (!json.get("responseData").equals(null))
				{
					JSONObject jsonResponseData = json.getJSONObject("responseData");
					JSONArray jsonArray = jsonResponseData.getJSONArray("results");

					for (int i = 0; i < jsonArray.length(); i++)
					{
						JSONObject item = jsonArray.getJSONObject(i);
						String jsonUrl = (String) item.get("url");
						foundUrls.add(jsonUrl);
					}
				}
			}
			if (!foundUrls.isEmpty())
			{
				nextLevelSearchUrls.addAll(foundUrls);
			}
			nextLevelSearchUrls.removeAll(returnUrls);
			returnUrls.addAll(nextLevelSearchUrls);
		}

		return returnUrls;
	}

	public String processHTML(String url) throws Exception
	{
		System.out.println(url);
		String htmlContent = "";
		try
		{
			htmlContent = TextUtils.HTMLText(url);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		String[] lines = htmlContent.split("\n");
		String validContent = "";
		for (String line : lines)
		{
			String[] words = line.trim().split("\\W");
			int count = 0;
			for (String s : words)
			{
				if (!s.isEmpty())
					count++;
			}
			if (count > minLengthOfValidContent)
			{
				validContent = validContent + " ## " + line.trim();
			}
		}

		return validContent;
	}
}
