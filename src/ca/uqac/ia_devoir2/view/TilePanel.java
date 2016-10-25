package ca.uqac.ia_devoir2.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TilePanel extends JPanel implements Observer {

    private int xPos;
    private int yPos;
    private JLabel label = new JLabel("");

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }


    public TilePanel(int x, int y) {
        xPos = x;
        yPos = y;
        add(label);
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.black));
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
