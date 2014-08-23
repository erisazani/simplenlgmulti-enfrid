import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.Language;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.mapper.WordMapperHelper;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;




public class EnIdSentenceTest {

	public static void main(String[] args) {
		Lexicon enLexicon = new XMLLexicon(Language.ENGLISH);
		Lexicon idLexicon = new XMLLexicon(Language.INDONESIAN);
		
		NLGFactory enFactory = new NLGFactory(enLexicon);
		NLGFactory idFactory = new NLGFactory(idLexicon);
		
		Realiser realiser = new Realiser();
		
		WordMapperHelper mapper = new WordMapperHelper(enLexicon, idLexicon);
		
//		String verb = "take";
		String verb = "read";
//		String verb = "climb";
//		String verb = "spell";
//		String verb = "dig";
//		String verb = "fill";
//		String verb = "fold";
//		String verb = "value";
//		String verb = "sweep";
//		String verb = "cry";
		
		Tense tense;
		boolean progressive;
		boolean perfect;
		boolean negated;
		String output;
	
		// print kalimat dalam bahasa Indonesia
		SPhraseSpec sentenceId = idFactory.createClause();
		sentenceId.setSubject("Alice");
//		sentenceId.setSubject(mapper.map("she"));
		sentenceId.setVerb(mapper.map(verb));
		
		// print kalimat dalam bahasa Inggris
		SPhraseSpec sentenceEn = enFactory.createClause();
		sentenceEn.setSubject("she");
		sentenceEn.setVerb(verb);
		
		for(int i = 0; i < 16; i++) {
			int tmp = i;
			String features = "Features : ";
			if(tmp % 2 == 0) {
				tense = Tense.PRESENT; 
				features = features + "Present-";
			} else {
				tense = Tense.FUTURE;
				features = features + "Future-";
			}
			tmp = tmp / 2;
			if(tmp % 2 == 0)
				progressive = false;
			else {
				progressive = true;
				features = features + "Progressive-";
			}
			tmp = tmp / 2;
			if(tmp % 2 == 0)
				perfect = false;
			else {
				perfect = true;
				features = features + "Perfect-";
			}
			tmp = tmp / 2;
			if(tmp % 2 == 0)
				negated = false;
			else {
				negated = true;
				features = features + "Negated-";
			}
			features = features.substring(0, features.length() - 1);
			System.out.println(features);
			
			sentenceId.setFeature(Feature.TENSE, tense);
			sentenceId.setFeature(Feature.PROGRESSIVE, progressive);
			sentenceId.setFeature(Feature.PERFECT, perfect);
			sentenceId.setFeature(Feature.NEGATED, negated);
			
			output = realiser.realiseSentence(sentenceId);
			System.out.println(output);
			
			sentenceEn.setFeature(Feature.TENSE, tense);
			sentenceEn.setFeature(Feature.PROGRESSIVE, progressive);
			sentenceEn.setFeature(Feature.PERFECT, perfect);
			sentenceEn.setFeature(Feature.NEGATED, negated);
			
			output = realiser.realiseSentence(sentenceEn);
			System.out.println(output);
			
			System.out.println();
		}	
	}
	
}