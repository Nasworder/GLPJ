import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


enum Card {
    AS, DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI
}


enum Color {
    PIQUE, COEUR, CARREAU, TREFLE
}


public class CardDraw extends JComponent implements ActionListener {


    private Button drawButton;
    private Label cardNameLabel;


    private Boolean firstDraw = true;

    public static void run() {
        JFrame frame = new JFrame("CardDraw");
        CardDraw cardDraw = new CardDraw();
        frame.add(cardDraw);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private CardDraw() {
        setLayout(new FlowLayout());
        drawButton = new Button("Draw");
        drawButton.addActionListener(this);
        add(drawButton);
        cardNameLabel = new Label("Pas de carte tiré ! Veuillez cliquer sur le bouton !");
        add(cardNameLabel);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == drawButton) {

            if (firstDraw) {
                firstDraw = false;
                Card card = Card.values()[(int) (Math.random() * Card.values().length)];
                cardNameLabel.setText(card.toString());
            } else {
                firstDraw = true;
                Color color = Color.values()[(int) (Math.random() * Color.values().length)];
                cardNameLabel.setText(cardNameLabel.getText() + " de " + color.toString());
            }


        }

    }

}
