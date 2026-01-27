public class ArithmeticTester {
    public static void main(String[] args) {
        String test = "9 4 * 7 2 6 * + /";
        String test2 = "9 * 4 / ( 7 + 2 * 6 )";
        String test3 = "3 + 5 * 2 - 4";
        String test4 = "91 * 4 / ( 7 + 2 * 6 ) + 9";
        // should be: 3 5 2 * + 4 - 
        System.out.println(Arithmetic.convertClassicToStout(test4));
        // System.out.println(Arithmetic.evaluateStout(test));
    }
}
