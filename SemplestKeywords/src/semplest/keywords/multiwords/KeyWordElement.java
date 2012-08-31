package semplest.keywords.multiwords;

public class KeyWordElement
{

	private String[] wordList;

	public KeyWordElement(String s)
	{
		this.wordList = s.split("\\s+");
	}

}
