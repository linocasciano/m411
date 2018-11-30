package lambda;

import java.util.ArrayList;
import java.util.Date;

public class Person {
	
	public Person(String familyName, String firstName, String city) {
		super();
		this.familyName = familyName;
		this.firstName = firstName;
		this.city = city;
	}

	String familyName;
	String firstName;
	String city;
	Date birthDate;
	
	
	
	public static ArrayList<Person> generatePersons() {
		ArrayList<Person> personList = new ArrayList<>();
		Person p = new Person("Huber", "Johannes", "Bern");
		personList.add(p);
		p = new Person("Ziswiler", "Markus", "Luzern");
		personList.add(p);
		p = new Person("Aebi", "Hans", "Solothurn");
		personList.add(p);
		return personList;
	}
	
	public String toString() {
		return familyName + ", " + firstName + " : " + city ;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
