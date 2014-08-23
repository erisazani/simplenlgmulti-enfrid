import java.util.List;

import simplenlg.framework.*;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.french.XMLLexicon;
//import simplenlg.realiser.english.Realiser;
import simplenlg.realiser.Realiser;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

public class TestMain {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory nlgFactory = new NLGFactory(lexicon);
		simplenlg.realiser.english.Realiser realiser = 
				new simplenlg.realiser.english.Realiser();
//		Realiser realiser = new Realiser();
		SPhraseSpec sp = nlgFactory.createClause();
		sp.setSubject("the cat");
		sp.setVerb("leave");
		sp.setObject("the house");
		
		sp.setFeature(Feature.TENSE, Tense.PAST);
		System.out.println("Elided : " + sp.getFeatureAsBoolean(Feature.ELIDED));
		List<NLGElement> children = sp.getChildren();
		for(NLGElement el : children) {
			System.out.println("class=" + el.getClass() + " " + el);
			//System.out.println("category=" + el.getCategory() + " " + el);
			//System.out.println("pronominal=" + el.getFeatureAsBoolean(Feature.PRONOMINAL).booleanValue() + " " + el);
		}
		String output4 = realiser.realiseSentence(sp);
		System.out.println(output4);
		
		VPPhraseSpec vb = nlgFactory.createVerbPhrase("leave");
		//vb.setFeature(Feature.FORM, Form.GERUND);
		vb.setFeature(Feature.TENSE, Tense.PAST);
		System.out.println();
		System.out.println("form=" + vb.getFeatureAsString(Feature.FORM));
		System.out.println("modal=" + vb.getFeatureAsString(Feature.MODAL));
		System.out.println("particle=" + vb.getFeature(Feature.PARTICLE));
		System.out.println("particle=" + (vb instanceof NLGElement));
		System.out.println(realiser.realise(vb).getRealisation());
		/*sp.setFeature(Feature.NEGATED, true);
		String output7 = realiser.realiseSentence(sp);
		System.out.println(output7);
		
		sp.setFeature(Feature.TENSE, Tense.PRESENT);
		sp.setFeature(Feature.NEGATED, false);
		String output5 = realiser.realiseSentence(sp);
		System.out.println(output5);
		sp.setFeature(Feature.NEGATED, true);
		String output8 = realiser.realiseSentence(sp);
		System.out.println(output8);
		
		// Interrogative type, using another phrase sp2
		SPhraseSpec sp2 = nlgFactory.createClause();
		sp2.setSubject("the cat");
		sp2.setVerb("leave");
		sp2.setObject("the house");
		
		sp2.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.YES_NO);
		String output9 = realiser.realiseSentence(sp2);
		System.out.println(output9);
		sp2.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.WHAT_OBJECT);
		String output10 = realiser.realiseSentence(sp2);
		System.out.println(output10);
		sp2.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.WHO_OBJECT);
		String output11 = realiser.realiseSentence(sp2);
		System.out.println(output11);
		sp2.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.WHY);
		String output12 = realiser.realiseSentence(sp2);
		System.out.println(output12);
		
		// Adding complements, using phrase sp
		sp.setFeature(Feature.TENSE, Tense.PRESENT);
		sp.setFeature(Feature.NEGATED, false);
		sp.addComplement("silently");
		sp.addComplement("because of the angry dog");
		String output13 = realiser.realiseSentence(sp);
		System.out.println(output13);
		
		// Adding adjectives & adverbs
		NPPhraseSpec subj = nlgFactory.createNounPhrase("Anto");
		VPPhraseSpec verb = nlgFactory.createVerbPhrase("eat");
		NPPhraseSpec obj = nlgFactory.createNounPhrase("cake");
		
		subj.addModifier("fat");
		verb.addModifier("quickly");
		obj.addModifier("delicious");
		
		SPhraseSpec sp3 = nlgFactory.createClause();
		sp3.setSubject(subj);
		sp3.setVerb(verb);
		sp3.setObject(obj);
		
		String output14 = realiser.realiseSentence(sp3);
		System.out.println(output14);
		
		// Adding multiple subjects and objects
		NPPhraseSpec subj2 = nlgFactory.createNounPhrase("his", "cousin");
		CoordinatedPhraseElement subjs = nlgFactory.createCoordinatedPhrase(subj, subj2);
		
		NPPhraseSpec obj2 = nlgFactory.createNounPhrase("pudding");
		NPPhraseSpec obj3 = nlgFactory.createNounPhrase("ice cream");
		CoordinatedPhraseElement objs = nlgFactory.createCoordinatedPhrase(obj, obj2);
		objs.addCoordinate(obj3);
		
		sp3.setSubject(subjs);
		sp3.setVerb(verb);
		sp3.setObject(objs);
		String output15 = realiser.realiseSentence(sp3);
		System.out.println(output15);
		
		Lexicon lex = new XMLLexicon();
        NLGFactory factory = new NLGFactory(lex);
        Realiser real = new Realiser();
        
		NPPhraseSpec theMan = factory.createNounPhrase("le", "homme");
        NPPhraseSpec theCrowd = factory.createNounPhrase("le", "foule");
        
        SPhraseSpec greeting = factory.createClause(theMan, "saluer", theCrowd);
        
        String outString = real.realiseSentence(greeting);
        System.out.println(outString);*/
	}
}
