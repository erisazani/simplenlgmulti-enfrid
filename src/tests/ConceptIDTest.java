package tests;

import simplenlg.features.Feature;
import simplenlg.features.Form;
import simplenlg.framework.NLGFactory;
import simplenlg.framework.WordElement;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.Realiser;

public class ConceptIDTest extends AbstractTest {
	XMLLexicon lexId;
	NLGFactory facId;
	XMLLexicon lexEn;
	NLGFactory facEn;
	
	NPPhraseSpec np1;
	VPPhraseSpec vp;
	
	public ConceptIDTest(Lexicon l, NLGFactory f, Lexicon l2, NLGFactory f2) {
		lexId = (XMLLexicon)l;
		facId = f;
		lexEn = (XMLLexicon)l2;
		facEn = f2;

		System.out.println("================================");
		System.out.println("Tests on Concept ID Usage");
		System.out.println("================================");
	}
	
	public void reset() {
	}

	public void start() {
		reset();
		indoLexiconTest();
		
		reset();
		englishLexiconTest();
	}

	private void indoLexiconTest() {
		np1 = facId.createNounPhraseByConceptId("10399491");
		vp = facId.createVerbPhraseByConceptId("00625119");
		
		assertEquals("ayah", ((WordElement)np1.getHead()).getBaseForm());
		assertEquals("baca", ((WordElement)vp.getHead()).getBaseForm());
		System.out.println("Indonesian Phrase Creation By Concept ID Test passed");
	}

	private void englishLexiconTest() {
		np1 = facEn.createNounPhraseByConceptId("10399491");
		vp = facEn.createVerbPhraseByConceptId("00625119");
		
		assertEquals("parent", ((WordElement)np1.getHead()).getBaseForm());
		assertEquals("read", ((WordElement)vp.getHead()).getBaseForm());
		System.out.println("English Phrase Creation By Concept ID Test passed");
	}
}
