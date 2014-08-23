package tests;

import simplenlg.features.Feature;
import simplenlg.features.Form;
import simplenlg.features.InterrogativeType;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;

public class MorphologyTest extends AbstractTest {
	XMLLexicon lex;
	NLGFactory fac;
	Realiser real;
	
	SPhraseSpec clause;
	NPPhraseSpec np1, np2;
	VPPhraseSpec vp;
	
	public MorphologyTest(Lexicon l, NLGFactory f, Realiser r) {
		lex = (XMLLexicon)l;
		fac = f;
		real = r;

		System.out.println("================================");
		System.out.println("Tests on Morphology");
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
		prefixMeTest();
		
		reset();
		suffixLahTest();
	}

	private void prefixMeTest() {
		assertEquals("ayah memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Morphology : Prefix me- Test passed");
	}

	private void suffixLahTest() {
		clause.setFeature(Feature.FORM, Form.IMPERATIVE);
		vp.setFeature(Feature.FORM, Form.IMPERATIVE);
		assertEquals("makanlah nasi", real.realise(clause).getRealisation());
		System.out.println("Morphology : Suffix -lah Test passed");
	}
}
