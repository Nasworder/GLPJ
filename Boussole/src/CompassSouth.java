import javax.swing.*;
import java.awt.*;

public class CompassSouth extends JComponent {

    private Button southWest;
    private Button southEast;
    private Label direction;

    public CompassSouth() {
        setLayout(new GridLayout());
        southWest = new Button("sudouest");
        southEast = new Button("sudest");
        direction = new Label("Direction");
        add(southWest);
        add(direction);
        add(southEast);
    }

    public Button getSouthWest() {
        return southWest;
    }

    public Button getSouthEast() {
        return southEast;
    }

    public Label getDirection() {
        return direction;
    }


}
