package ca.uqac.ia_devoir2;

import ca.uqac.ia_devoir2.model.SudokuGrid;

/**
 * Created by dhawo on 24/10/2016.
 */
public class SudokuSolver {
    public static void main(String[] args) {
        SudokuGrid example = new SudokuGrid();
        example.setTileValue();
        System.out.println(example);
    }
}
