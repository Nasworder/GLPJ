public class Main {

    private static Simulator simulator;

    public static void main(String[] args) {
        simulator = new Simulator();


/*
        for (int i = 0; i < 50; i++) {
            simulator.simulateOneStep();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

*/

        Animal fox = new Rabbit(false, new Field(10,10), new Location(2, 2));
        System.out.println(fox.getBreedingAge());
        System.out.println(fox.getMaxAge());
        System.out.println(fox.getBreedingProbability());
        System.out.println(fox.getMaxLitterSize());


        simulator.runLongSimulation();

    }
}