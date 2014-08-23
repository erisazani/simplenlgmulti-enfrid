package tests;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;

public class TenseTest extends AbstractTest {

	XMLLexicon lex;
	NLGFactory fac;
	Realiser real;
	
	SPhraseSpec clause;
	NPPhraseSpec np1, np2;
	VPPhraseSpec vp;
	
	public TenseTest(Lexicon l, NLGFactory f, Realiser r) {
		lex = (XMLLexicon)l;
		fac = f;
		real = r;

		System.out.println("================================");
		System.out.println("Tests on Tenses");
		System.out.println("================================");
	}
	
	public void reset() {
		clause = fac.createClause();
		np1 = fac.createNounPhrase("ayah");
		vp = fac.createVerbPhrase("makan");
		np2 = fac.createNounPhrase("nasi");
		clause.setSubject("ayah");
		clause.setVerb("makan");
		clause.setObject("nasi");
	}

	public void start() {
		reset();
		presentTense();
		
		reset();
		futureTense();
		
		reset();
		presentProgressiveTense();
		
		reset();
		presentPerfectTense();
		
		reset();
		futureProgressiveTense();
		
		reset();
		futurePerfectTense();
	}

	private void presentTense() {
		clause.setFeature(Feature.TENSE, Tense.PRESENT);
		assertEquals("ayah memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Present Tense Test passed");
	}
	
	private void futureTense() {
		clause.setFeature(Feature.TENSE, Tense.FUTURE);
		assertEquals("ayah akan memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Future Tense Test passed");
	}
	
	private void presentProgressiveTense() {
		clause.setFeature(Feature.TENSE, Tense.PRESENT);
		clause.setFeature(Feature.PROGRESSIVE, true);
		assertEquals("ayah sedang memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Present Progressive Tense Test passed");
	}
	
	private void presentPerfectTense() {
		clause.setFeature(Feature.TENSE, Tense.PRESENT);
		clause.setFeature(Feature.PERFECT, true);
		assertEquals("ayah telah memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Present Perfect Tense Test passed");
	}
	
	private void futureProgressiveTense() {
		clause.setFeature(Feature.TENSE, Tense.FUTURE);
		clause.setFeature(Feature.PROGRESSIVE, true);
		assertEquals("ayah akan sedang memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Future Progressive Tense Test passed");
	}
	
	private void futurePerfectTense() {
		clause.setFeature(Feature.TENSE, Tense.FUTURE);
		clause.setFeature(Feature.PERFECT, true);
		assertEquals("ayah akan telah memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Present Perfect Tense Test passed");
	}
}
