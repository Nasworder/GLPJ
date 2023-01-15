import javax.swing.*;
import java.awt.*;

public class Hourglass extends JComponent {

    Display frame;

    public Hourglass(Display frame) {
        this.frame = frame;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int time = (int) ((double) (frame.getCurrentTime()) / 100 * 150);
        int height = (int) (frame.getHeight() / 1.5);
        int width = frame.getWidth() / 3;
        g.setColor(frame.getColor());

        g.drawRect((getWidth() - width) / 2, (getHeight() - height) / 2, width, height);

        g.fillRect((getWidth() - width) / 2, (getHeight() - height) / 2 + time, width, 150 - time);
        g.fillRect((getWidth() - width) / 2, (getHeight() - height) / 2 + height - time, width, time);
    }
}
