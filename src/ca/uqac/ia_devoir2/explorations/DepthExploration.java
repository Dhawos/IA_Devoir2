package ca.uqac.ia_devoir2.explorations;

import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;
import ca.uqac.ia_devoir2.model.exceptions.EmptyDomainException;

/**
 * Created by dhawo on 24/10/2016.
 */
public class DepthExploration implements Runnable {

    private SudokuGrid grid;

    public DepthExploration(SudokuGrid sudokuGrid) {
        this.grid = sudokuGrid;
    }

    public boolean startExploration(){
        return this.exploration(this.grid);
    }

    public boolean exploration(SudokuGrid grid) {
        int i = 0;
        while(!grid.isComplete()){
            Tile tileToFill = grid.smallestDomainTile();
            /*
            if(tileToFill == null){
                return false;
            }
            */
            //SudokuGrid newGrid = new SudokuGrid(grid);
            try{
                //We try the current value of i and see where it gets us
                if(i < tileToFill.getDomain().size()){
                    grid.setTileValue(tileToFill.getDomain().get(i), tileToFill);
                    System.out.println(grid);
                }else{
                    return false;
                }
            }catch(EmptyDomainException ex){ //If this exception is thrown, the considered solution isn't correct and we can stop the exploration there.
                System.out.println(ex.getMessage());
                return false;
            }

            if(exploration(grid)){
                return true;
            }
            //Checking next value
            i++;

        }
        // If we get here, it should mean that this is over, and we have successfully filled the grid
        return true;
    }

    @Override
    public void run() {
        startExploration();
        System.out.println(grid);
    }
}
