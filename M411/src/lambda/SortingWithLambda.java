package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;

public class SortingWithLambda {

	public static void main(String[] args) {
		
		// generate a list of persons
		ArrayList<Person> persons = Person.generatePersons();

		// sort them using the pre java 8 comparator
		Collections.shuffle(persons);
		Collections.sort(persons, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getFamilyName().compareTo(p2.getFamilyName());
			}
		});

		persons.forEach((p) -> System.out.println(p));
		System.out.println("---");

		// sort them using lambdas
		persons.sort((p1, p2) -> p1.familyName.compareTo(p2.familyName));
		persons.forEach((p) -> System.out.println(p));
		System.out.println("---");

		// sort them using a named method
		Collections.shuffle(persons);
		persons.sort(comparing(Person::getFamilyName));
		persons.forEach((p) -> System.out.println(p));
		System.out.println("---");
	}

}
