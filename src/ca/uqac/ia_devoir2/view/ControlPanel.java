package ca.uqac.ia_devoir2.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ControlPanel extends JPanel {

    JButton startDepthButton = new JButton("Depth Exploration");
    JButton resetButton = new JButton("Reset");

    public ControlPanel() {
        setLayout(new GridLayout(3,1,0,20));
        setBorder(new EmptyBorder(100,10,100,10));
        add(startDepthButton);
        add(new JButton("Other Explo"));
        add(resetButton);
    }

    public JButton getStartDepthButton() {
        return startDepthButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }
}
