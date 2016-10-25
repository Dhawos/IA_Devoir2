package ca.uqac.ia_devoir2.view;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

public class SudokuBoard extends JPanel implements Observer{

    public static final int BOARD_ROWS = 9;
    public static final int BOARD_COLUMNS = 9;
    private JFormattedTextField fields[][];

    public SudokuBoard() {
        setBorder(new EmptyBorder(4, 4, 4, 4));
        fields = new JFormattedTextField[BOARD_ROWS][BOARD_COLUMNS];

        setLayout(new GridLayout(1, 1, 2, 2));
        add(createBoard());


    }

    protected JPanel createBoard() {
        JPanel panel = new JPanel(new GridLayout(3, 3, 2, 2));
        panel.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY, 2), new EmptyBorder(2, 2, 2, 2)));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int rowIndex = row * 3;
                int colIndex = col * 3;
                panel.add(createSubBoard(rowIndex, colIndex));
            }
        }
        return panel;
    }

    protected JPanel createSubBoard(int startRow, int startCol) {
        JPanel panel = new JPanel(new GridLayout(3, 3, 2, 2));
        panel.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 2), new EmptyBorder(2, 2, 2, 2)));

        populateFields(startRow, startCol);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                panel.add(fields[row + startRow][col + startCol]);
            }
        }
        return panel;
    }

    protected void populateFields(int startRow, int startCol) {
        Font font = new Font("SansSerif", Font.BOLD, 20);

        NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(9);

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                fields[row][col] = new JFormattedTextField(formatter);
                fields[row][col].setFont(font);
                fields[row][col].setHorizontalAlignment(JTextField.CENTER);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public JTextField[][] getFields() {
        return fields;
    }
}