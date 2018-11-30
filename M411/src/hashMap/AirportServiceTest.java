package hashMap;


public class AirportServiceTest {

	public static void main(String[] args) {
		
		AirportService airportservice = new AirportService("/users/capa/airports.csv");
		String key = "JFK";
		System.out.println("[" + key + "] = [" + airportservice.search(key) + "]");
		
		airportservice.printAirports();
		
		airportservice.remove(key);
		System.out.println("[" + key + "] = [" + airportservice.search(key) + "]");
		

	}

}
