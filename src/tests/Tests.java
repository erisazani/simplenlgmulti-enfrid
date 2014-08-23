package tests;

import simplenlg.framework.Language;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.realiser.Realiser;


public class Tests {

	XMLLexicon lexId = new XMLLexicon(Language.INDONESIAN);
	XMLLexicon lexEn = new XMLLexicon(Language.ENGLISH);
	NLGFactory facId = new NLGFactory(lexId);
	NLGFactory facEn = new NLGFactory(lexEn);
	Realiser realId = new Realiser();
	Realiser realEn = new Realiser();
	
	TenseTest tenseTest = new TenseTest(lexId, facId, realId);
	NegationTest negationTest = new NegationTest(lexId, facId, realId);
	ModifierTest modifierTest = new ModifierTest(lexId, facId, realId);
	SentenceTypeTest sentenceTypeTest = new SentenceTypeTest(lexId, facId, realId);
	
	MorphologyTest morphologyTest = new MorphologyTest(lexId, facId, realId);
	ConceptIDTest conceptIDTest = new ConceptIDTest(lexId, facId, lexEn, facEn);
	
	IntegratedTest integatedTest = new IntegratedTest();
	
	public Tests() {
		tenseTest.start();
		negationTest.start();
		modifierTest.start();
		sentenceTypeTest.start();
		
		morphologyTest.start();
		conceptIDTest.start();
	}	
}
