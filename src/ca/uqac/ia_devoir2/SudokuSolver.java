package ca.uqac.ia_devoir2;

import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;

/**
 * Created by dhawo on 24/10/2016.
 */
public class SudokuSolver {
    public static void main(String[] args) {
        SudokuGrid example = new SudokuGrid();
        //example.setTileValue();
        System.out.println(example);
    }

    public void exploration(SudokuGrid grid){
        while(!grid.isComplete()){
            Tile tileToFill = grid.smallestDomainTile();
            if (tileToFill != null){
                grid.setTileValue(tileToFill.getDomain().get(0), tileToFill);

            }else{
                // ERROR, we have to go back one iteration and change value
            }



        }
        // If we get here, it should mean that this is over, and we have successfully filled the grid
    }
}
