import javax.swing.*;
import java.awt.*;

public class Camembert extends JComponent {


    private int firstValue = 0;
    private int secondValue = 0;
    private int thirdValue = 0;
    private int xPostion = 0;
    private int yPostion = 0;
    private final int MAX = 360;

    public static void makeTheCamembert(int firstValue, int secondValue, int thirdValue) {
        JFrame frame = new JFrame("Camembert");
        Camembert camembert = new Camembert(firstValue, secondValue, thirdValue);
        frame.add(camembert);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }

    private Camembert(int firstValue, int secondValue, int thirdValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
    }

    Camembert() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int sum = firstValue + secondValue + thirdValue;
        int firstAngle = 0;
        int secondAngle = 0;
        int thirdAngle = 0;
        try {
            firstAngle = (firstValue * MAX) / sum;
            secondAngle = (secondValue * MAX) / sum;
            thirdAngle = (thirdValue * MAX) / sum;
        } catch (ArithmeticException e) {
            System.out.println("Division par 0");
        }

        int value = 0;

        if (getWidth() > getHeight()) {
            value = getHeight() - 20-yPostion;
        } else {
            value = getWidth() - 20-xPostion;
        }

        g.setColor(Color.red);
        g.fillArc(10 + xPostion, 10 + yPostion, value, value, 90, firstAngle);
        g.setColor(Color.green);
        g.fillArc(10 + xPostion, 10 + yPostion, value, value, 90 + firstAngle, secondAngle);
        g.setColor(Color.blue);
        g.fillArc(10 + xPostion, 10 + yPostion, value, value, 90 + firstAngle + secondAngle, thirdAngle);
        g.setColor(Color.black);
        g.drawString("rouge: " + firstValue + ", vert: " + secondValue + ", bleu:" + thirdValue, 10 + xPostion, getHeight() - 10 + yPostion);
    }

    public void setNewSizes(int firstValue, int secondValue, int thirdValue, int xPostion, int yPostion) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
        this.xPostion = xPostion;
        this.yPostion = yPostion;
    }

}
