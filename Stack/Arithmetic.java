
public class Arithmetic {

	//Evaluates a String exp that has an arithmetic expression, written in classic notation
	public static int evaluate(String exp) {
		String toSolve = convertClassicToStout(exp);
		return evaluateStout(toSolve);
	}
	
	//Returns the result of doing operand1 operation operand2,
	//e.g. operate(5, 2, "-") should return 3
	public static int operate(int operand1, int operand2, String operation) {
		System.out.println(operand1 + operation + operand2);
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
		// System.out.println(exp);
		if (exp.length() == 0) {
			return (int) stack.pop();
		}
		int index = 0;
		String currString = "";
		while (exp.charAt(index) != ' ') {
			// System.out.println("here");
			currString = currString + exp.charAt(index);
			index++;
			if (index == exp.length()) {
				int int2 = (int) stack.pop();
				int int1 = (int) stack.pop();
				return operate(int1, int2, currString); // assuming it's properly formatted
			}
		}
		if (exp.charAt(index) == ' ') {
			index++;
		}
		// if (currString.equals("(")) {
			
		// }
		// System.out.println(currString);
		if (isNum(currString)) {
			// System.out.println("here");
			int num = Integer.parseInt(currString);
			stack.push(num);
		}
		if (currString.length() == 1 && isOp(currString)) {
			// System.out.println("here");
			int int2 = (int) stack.pop();
			int int1 = (int) stack.pop();
			stack.push(operate(int1, int2, currString));
		}
		// System.out.println(exp.length());
		// System.out.println(index);
		if (index >= exp.length()) {
			// System.out.println("here2");
			return (int) stack.pop();
		}
		// if (index < exp.length()) {
		// 	System.out.println("here2");
		// 	System.out.println(exp.length());
		// 	System.out.println(index);

		// }
		return evaluateStoutHelper(exp.substring(index), stack);
	}
	
	public static String convertClassicToStout(String exp) {
		String main = "";
		MyStack ops = new MyStack();
		String toReturn = convertClassicToStoutHelper(exp, main, ops, false);
		return toReturn.substring(0, toReturn.length() - 1);
	}
	
	public static String convertClassicToStoutHelper(String exp, String main, MyStack ops, boolean inParen) {
		// System.out.println("NEW ROUND");
		// System.out.println(inParen);
		// System.out.println(main);
		// System.out.println(exp);
		// System.out.println(ops);
		int index = 0;
		String currString = "";
		while (exp.charAt(index) != ' ') {
			currString = currString + exp.charAt(index);
			index++;
			if (index == exp.length()) {
				break;
			}
		}
		if (isNum(currString)) {
			int num = Integer.parseInt(currString);
			main = main + num + " ";
		}
		// System.out.println(currString);
		if (index == exp.length()) {
			// if (isNum(currString)) {
			// 	main = main + currString;
			// }
			String op = (String) ops.peek();
			if (currString.equals(")")) {
				// System.out.println("HERE IN THE IF STATEMENTTTTT");
				while (!ops.peek().equals("(")) {
					main = main + ops.pop() + " ";
				}
				ops.pop();
				// System.out.println(main + " peek " + ops.peek());
				inParen = false;
			}
			if (isOp(currString)) {
				if (op == null) {
					ops.push(currString);
				}
				if (op != null) {
					if (giveVal(currString, inParen) >= giveVal(op, inParen)) {
						ops.push(currString);
					} else {
						String thisOp = (String) ops.pop();
						while (giveVal(currString, inParen) <= giveVal(thisOp, inParen)
								&& giveVal(thisOp, inParen) != 0) {
							main = main + thisOp + " ";
							thisOp = (String) ops.pop();
						}
						ops.push(currString);
					}
				}
			}
			String op2 = "";
			while (!ops.empty()) {
				// System.out.println(ops.peek());
				if (ops.peek() == null) {
					op2 = null;
				} else {
					op2 = (String) ops.pop();
				}
				main = main + op2 + " ";
			}
			return main;
		}
		// System.out.println("CURRSTRING: " + currString);
		if (exp.charAt(index) == ' ') {
			index++;
		}
		if (currString.equals("(")) {
			ops.push(currString);
			// System.out.println("HERE IN THE IF STATEMENTTTTT");
		}
		if (currString.equals(")")) {
			// System.out.println("HERE IN THE IF STATEMENTTTTT");
			while (!ops.peek().equals("(")) {
				main = main + ops.pop() + " ";
			}
			ops.pop();
			// System.out.println(main + " peek " + ops.peek());
			inParen = false;
		}
		// if (isNum(currString)) {
		// 	int num = Integer.parseInt(currString);
		// 	main = main + num;
		// }
		if (currString.length() == 1 && isOp(currString)) {
			// System.out.println("here");
			if (ops.empty()) {
				ops.push(currString);
			} else {
				String op = (String) ops.peek();
				if (op == null) {
					ops.push(currString);
				}
				if (op != null) {
					if (giveVal(currString, inParen) > giveVal(op, inParen)) {
						ops.push(currString);
					} else {
						String thisOp = (String)ops.pop();
						while (giveVal(currString, inParen) <= giveVal(thisOp, inParen)) {
							main = main + thisOp + " ";
							thisOp = (String) ops.pop();
						}
						ops.push(currString);
					}
				}
			}
		}
		if (index <= exp.length()) {
			return convertClassicToStoutHelper(exp.substring(index), main, ops, inParen);
		}
		return main;
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

	public static boolean isOp(String op) {
		char opChar = op.charAt(0);
		if (opChar != '+' && opChar != '-' && opChar != '*' && opChar != '/' && opChar != '^' && opChar != '%') {
			return false;
		}
		return true;
	}

	public static boolean isParen(Object op) {
		if (op != "(" && op != ")") {
			return false;
		}
		return true;
	}

	// public static boolean opPrior(Object toAdd, Object inStack) {
	// 	if (giveVal(toAdd) > giveVal(inStack)) {
	// 		return true;
	// 	}
	// 	return false;
	// 	// may be mixing up true and false??
	// }
	
	public static int giveVal(String op, boolean inParen) {
		// System.out.println("GIVE VAL");
		// System.out.println(op);
		if (op == null) {
			return 0;
		}
		char opChar = op.charAt(0);
		int toReturn = 0;
		if (opChar == '+' || opChar == '-') {
			toReturn += 1;
		}
		if (opChar == '*' || opChar == '/' || opChar == '%') {
			toReturn += 2;
		}
		if (opChar == '^') {
			toReturn += 3;
		}
		// if (opChar == '(' || opChar == ')') {
		// 	toReturn += 4;
		// }
		if (inParen) {
			toReturn += 10;
		}
		// System.out.println("GIVE VAL");
		// System.out.println(op);
		// System.out.println(toReturn);
		return toReturn;
	}
	
	public static String addSpaces(String original) {
		int index = 0;
		String toReturn = "";
		while (index < original.length()) {
			toReturn = toReturn + original.charAt(index);
			toReturn = toReturn + " ";
			index++;
		}
		return toReturn.substring(0, toReturn.length() - 1);
	}
	
	// NEEDED: ), ^, /, +, :), *, -, %, (
	
	
}
