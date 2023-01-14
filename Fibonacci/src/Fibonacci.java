import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fibonacci extends JComponent implements ActionListener {

    private TextField textField;
    private Label resultLabel;

    public static void run() {
        JFrame frame = new JFrame("Fibonacci");
        Fibonacci fibonacci = new Fibonacci();
        frame.add(fibonacci);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private Fibonacci() {
        setLayout(new FlowLayout());
        textField = new TextField();
        add(textField);
        textField.setColumns(20);
        textField.addActionListener(this);
        resultLabel = new Label("Entrez un nombre");
        add(resultLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textField) {
            try {
                int number = Integer.parseInt(textField.getText());
                resultLabel.setText(printFibonacci(number));
            } catch (NumberFormatException exception) {
                resultLabel.setText("Entrez un nombre");
            }


        }
    }

    // print fibonacci series up to n
    private static String printFibonacci(int n) {
        int first = 0, second = 1, next;
        int i = 0;
        while (true) {

            if (i <= 1)
                next = i;
            else {
                next = first + second;
                first = second;
                second = next;
            }


            if (next > n) {
                if (n != first) {
                    return "Pas dans la liste";
                }

                return "Résultat: " + next;
            }
            i++;
        }
    }

}
