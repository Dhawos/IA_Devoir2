package ca.uqac.ia_devoir2.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.PrintStream;

public class MainFrame extends JFrame {

    static final String TITLE = "Sudoku Solver";
    private SudokuBoard sudokuBoard;
    private ControlPanel controlPanel = new ControlPanel();

    public MainFrame() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout(0, 0));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10, 20, 20, 20));

        initLogger(bottomPanel);
        sudokuBoard = new SudokuBoard();
        add(controlPanel, BorderLayout.EAST);
        add(sudokuBoard, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        //setResizable(false);
        setVisible(true);

    }

    private void initLogger(JPanel bottomPanel) {
        EventQueue.invokeLater(() -> {
            LogPanel logPanel = new LogPanel();
            bottomPanel.add(logPanel, BorderLayout.CENTER);

            PrintStream ps = System.out;
            System.setOut(new PrintStream(new StreamLogger("STDOUT", logPanel, ps)));
        });
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }
}
