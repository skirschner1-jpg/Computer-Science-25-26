
public class Arithmetic {

	//Evaluates a String exp that has an arithmetic expression, written in classic notation
	public static int evaluate(String exp) {
		String toSolve = convertClassicToStout(exp);
		return evaluateStout(toSolve);
	}
	
	//Returns the result of doing operand1 operation operand2,
	//e.g. operate(5, 2, "-") should return 3
	public static int operate(int operand1, int operand2, String operation) {
		if (operation.equals("+")) {
			return operand1 + operand2;
		}
		if (operation.equals("-")) {
			return operand1 - operand2;
		}
		if (operation.equals("*")) {
			return operand1 * operand2;
		}
		if (operation.equals("/")) {
			return operand1 / operand2;
		}
		return 0;
	}
	
	//Evaluates a String exp that has an arithmetic expression written in STOUT notation
	public static int evaluateStout(String exp) {
		MyStack stack = new MyStack();
		return evaluateStoutHelper(exp, stack);
		// int index = 0;
		// String currString = "";
		// while (exp.charAt(index) != ' ') {
		// 	currString = currString + exp.charAt(index);
		// 	index++;
		// 	if (index == exp.length()) {
		// 		// do something to exit loop
		// 	}
		// }
		// if (isNum(currString)) {
		// 	int num = Integer.parseInt(currString);
		// 	stack.push(num);
		// }
		// if (currString.length() == 1 && isOp(currString)) {
		// 	stack.push(operate((int) stack.pop(), (int) stack.pop(), currString));
		// }
		// return 0;
	}

	public static int evaluateStoutHelper(String exp, MyStack stack) {
		if (exp.length() == 0) {
			return (int) stack.pop();
		}
		int index = 0;
		String currString = "";
		while (exp.charAt(index) != ' ') {
			currString = currString + exp.charAt(index);
			index++;
			if (index == exp.length()) {
				// do something to exit loop
			}
		}
		// System.out.println(currString);
		if (isNum(currString)) {
			int num = Integer.parseInt(currString);
			stack.push(num);
		}
		if (currString.length() == 1 && isOp(currString)) {
			stack.push(operate((int) stack.pop(), (int) stack.pop(), currString));
		}
		if (index <= exp.length()) {
			return evaluateStoutHelper(exp.substring(index), stack);
		}
		return (int) stack.pop();
	}
	
	public static String convertClassicToStout(String exp) {
		int index = 0;
		MyStack stack = new MyStack();
		String currString = "";
		while (exp.charAt(index) != ' ') {
			currString = currString + exp.charAt(index);
			index++;
			if (index == exp.length()) {
				// do something to exit loop
			}
		}
		// System.out.println(currString);
		if (isNum(currString)) {
			int num = Integer.parseInt(currString);
			stack.push(num);
		}
		if (currString.length() == 1 && isOp(currString)) {
			// need to figure out order they go in or somethingggg
			stack.push(operate((int) stack.pop(), (int) stack.pop(), currString));
		}
		return "";
	}

	//HELPERS
	public static boolean isNum(String num) {
		if (num.length() == 0) {
			return false;
		}
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) != '0' && num.charAt(i) != '1' && num.charAt(i) != '2' && num.charAt(i) != '3'
					&& num.charAt(i) != '4' && num.charAt(i) != '5' && num.charAt(i) != '6' && num.charAt(i) != '7'
					&& num.charAt(i) != '8' && num.charAt(i) != '9') {
				return false;
			}
		}
		return true;
	}

	public static boolean isOp(Object op) {
		if (op != "+" && op != "-" && op != "*" && op != "/") {
			return false;
		}
		return true;
	}

	public static boolean opPrior(Object toAdd, Object inStack) {
		if (giveVal(toAdd) > giveVal(inStack)) {
			return true;
		}
		return false;
		// may be mixing up true and false??
	}
	
	public static int giveVal(Object op){
		if (op == "+" || op == "-") {
			return 1;
		}
		if (op == "*" || op == "/") {
			return 2;
		}
		return 0;
	}
	
	
}
