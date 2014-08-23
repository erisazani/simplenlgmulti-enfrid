
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;



public class SimpleTest {

	public static void main(String[] args) {
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory nlgFactory = new NLGFactory(lexicon);
		//Realiser realiser = new Realiser(lexicon);
		Realiser realiser = new Realiser();
		
		SPhraseSpec sentence = nlgFactory.createClause();
		NPPhraseSpec noun = nlgFactory.createNounPhrase("she");
		VPPhraseSpec verb = nlgFactory.createVerbPhrase("cry");
		sentence.setSubject(noun);
		sentence.setVerb(verb);
		
		String output = realiser.realiseSentence(sentence);
		
		System.out.println(output);
		
	}
}
