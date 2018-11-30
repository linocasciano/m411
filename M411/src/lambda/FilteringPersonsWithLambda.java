package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FilteringPersonsWithLambda {
	
	public static void main(String[] args) {
		ArrayList<Person> persons = Person.generatePersons();
		// using lambdas
		List<Person> berner = persons.stream().filter(p->p.city.equals("Luzern")).collect(Collectors.toList());
		berner.forEach((p)->System.out.println(p));
		
	}
}
