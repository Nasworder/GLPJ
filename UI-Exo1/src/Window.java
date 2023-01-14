import javax.swing.*;
import java.awt.*;

public class Window extends JComponent {


    public static void displayWindow() {
        JFrame frame= new JFrame("Hello world!");
        Window figures = new Window();
        frame.add(figures);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawOval(100, 100, 400, 400);
        g.setColor(Color.BLACK);
        g.drawOval(175, 175, 75, 75);
        g.drawOval(350, 175, 75, 75);
        g.setColor(Color.PINK);
        g.fillOval(185, 185, 55, 55);
        g.fillOval(360, 185, 55, 55);
        g.fillArc(200, 300, 200, 100, 180, 180);
        g.setColor(Color.BLACK);
        g.drawArc(200, 300, 200, 100, 180, 180);

    }

}
