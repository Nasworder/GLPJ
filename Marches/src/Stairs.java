import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

public class Stairs extends JComponent implements ActionListener, AdjustmentListener {

    private final int MAX_VALUE = 100;

    private JScrollBar scrollbar;
    private JButton newStairsButton;
    private JButton resetStairsButton;

    private int currentValue = 50;

    ArrayList<Integer> steps = new ArrayList<Integer>();

    public static void run() {
        JFrame frame = new JFrame("Stairs");
        Stairs stairs = new Stairs();
        frame.add(stairs);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }

    private Stairs() {
        steps.add(currentValue);
        setLayout(new FlowLayout());
        scrollbar = new JScrollBar(JScrollBar.HORIZONTAL, currentValue, 0, 0, MAX_VALUE);
        scrollbar.addAdjustmentListener(this);
        add(scrollbar);
        newStairsButton = new JButton("Nouvelle Marche");
        newStairsButton.addActionListener(this);
        add(newStairsButton);
        resetStairsButton = new JButton("Réinitialiser");
        resetStairsButton.addActionListener(this);
        add(resetStairsButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int x = 10;
        int y = 50;
        for (int step : steps) {
            if (y + step < getHeight() - 10 && x + step < getWidth() - 10) {
                g.drawLine(x, y, x + step, y);
                x += step;
                g.drawLine(x, y, x, y + step);
                y += step;
            }else {
                steps.clear();
                repaint();
                break;
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newStairsButton) {
            steps.add(currentValue);
            repaint();
        } else if (e.getSource() == resetStairsButton) {
            steps.clear();
            repaint();
        }
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource() == scrollbar) {
            currentValue = e.getValue();
        }
    }
}
