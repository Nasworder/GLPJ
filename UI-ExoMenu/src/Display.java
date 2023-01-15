import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame implements ActionListener {

    JMenuItem reset;
    JMenuItem exit;
    JMenuItem m1;
    JMenuItem m2;
    JMenuItem m3;

    Button b1;
    Button b2;
    Button b3;
    Button b4;

    JTextArea textArea;



    public Display(){
        // set title
        super("Display");

        setDisplay();

        // menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu control = new JMenu("Controle");
        menuBar.add(control);
        JMenu actions = new JMenu("Actions");
        menuBar.add(actions);
        reset = new JMenuItem("Efface");
        exit = new JMenuItem("Sortie");
        control.add(reset);
        control.add(exit);
        m1 = new JMenuItem("m1");
        m2 = new JMenuItem("m2");
        m3 = new JMenuItem("m3");
        actions.add(m1);
        actions.add(m2);
        actions.add(m3);



        // buttons
        b1 = new Button("b1");
        b2 = new Button("b2");
        b3 = new Button("b3");
        b4 = new Button("b4");



        Box boxNord = Box.createHorizontalBox();
        add(boxNord, BorderLayout.NORTH);
        boxNord.add(b1);
        boxNord.add(new JPanel());
        boxNord.add(b2);

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(4,1));
        panelLeft.add(b3);
        panelLeft.add(b4);
        panelLeft.setPreferredSize(new Dimension(82, 100));
        add(panelLeft, BorderLayout.WEST);


        textArea = new JTextArea();
        textArea.setEditable(false);
        add(textArea);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVisible(true);
        add(scrollPane);

        reset.addActionListener(this);
        exit.addActionListener(this);
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        pack();
    }

    public void setDisplay(){
        // set close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set visible
        setVisible(true);

        setPreferredSize(new Dimension(250, 200));

        setResizable(false);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset){
            textArea.setText("");
        }
        if (e.getSource() == exit){
            System.exit(0);
        }
        if (e.getSource() == m1){
            textArea.append("m1\n");
        }
        if (e.getSource() == m2){
            textArea.append("m2\n");
        }
        if (e.getSource() == m3){
            textArea.append("m3\n");
        }
        if (e.getSource() == b1){
            textArea.append("b1\n");
        }
        if (e.getSource() == b2){
            textArea.append("b2\n");
        }
        if (e.getSource() == b3){
            textArea.append("b3\n");
        }
        if (e.getSource() == b4){
            textArea.append("b4\n");
        }

    }
}
