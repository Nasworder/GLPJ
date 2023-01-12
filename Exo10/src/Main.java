public class Main {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();

        Field field = new Field(10, 10);
        Animal fox = new Rabbit(false,field, new Location(0, 0));
        //System.out.println(fox.getBreedingAge());




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