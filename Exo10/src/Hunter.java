import java.util.List;

public abstract class Hunter implements Actor, Drawable {

    public abstract void act(List<Actor> newAnimals);

    public abstract boolean isAlive();

    public abstract Location getLocation();

    public abstract void setLocation(Location newLocation);

}
