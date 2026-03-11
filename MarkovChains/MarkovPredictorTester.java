public class MarkovPredictorTester {

    public static void main(String[] args) {
        MarkovPredictor test = new MarkovPredictor();
        test.readData("weather.csv");
        System.out.println(test.getLists());
        String nextState = "Sunny";
        for (int i = 0; i < 100; i++) {
            nextState = test.predictNextState(nextState);
            System.out.println(nextState);
        }
    }
}
