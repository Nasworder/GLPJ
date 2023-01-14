import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class VariCamembert extends JComponent implements AdjustmentListener {

    private final int MAX_VALUE = 200;
    private int firstValue = 150;
    private int secondValue = 175;
    private int thirdValue = 120;

    private JScrollBar redScrollBar;
    private JScrollBar greenScrollBar;
    private JScrollBar blueScrollBar;
    private Camembert camembert;

    public static void run() {
        JFrame frame = new JFrame("VariCamembert");
        VariCamembert variCamembert = new VariCamembert();
        frame.add(variCamembert);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }

    private VariCamembert() {
        setLayout(new FlowLayout());
        Label redLabel = new Label("Rouge");
        Label greenLabel = new Label("Vert");
        Label blueLabel = new Label("Bleu");
        camembert = new Camembert();
        redScrollBar = new JScrollBar(JScrollBar.VERTICAL, firstValue, 0, 0, MAX_VALUE);
        greenScrollBar = new JScrollBar(JScrollBar.VERTICAL, secondValue, 0, 0, MAX_VALUE);
        blueScrollBar = new JScrollBar(JScrollBar.VERTICAL, thirdValue, 0, 0, MAX_VALUE);
        redScrollBar.addAdjustmentListener(this);
        greenScrollBar.addAdjustmentListener(this);
        blueScrollBar.addAdjustmentListener(this);
        add(redLabel);
        add(redScrollBar);
        add(greenLabel);
        add(greenScrollBar);
        add(blueLabel);
        add(blueScrollBar);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        camembert.setSize(getWidth() - 50, getHeight() - 100);
        camembert.setVisible(true);
        camembert.setNewSizes(firstValue, secondValue, thirdValue, 100, 100);
        camembert.paintComponent(g);
    }


    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource() == redScrollBar) {
            firstValue = redScrollBar.getValue();
        } else if (e.getSource() == greenScrollBar) {
            secondValue = greenScrollBar.getValue();
        } else if (e.getSource() == blueScrollBar) {
            thirdValue = blueScrollBar.getValue();
        }
        repaint();
    }
}
