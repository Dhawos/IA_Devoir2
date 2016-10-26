package ca.uqac.ia_devoir2.explorations;

import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;

/**
 * Created by dhawo on 24/10/2016.
 */
public class DepthExploration implements Runnable {

    private SudokuGrid grid;

    public DepthExploration(SudokuGrid sudokuGrid) {
        this.grid = sudokuGrid;
    }

    public boolean exploration() {
        int i = 0;
        while (!grid.isComplete()) {
            Tile tileToFill = grid.smallestDomainTile();
            if (tileToFill == null) {
                return false;
            }

            grid.setTileValue(tileToFill.getDomain().get(i), tileToFill);
            while (exploration()) {
                return true;
            }
            i++;

        }
        // If we get here, it should mean that this is over, and we have successfully filled the grid
        return true;
    }

    @Override
    public void run() {
        System.out.println(exploration());
        System.out.println(grid);
    }
}
