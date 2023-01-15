import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame implements ActionListener{

    private Button red;
    private Button blue;
    private Button green;
    private Button change;
    private JScrollBar scrollBar;

    private Color color;

    private int currentTime;

    private Chrono chrono;
    private Hourglass hourglass;

    private boolean chronoSelected;


    public Display() {
        super("Damier");
        color = Color.RED;

        setDisplay();
        chronoSelected = true;

        chrono = new Chrono(this);
        hourglass = new Hourglass(this);

        currentTime = 10;

        red = new Button("Rouge");
        blue = new Button("Bleu");
        green = new Button("Vert");
        change = new Button("Change");
        scrollBar = new JScrollBar(JScrollBar.VERTICAL, currentTime, 0, 0, 100);


        Box box = Box.createHorizontalBox();
        box.add(red);
        box.add(blue);
        box.add(green);
        add(box, BorderLayout.NORTH);
        add(change, BorderLayout.SOUTH);
        add(scrollBar, BorderLayout.EAST);


        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        change.addActionListener(this);
        scrollBar.addAdjustmentListener(e -> {
            currentTime = e.getValue();
            repaint();
        });

        add(chrono);


        pack();

    }

    public void setDisplay() {

        setLayout(new BorderLayout());
        // set close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set visible
        setVisible(true);

        setPreferredSize(new Dimension(500, 500));

        pack();

    }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == red) {
                color = Color.RED;
            } else if (e.getSource() == blue) {
                color = Color.BLUE;
            } else if (e.getSource() == green) {
                color = Color.GREEN;
            } else if (e.getSource() == change) {
                switchChrono();
            }

            repaint();

        }

        public Color getColor() {
            return color;
        }

        public int getCurrentTime() {
            return currentTime;
        }


        public void switchChrono() {
            if (chronoSelected) {
                remove(chrono);
                add(hourglass);
                chronoSelected = false;
            } else {
                remove(hourglass);
                add(chrono);
                chronoSelected = true;
            }
            repaint();
            pack();
        }

}

