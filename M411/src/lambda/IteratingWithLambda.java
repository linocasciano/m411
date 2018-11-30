package lambda;

import java.util.ArrayList;
import java.util.Collections;

public class IteratingWithLambda {

	public static void main(String[] args) {
		ArrayList<Person> persons = Person.generatePersons();
		// shortcutting iterations
	    persons.forEach((p) -> System.out.println(p));
	    
		
		
	}

}
