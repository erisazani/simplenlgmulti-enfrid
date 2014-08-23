package demo;

import simplenlg.features.Feature;
import simplenlg.features.InterrogativeType;
import simplenlg.features.Tense;
import simplenlg.framework.Language;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.phrasespec.AdjPhraseSpec;
import simplenlg.phrasespec.AdvPhraseSpec;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;

public class MiniDemo {
	
	XMLLexicon lex_id, lex_en;
	NLGFactory fac_id, fac_en;
	Realiser realiser;
	
	SPhraseSpec clause;
	NPPhraseSpec nounPh1, nounPh2;
	VPPhraseSpec verbPh1;
	AdjPhraseSpec adjPh1;
	AdvPhraseSpec advPh1;
	
	public MiniDemo() {
		lex_id = new XMLLexicon(Language.INDONESIAN);
		lex_en = new XMLLexicon(Language.ENGLISH);
		
		fac_id = new NLGFactory(lex_id);
		fac_en = new NLGFactory(lex_en);
		
		realiser = new Realiser();
	}
	
	private void generateExampleSentence1() { // apakah ayah akan membeli buku baru dengan tergesa-gesa?
		clause = fac_id.createClause();
		nounPh1 = fac_id.createNounPhrase("ayah");
		nounPh2 = fac_id.createNounPhrase("buku");
		verbPh1 = fac_id.createVerbPhrase("beli");
		adjPh1 = fac_id.createAdjectivePhrase("baru");
		advPh1 = fac_id.createAdverbPhrase("dengan tergesa-gesa");
		
		clause.setSubject(nounPh1);
		clause.setVerb(verbPh1);
		verbPh1.setObject(nounPh2);
		nounPh2.addModifier(adjPh1);
		verbPh1.addModifier(advPh1);
		clause.setFeature(Feature.TENSE, Tense.FUTURE);
		clause.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.YES_NO);
		System.out.println(realiser.realiseSentence(clause));
	}
	
	private void generateExampleSentence2() { // nelayan sedang menangkap ikan; fisherman is capturing whale
		clause = fac_id.createClause();
		nounPh1 = fac_id.createNounPhraseByConceptId("10093658");
		nounPh2 = fac_id.createNounPhraseByConceptId("02062744");
		verbPh1 = fac_id.createVerbPhraseByConceptId("02272549");
		
		clause.setSubject(nounPh1);
		clause.setVerb(verbPh1);
		verbPh1.setObject(nounPh2);
		clause.setFeature(Feature.PROGRESSIVE, true);
		System.out.println(realiser.realiseSentence(clause));
		
		//--------------------------------------------------------
		
		clause = fac_en.createClause();
		nounPh1 = fac_en.createNounPhraseByConceptId("10093658");
		nounPh2 = fac_en.createNounPhraseByConceptId("02062744");
		verbPh1 = fac_en.createVerbPhraseByConceptId("02272549");
		
		clause.setSubject(nounPh1);
		clause.setVerb(verbPh1);
		verbPh1.setObject(nounPh2);
		clause.setFeature(Feature.PROGRESSIVE, true);
		System.out.println(realiser.realiseSentence(clause));
	}

//	private void generateExampleSentence3() {
//		clause = fac_id.createClause();
//		nounPh1 = fac_id.createNounPhrase();
//		nounPh2 = fac_id.createNounPhrase();
//		verbPh1 = fac_id.createVerbPhrase();
//		
//		clause.setSubject(nounPh1);
//		clause.setVerb(verbPh1);
//		verbPh1.setObject(nounPh2);
//	}
	
	public void start() {
		generateExampleSentence1();		
		generateExampleSentence2();		
//		generateExampleSentence3();		
	}
}
