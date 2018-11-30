package lambda;

public class Lambda {

	public static void main(String[] args) {
		Runnable r = () -> System.out.println("Hello, word!");
		r.run();

	}

}
