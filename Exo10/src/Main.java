public class Main {

    private static Simulator simulator;

    public static void main(String[] args) {
        simulator = new Simulator();



        for (int i = 0; i < 50; i++) {
            simulator.simulateOneStep();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}