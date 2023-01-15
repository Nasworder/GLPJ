import javax.swing.*;
import java.awt.*;


public class Display extends JFrame {

    CompassFrame boussoleFrame;
    // constructor
    public Display() {
        // set title
        super("Display");

        setDisplay();

        boussoleFrame = new CompassFrame();
        add(boussoleFrame);


    }

    public void setDisplay(){
        // set layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        // set close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set visible
        setVisible(true);

        setPreferredSize(new Dimension(300, 300));

        pack();
    }

    // method to add components
    public void addComponent(JComponent component) {
        // add component
        add(component);
        // repaint
        repaint();
    }
}
