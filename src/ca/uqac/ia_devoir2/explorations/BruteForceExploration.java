package ca.uqac.ia_devoir2.explorations;

import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;
import ca.uqac.ia_devoir2.model.exceptions.EmptyDomainException;

import java.util.Observable;


/**
 * Created by dhawo on 24/10/2016.
 */
public class BruteForceExploration extends Observable implements Runnable {

    private SudokuGrid grid;
    private boolean finished = false;

    public BruteForceExploration(SudokuGrid sudokuGrid) {
        this.grid = sudokuGrid;
    }

    public SudokuGrid startExploration(){
        return this.exploration(this.grid);
    }

    public SudokuGrid exploration(SudokuGrid grid) {
        while(!grid.isComplete()){
            Tile tileToFill = grid.nextEmptyTile();
            //We try the current value of i and see where it gets us
            for(Integer value : tileToFill.getDomain())
            {
                try{
                    SudokuGrid newGrid = new SudokuGrid(grid);
                    Tile tileToFillNewGrid = newGrid.getTile(tileToFill.getPosition());
                    newGrid.setTileValue(value,tileToFillNewGrid);
                    notifyObservers(newGrid);
                    SudokuGrid result = exploration(newGrid);
                    if(result != null){
                        return result;
                    }
                }catch(EmptyDomainException ex){
                    //In this exploration we don't use constraint propagation
                    //Therefore we ignore the exception
                }
            }
            return null;
        }
        // If we get here, it should mean that this is over, and we have successfully filled the grid
        return grid;
    }

    @Override
    public void run() {
        SudokuGrid result = startExploration();
        System.out.println(result);
    }


}
