import java.util.ArrayList;

public class TransporterRoom extends Room {

    private ArrayList<Room> rooms;

    public TransporterRoom(String description) {
        super(description);
        rooms = new ArrayList<Room>();
    }

    @Override
    public void setExit(String direction, Room neighbor){
        rooms.add(neighbor);
        super.setExit(direction, null);
    }

    @Override
    public Room getExit(String direction){
        int index = (int)(Math.random() * rooms.size());
        return rooms.get(index);
    }
}
