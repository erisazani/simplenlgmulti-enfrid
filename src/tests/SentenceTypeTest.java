package tests;

import simplenlg.features.Feature;
import simplenlg.features.Form;
import simplenlg.features.InterrogativeType;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.phrasespec.AdjPhraseSpec;
import simplenlg.phrasespec.AdvPhraseSpec;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;

public class SentenceTypeTest extends AbstractTest {
	XMLLexicon lex;
	NLGFactory fac;
	Realiser real;
	
	SPhraseSpec clause;
	NPPhraseSpec np1, np2;
	VPPhraseSpec vp;
	
	public SentenceTypeTest(Lexicon l, NLGFactory f, Realiser r) {
		lex = (XMLLexicon)l;
		fac = f;
		real = r;

		System.out.println("================================");
		System.out.println("Tests on Sentence Type");
		System.out.println("================================");
	}
	
	public void reset() {
		clause = fac.createClause();
		np1 = fac.createNounPhrase("ayah");
		vp = fac.createVerbPhrase("makan");
		np2 = fac.createNounPhrase("nasi");
		clause.setSubject(np1);
		clause.setVerb(vp);
		clause.setObject(np2);
	}

	public void start() {
		reset();
		declarativeTest();
		
		reset();
		imperativeTest();

		reset();
		interrogativeYesNoTest();
	}

	private void declarativeTest() {
		assertEquals("ayah memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Declarative Sentence Test passed");
	}

	private void imperativeTest() {
		clause.setFeature(Feature.FORM, Form.IMPERATIVE);
		vp.setFeature(Feature.FORM, Form.IMPERATIVE);
		assertEquals("makanlah nasi", real.realise(clause).getRealisation());
		System.out.println("Imperative Sentence Test passed");
	}
	
	private void interrogativeYesNoTest() {
		clause.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.YES_NO);
		assertEquals("apakah ayah memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Interrogative Yes/No Sentence Test passed");
	}
}
