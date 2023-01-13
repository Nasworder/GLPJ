import java.util.List;

public  class Ant extends Animal {

    public Ant(boolean randomAge) {
        super(randomAge);
    }

    @Override
    protected int getBreedingAge() {
        return 0;
    }

    @Override
    protected int getMaxAge() {
        return 0;
    }

    @Override
    protected double getBreedingProbability() {
        return 0;
    }

    @Override
    protected int getMaxLitterSize() {
        return 0;
    }

    @Override
    public void act(List<Actor> newAnimals) {

    }

    @Override
    public void setDead() {

    }


}