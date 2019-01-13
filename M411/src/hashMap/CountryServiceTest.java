package hashMap;

public class CountryServiceTest {

	public static void main(String[] args) {
		CountryService cs = new CountryService();
		System.out.println(cs.getCountryName("BMU"));
		System.out.println(cs.getCountryName("XYZ"));
		
		cs.printCountries();
	}
}
