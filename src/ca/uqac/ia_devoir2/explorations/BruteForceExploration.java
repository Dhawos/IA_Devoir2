package ca.uqac.ia_devoir2.explorations;

import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;
import ca.uqac.ia_devoir2.model.exceptions.EmptyDomainException;

/**
 * Created by dhawo on 24/10/2016.
 */
public class BruteForceExploration implements Runnable {

    private SudokuGrid grid;

    public BruteForceExploration(SudokuGrid sudokuGrid) {
        this.grid = sudokuGrid;
    }

    public boolean startExploration(){
        return this.exploration(this.grid);
    }

    public boolean exploration(SudokuGrid grid) {
        int i = 0;
        while(!grid.isComplete()){
            Tile tileToFill = grid.nextEmptyTile();
            //We try the current value of i and see where it gets us
            for(Integer value : tileToFill.getDomain())
            {
                try{
                    SudokuGrid newGrid = new SudokuGrid(grid);
                    Tile tileToFillNewGrid = newGrid.getTile(tileToFill.getPosition());
                    newGrid.setTileValue(value,tileToFillNewGrid);
                    if(exploration(newGrid)){
                        return true;
                    }else{
                        return false;
                    }
                }catch(EmptyDomainException ex){
                    //In this exploration we don't use constraint propagation
                    //Therefore we ignore the exception
                }
            }
            return false;
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
