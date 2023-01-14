import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Wall extends JComponent {

    private static final int HEIGHT = 10;
    private static final int WIDTH = 20;

    public static  void run() {
        JFrame frame= new JFrame("Hello world!");
        Wall wall = new Wall();
        frame.add(wall);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        int i = 0;

        for (int y = HEIGHT; y + HEIGHT * 2 < getHeight(); y += HEIGHT) {
            i++;

            if (i % 2 == 1) {
                for (int x = WIDTH + WIDTH / 2; x + WIDTH * 2 < getWidth(); x += WIDTH) {
                    g.drawRect(x, y, WIDTH, HEIGHT);
                }
            } else {
                for (int x = WIDTH; x + WIDTH * 2 < getWidth(); x += WIDTH) {
                    g.drawRect(x, y, WIDTH, HEIGHT);
                }
            }

        }
    }


}
