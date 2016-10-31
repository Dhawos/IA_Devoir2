package ca.uqac.ia_devoir2.controllers;

import ca.uqac.ia_devoir2.explorations.BruteForceExploration;
import ca.uqac.ia_devoir2.explorations.DepthExploration;
import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StartController extends MouseAdapter {
    private DepthExploration depthExploration;
    private BruteForceExploration bruteForceExploration;
    private SudokuGrid sudokuGrid;

    public StartController(SudokuGrid sudokuGrid, DepthExploration depthExploration, BruteForceExploration bruteForceExploration) {
        this.sudokuGrid = sudokuGrid;
        this.depthExploration = depthExploration;
        this.bruteForceExploration = bruteForceExploration;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            switch (button.getText()) {
                case "Depth Exploration":
                    Thread t1 = new Thread(depthExploration);
                    t1.start();
                    break;
                case "BruteForce Exploration":
                    Thread t2 = new Thread(bruteForceExploration);
                    t2.start();
                    break;
                case "Reset":
                    sudokuGrid.resetGrid();
                default:
                    break;
            }
        }
    }
}
