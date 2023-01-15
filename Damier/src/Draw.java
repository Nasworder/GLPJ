import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Draw extends JComponent {

    private int maxRectX;
    private int maxRectY;
    private int width;
    private int height;
    private JFrame frame;

    private int heightRect;
    private int widthRect;

    private Color color;

    private int xToPaint;
    private int yToPaint;


    private Map<Integer, Color> paintedRects;


    public Draw(JFrame frame, int maxRectX, int maxRectY) {
        paintedRects = new HashMap<Integer, Color>();
        xToPaint = -1;
        yToPaint = -1;
        color = Color.RED;
        this.frame = frame;
        this.maxRectX = maxRectX;
        this.maxRectY = maxRectY;
        setWithAndHeight();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int count = 0;

        for (int y = 0; y < maxRectY; y++) {
            for (int x = 0; x < maxRectX; x++) {
                if (paintedRects.containsKey(count)) {
                    g.setColor(paintedRects.get(count));
                    g.fillRect(x * widthRect, y * heightRect, widthRect, heightRect);
                }

                if (xToPaint >= x * widthRect && xToPaint <= x * widthRect + widthRect && yToPaint >= y * heightRect && yToPaint <= y * heightRect + heightRect) {
                    g.setColor(color);
                    g.fillRect(x * widthRect, y * heightRect, widthRect, heightRect);
                    paintedRects.put(count, color);
                } else {
                    g.setColor(Color.BLACK);
                    g.drawRect(x * widthRect, y * heightRect, widthRect, heightRect);
                }

                count++;
            }
        }
    }

    public void setWithAndHeight() {
        width = frame.getWidth() - 15;
        height = frame.getHeight() - 100;
        calculateRect();
    }

    public void calculateRect() {
        heightRect = height / maxRectY;
        widthRect = width / maxRectX;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setXToPaint(int xToPaint) {
        this.xToPaint = xToPaint;
    }

    public void setYToPaint(int yToPaint) {
        this.yToPaint = yToPaint;
    }

    public void clear() {
        paintedRects.clear();
        xToPaint = -1;
        yToPaint = -1;
    }
}
