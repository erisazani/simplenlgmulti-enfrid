package tests;

import simplenlg.features.Feature;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;

public class NegationTest extends AbstractTest {
	XMLLexicon lex;
	NLGFactory fac;
	Realiser real;
	
	SPhraseSpec clause;
	NPPhraseSpec np1, np2;
	VPPhraseSpec vp;
	
	public NegationTest(Lexicon l, NLGFactory f, Realiser r) {
		lex = (XMLLexicon)l;
		fac = f;
		real = r;

		System.out.println("================================");
		System.out.println("Test on Negation");
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
		
		clause.setFeature(Feature.NEGATED, true);
		assertEquals("ayah tidak memakan nasi", real.realise(clause).getRealisation());
		System.out.println("Negation Test passed");
	}
}
