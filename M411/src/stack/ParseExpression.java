package stack;

public class ParseExpression {

	MyStack operand = new MyStack();
	MyStack operator = new MyStack();

	public Integer evaluate(String s) {
		StringBuffer digits = new StringBuffer();
		boolean isDigit = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
				isDigit = false;
				break;
			case ')':
				isDigit = false;
				StringBuffer sb = new StringBuffer();
				sb.append(operand.pop());
				// TODO evaluate the number of arguments the operand takes
				sb.append(operand.pop());
				sb.append(operand.pop());
				continue;
			case '+':
			case '-':
			case '*':
			case '/':
				isDigit = false;
				operator.push(c);
				continue;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				isDigit = true;
				digits.append(c);
				default : 
					System.out.println("Paring error");
					System.out.println("Unrecognized character");
			}
			
			if (!isDigit && digits.length()>0) {
				Integer ii = Integer.parseInt(digits.toString());
				operand.push(ii.toString());
				digits.delete(0, digits.length()-1);
			}
		}
		System.out.println("Finshed parsing string");
		return null;
	}

	private String evaluateExpression(String s) {
		System.out.println("Evaluating expresssion [" + s + "]");
		return null;
	}
}
