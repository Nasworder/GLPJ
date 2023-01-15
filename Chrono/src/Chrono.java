import javax.swing.*;
import java.awt.*;

public class Chrono extends JComponent {

    Display frame;

    public Chrono(Display frame) {
        this.frame = frame;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(frame.getColor());
        int value = 0;
        int time = (int) ((double) (frame.getCurrentTime()) / 100 * 360);

        if (frame.getWidth() > frame.getHeight()) {
            value = (int) (frame.getHeight() / 1.5);
            ;
        } else {
            value = (int) (frame.getWidth() / 1.5);
        }

        g.drawOval((getWidth() - value) / 2, (getHeight() - value) / 2, value, value);

        g.fillArc((getWidth() - value) / 2, (getHeight() - value) / 2, value, value, 90, -time);


    }


}
