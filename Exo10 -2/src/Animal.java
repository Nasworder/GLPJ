import java.util.List;
import java.util.Random;

public abstract class Animal implements Actor {
    protected boolean alive;


    protected int age;
    protected static final Random rand = Randomizer.getRandom();


    public Animal(boolean randomAge) {


        alive = true;
        age = 0;
        if(randomAge) {
            age = rand.nextInt(getMaxAge());
        }
    }


    public boolean isAlive(){
        return alive;
    }



    protected boolean canBreed()
    {
        return age >= getBreedingAge();
    }

    protected abstract int getBreedingAge();

    protected void incrementAge()
    {
        age++;
        if(age > getMaxAge()) {
            setDead();
        }
    }

    protected abstract int getMaxAge();

    protected int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

    protected abstract double getBreedingProbability();

    protected abstract int getMaxLitterSize();



    public abstract void act(List<Actor> newAnimals);

    protected abstract void setDead();



}
