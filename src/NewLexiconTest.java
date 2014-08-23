import simplenlg.features.Feature;
import simplenlg.features.Form;
import simplenlg.features.InterrogativeType;
import simplenlg.features.Tense;
import simplenlg.framework.CoordinatedPhraseElement;
import simplenlg.framework.Language;
import simplenlg.framework.NLGFactory;
import simplenlg.framework.WordElement;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.phrasespec.AdjPhraseSpec;
import simplenlg.phrasespec.AdvPhraseSpec;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.PPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;


public class NewLexiconTest {

	public static void main(String[] args) {
		final String LEX_PATH_EN = "D:/Skripsi/Engine/simplenlg-EnFr_1.1/src/simplenlg/lexicon/default-lexicon-EN.xml";
		final String LEX_PATH_ID = "D:/Skripsi/Engine/simplenlg-EnFr_1.1/src/simplenlg/lexicon/indonesian/default-lexicon-ID.xml";
					
		Lexicon lex = new XMLLexicon(Language.ENGLISH);
		NLGFactory fac = new NLGFactory(lex);
		Realiser rls = new Realiser();
		
		Lexicon lex_id = new XMLLexicon(Language.INDONESIAN);
		NLGFactory fac_id = new NLGFactory(lex_id);
		Realiser rls_id = new Realiser();
		
		SPhraseSpec sentence;
		NPPhraseSpec np;
		VPPhraseSpec vp;
		NPPhraseSpec onp;
		AdjPhraseSpec adj;
		AdvPhraseSpec adv;
		PPPhraseSpec pp;
		String out;
		
				
		sentence = (SPhraseSpec)fac.createClause();
		np = fac.createNounPhrase("parent");
		vp = fac.createVerbPhrase("read");
		onp = fac.createNounPhrase("magazine");
//		np = fac.createNounPhraseByConceptId("10399491");			// create the phrases
//		vp = fac.createVerbPhraseByConceptId("00625119");			//
//		onp = fac.createNounPhraseByConceptId("03704210");			//
		adj = fac.createAdjectivePhraseByConceptId("00024996");		//
		adv = fac.createAdverbPhraseByConceptId("00033922");		//
		vp.setObject(onp);								// specify the verb
//		vp.setFeature(Feature.FORM, Form.IMPERATIVE);	//
		onp.addModifier(adj);		// specify the object
		onp.setSpecifier("the");	//
		sentence.setSubject(np);								// specify the clause
		sentence.setVerb(vp); 									//
		vp.addPostModifier(adv);							//
//		sentence.setFeature(Feature.FORM, Form.IMPERATIVE);
//		sentence.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.YES_NO);		//
//		sentence.setFeature(Feature.PERFECT, true);
//		sentence.setFeature(Feature.NEGATED, true);	
//		sentence.setFeature(Feature.TENSE, Tense.FUTURE);
		
		out = rls.realiseSentence(sentence);
		System.out.println(out);
		
		sentence = fac_id.createClause();
		np = fac_id.createNounPhraseByConceptId("10399491");			// create the phrases
//		np = fac_id.createNounPhrase("Anto");
		vp = fac_id.createVerbPhraseByConceptId("00625119");			//
		onp = fac_id.createNounPhraseByConceptId("03704210");			//
		adj = fac_id.createAdjectivePhraseByConceptId("00024996");		//
		adv = fac_id.createAdverbPhraseByConceptId("00033922");		//
//		np.addModifier(adj);		// specify the subject
		vp.setObject(onp);								// specify the verb
//		vp.setFeature(Feature.FORM, Form.IMPERATIVE);	//
		onp.addModifier(adj);		// specify the object
//		onp.setSpecifier("the");	//
		sentence.setSubject(np);													// specify the clause
		sentence.setVerb(vp); 														//
		vp.addModifier(adv);												//
//		sentence.setFeature(Feature.FORM, Form.IMPERATIVE);
//		sentence.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.YES_NO);	//
		sentence.setFeature(Feature.PROGRESSIVE, true);
//		sentence.setFeature(Feature.PERFECT, true);
		sentence.setFeature(Feature.NEGATED, true);	
		sentence.setFeature(Feature.TENSE, Tense.FUTURE);
//		sentence.setFeature(Feature.PASSIVE, true);
		
		CoordinatedPhraseElement cp = new CoordinatedPhraseElement(fac_id, adj, adj);
		np.addModifier(cp);
//		sentence.setSubject(cp);
		
		out = rls_id.realiseSentence(sentence);
		System.out.println(out);
	}
}
