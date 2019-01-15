package stack;

public class ParseExpressionTest {
	
	public static void main(String[] args) {
		String expresssion = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
		ParseExpression pe = new ParseExpression();
		Integer i = pe.evaluate(expresssion);
		System.out.println(expresssion + " evaluates to " + i);		
		
	}

}
