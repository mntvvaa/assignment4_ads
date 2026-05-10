public class Main {

    public static void main(String[] args) {

        Experiment experiment = new Experiment();

        experiment.runMultipleTests();
        experiment.runDijkstraTest();
        experiment.printResults();
    }
}