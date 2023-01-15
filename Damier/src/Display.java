import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Display extends JFrame implements ActionListener, ComponentListener, MouseListener {


    Button clear;
    Draw draw;
    JPanel panel;

    JRadioButton red;
    JRadioButton blue;
    JRadioButton green;

    // constructor
    public Display() {
        // set title
        super("Damier");

        setDisplay();

        draw = new Draw(this, 4, 3);
        add(draw);
        draw.setPreferredSize(new Dimension(getWidth(), getHeight() - 60));


        ButtonGroup group = new ButtonGroup();


        red = new JRadioButton("rouge");
        blue = new JRadioButton("bleu");
        green = new JRadioButton("vert");

        group.add(red);
        group.add(blue);
        group.add(green);
        group.setSelected(red.getModel(), true);

        panel = new JPanel();
        panel.add(red);
        panel.add(blue);
        panel.add(green);

        add(panel);
        panel.setPreferredSize(new Dimension(getWidth(), 30));


        clear = new Button("efface");
        add(clear);
        clear.setPreferredSize(new Dimension(getWidth(), 30));

        this.setVisible(true);

        draw.paintComponent(getGraphics());

        addComponentListener(this);

        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        clear.addActionListener(this);

        draw.addMouseListener(this);
    }


    public void setDisplay() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        // set close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set visible
        setVisible(true);

        setPreferredSize(new Dimension(500, 300));

        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == red) {
            draw.setColor(Color.RED);
        } else if (e.getSource() == blue) {
            draw.setColor(Color.BLUE);
        } else if (e.getSource() == green) {
            draw.setColor(Color.GREEN);
        } else if (e.getSource() == clear) {
            draw.clear();
            draw.repaint();
        }
    }


    @Override
    public void componentResized(ComponentEvent e) {
        draw.setPreferredSize(new Dimension(getWidth(), getHeight() - 60));
        draw.setWithAndHeight();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        draw.setPreferredSize(new Dimension(getWidth(), getHeight() - 60));
        draw.setWithAndHeight();
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {
;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        draw.setXToPaint(e.getX());
        draw.setYToPaint(e.getY());
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
