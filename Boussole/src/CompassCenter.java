import javax.swing.*;
import java.awt.*;

public class CompassCenter extends JComponent {

    private JPanel leftTop;
    private JPanel leftBottom;
    private JPanel rightTop;
    private JPanel rightBottom;


    public CompassCenter() {
        setLayout(new GridLayout(2, 2));
        leftTop = new JPanel();
        leftBottom = new JPanel();
        rightTop = new JPanel();
        rightBottom = new JPanel();
        leftTop.setBorder(BorderFactory.createLineBorder(Color.black));
        leftBottom.setBorder(BorderFactory.createLineBorder(Color.black));
        rightTop.setBorder(BorderFactory.createLineBorder(Color.black));
        rightBottom.setBorder(BorderFactory.createLineBorder(Color.black));
        add(leftTop);
        add(rightTop);
        add(leftBottom);
        add(rightBottom);
    }

    public JPanel getLeftTop() {
        return leftTop;
    }

    public JPanel getLeftBottom() {
        return leftBottom;
    }

    public JPanel getRightTop() {
        return rightTop;
    }

    public JPanel getRightBottom() {
        return rightBottom;
    }

}
