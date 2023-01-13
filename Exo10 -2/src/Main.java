public class Main {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();





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