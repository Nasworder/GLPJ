import java.util.List;

public class Hunter implements Actor, Drawable {

    protected Location location;
    protected Field field;

    public void act(List<Actor> newAnimals) {

    }

    public boolean isAlive() {
        return false;
    }

    public Location getLocation() {
        return location;
    }




    public void setLocation(Location newLocation) {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }


    protected Field getField()
    {
        return field;
    }

    protected void setField(Field field)
    {
        this.field = field;
    }

}
