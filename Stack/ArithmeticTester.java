public class ArithmeticTester {
    public static void main(String[] args) {
        String test = "9 4 * 7 2 6 * + /";
        String test2 = "9 * 4 / ( 7 + 2 + 6 )";
        // System.out.println(Arithmetic.convertClassicToStout(test2));
        System.out.println(Arithmetic.evaluateStout(test));
    }
}
