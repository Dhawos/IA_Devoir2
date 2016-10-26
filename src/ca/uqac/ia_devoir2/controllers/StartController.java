package ca.uqac.ia_devoir2.controllers;

import ca.uqac.ia_devoir2.explorations.DepthExploration;
import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StartController extends MouseAdapter {
    private SudokuGrid sudokuGrid;

    public StartController(SudokuGrid sudokuGrid) {
        this.sudokuGrid = sudokuGrid;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            switch (button.getText()) {
                case "Depth Exploration":
                    Thread t = new Thread(new DepthExploration(sudokuGrid));
                    t.start();
                    break;
                case "Reset":
                    sudokuGrid.resetGrid();
                default:
                    break;
            }
        }
    }
}
