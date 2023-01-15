import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CompassFrame extends JComponent implements ActionListener, MouseListener {
    private Button nord;
    private Button est;
    private Button ouest;

    private CompassSouth compassSouth;
    private CompassCenter compassCenter;

    public CompassFrame(){
        setLayout(new BorderLayout());
        nord = new Button("nord");
        est = new Button("est");
        ouest = new Button("ouest");
        compassSouth = new CompassSouth();
        compassCenter = new CompassCenter();
        add(nord, BorderLayout.NORTH);
        add(est, BorderLayout.EAST);
        add(ouest, BorderLayout.WEST);
        add(compassSouth, BorderLayout.SOUTH);
        add(compassCenter, BorderLayout.CENTER);
        nord.addActionListener(this);
        est.addActionListener(this);
        ouest.addActionListener(this);
        compassSouth.getSouthEast().addActionListener(this);
        compassSouth.getSouthWest().addActionListener(this);
        compassCenter.getLeftTop().addMouseListener(this);
        compassCenter.getLeftBottom().addMouseListener(this);
        compassCenter.getRightTop().addMouseListener(this);
        compassCenter.getRightBottom().addMouseListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == nord){
            compassSouth.getDirection().setText("Nord");
        }
        if(e.getSource() == est){
            compassSouth.getDirection().setText("Est");
        }
        if(e.getSource() == ouest){
            compassSouth.getDirection().setText("Ouest");
        }
        if(e.getSource() == compassSouth.getSouthEast()){
            compassSouth.getDirection().setText("Sud-Est");
        }
        if(e.getSource() == compassSouth.getSouthWest()){
            compassSouth.getDirection().setText("Sud-Ouest");
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == compassCenter.getLeftTop()){
            compassSouth.getDirection().setText("Nord-Ouest");
        }
        if(e.getSource() == compassCenter.getLeftBottom()){
            compassSouth.getDirection().setText("Sud-Ouest");
        }
        if(e.getSource() == compassCenter.getRightTop()){
            compassSouth.getDirection().setText("Nord-Est");
        }
        if(e.getSource() == compassCenter.getRightBottom()){
            compassSouth.getDirection().setText("Sud-Est");
        }
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
