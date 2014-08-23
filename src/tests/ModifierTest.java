package tests;

import simplenlg.features.Feature;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.phrasespec.AdjPhraseSpec;
import simplenlg.phrasespec.AdvPhraseSpec;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;

public class ModifierTest extends AbstractTest {
	XMLLexicon lex;
	NLGFactory fac;
	Realiser real;
	
	SPhraseSpec clause;
	NPPhraseSpec np1, np2;
	VPPhraseSpec vp;
	AdjPhraseSpec adjp;
	AdvPhraseSpec advp;
	
	public ModifierTest(Lexicon l, NLGFactory f, Realiser r) {
		lex = (XMLLexicon)l;
		fac = f;
		real = r;

		System.out.println("================================");
		System.out.println("Tests on Modifier");
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
		adjectiveTest();
		
		reset();
		adverbTest();
		
	}
	
	private void adjectiveTest() {
		adjp = fac.createAdjectivePhrase("putih");
		np2.addModifier(adjp);
		assertEquals("nasi putih", real.realise(np2).getRealisation());
		System.out.println("Adjective Test passed");
	}
	
	private void adverbTest() {
		advp = fac.createAdverbPhrase("dengan cepat");
		clause.addModifier(advp);
		assertEquals("ayah memakan nasi dengan cepat", real.realise(clause).getRealisation());
		System.out.println("Adverb Test passed");
	}
}
