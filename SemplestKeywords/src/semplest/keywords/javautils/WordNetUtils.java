package semplest.keywords.javautils;

import edu.smu.tspell.wordnet.AdjectiveSynset;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.smu.tspell.wordnet.WordSense;

/**
 * Example code to make use of the Wordnet dictionary to obtain related words
 * 
 * @author lluis
 * 
 */
public class WordNetUtils
{
	private final static String[] SYNSET_TYPES = { "", "noun", "verb" };

	public static void main(String[] args)
	{
		System.setProperty("wordnet.database.dir", "/usr/local/WordNet-3.0/dict");
		NounSynset nounSynset;
		NounSynset[] hyponyms;
		// Example 1
		WordNetDatabase database = WordNetDatabase.getFileInstance();
		Synset[] synsets = database.getSynsets("fly", SynsetType.NOUN);
		for (int i = 0; i < synsets.length; i++)
		{
			nounSynset = (NounSynset) (synsets[i]);
			hyponyms = nounSynset.getHyponyms();
			System.out.println(nounSynset.getWordForms()[0] + ": " + nounSynset.getDefinition() + ") has " + hyponyms.length + " hyponyms");
		}
		// Example 2
		String word = "level";
		System.out.println("Synsets for :" + word);
		synsets = database.getSynsets(word);
		for (Synset synset : synsets)
		{
			System.out.println("\nsynset type: " + synset.getType());
			System.out.println(" definition: " + synset.getDefinition());
			// word forms are synonyms:
			for (String wordForm : synset.getWordForms())
			{
				if (!wordForm.equals(word))
				{
					System.out.println(" synonym: " + wordForm);
					// antonyms mean the opposite:
					for (WordSense antonym : synset.getAntonyms(wordForm))
					{
						for (String opposite : antonym.getSynset().getWordForms())
						{
							System.out.println(" antonym (of " + wordForm + "): " + opposite);
						}
					}
				}
			}
			if (synset instanceof NounSynset)
			{
				nounSynset = (NounSynset) synset;
				hyponyms = nounSynset.getHyponyms();
				for (NounSynset hyponym : hyponyms)
				{
					for (String wordForm : hyponym.getWordForms())
					{
						System.out.println("hyponim: " + wordForm);
					}
				}
				NounSynset[] hyperonims = nounSynset.getHypernyms();
				for (NounSynset hyperonim : hyperonims)
				{
					for (String wordForm : hyperonim.getWordForms())
					{
						System.out.println("hyperonim: " + wordForm);
					}
				}
			}
			if (synset instanceof AdjectiveSynset)
			{
				AdjectiveSynset adjSynset = (AdjectiveSynset) synset;
				AdjectiveSynset[] relatedAdj = adjSynset.getRelated();
				for (AdjectiveSynset rel : relatedAdj)
				{
					for (String wordForm : rel.getWordForms())
					{
						System.out.println("related: " + wordForm);
					}
				}
			}
		}
	}

}
