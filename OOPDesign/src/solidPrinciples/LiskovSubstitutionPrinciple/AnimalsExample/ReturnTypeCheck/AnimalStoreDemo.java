package solidPrinciples.LiskovSubstitutionPrinciple.AnimalsExample.ReturnTypeCheck;

import solidPrinciples.LiskovSubstitutionPrinciple.AnimalsExample.Model.Animal;
import solidPrinciples.LiskovSubstitutionPrinciple.AnimalsExample.Model.BengalCat;
import solidPrinciples.LiskovSubstitutionPrinciple.AnimalsExample.Model.Cat;
import solidPrinciples.LiskovSubstitutionPrinciple.AnimalsExample.Model.FeedType;

public class AnimalStoreDemo {
	
	// liskov substitution principle: return type check 
	public static void main(String[] args) {
		// this could be better if store.buy from animal store returns a animal, however it cant be possible
		// due this method is returning a bengal cat and animal class is abstract
		AnimalStore store = new AnimalStore();
		Animal animal = store.buy();
		System.out.println(animal.getAnimalName());
		
		store = new CatStore();
		animal = store.buy();
		System.out.println(animal.getFeedType());
		((Cat) animal).eat("Mouse", FeedType.CARNIVORE);
		
		store = new BengalCatStore();
		animal = store.buy();
		System.out.println(animal.getClassification().getSpecie());		
		((BengalCat) animal).hunt();
	}
}
