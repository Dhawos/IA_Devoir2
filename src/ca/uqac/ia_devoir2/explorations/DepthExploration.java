package ca.uqac.ia_devoir2.explorations;

import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;
import ca.uqac.ia_devoir2.model.exceptions.EmptyDomainException;

import java.util.Observable;


/**
 * Created by dhawo on 24/10/2016.
 */
public class DepthExploration extends Observable implements Runnable {

    private SudokuGrid grid;

    public DepthExploration(SudokuGrid sudokuGrid) {
        this.grid = sudokuGrid;
    }

    public SudokuGrid startExploration(){
        return this.exploration(this.grid);
    }

    public SudokuGrid exploration(SudokuGrid grid) {
        int i = 0;
        while(!grid.isComplete()){
            Tile tileToFill = grid.smallestDomainTile();
            SudokuGrid newGrid = new SudokuGrid(grid);
            try{
                //We try the current value of i and see where it gets us
                if(i < tileToFill.getDomain().size()){
                    //grid.setTileValue(tileToFill.getDomain().get(i), tileToFill);
                    Tile tileToFillNewGrid = newGrid.getTile(tileToFill.getPosition());
                    newGrid.setTileValue(tileToFillNewGrid.getDomain().get(i),tileToFillNewGrid);
                    notifyObservers(newGrid);
                    //System.out.println(grid);
                }else{
                    return null;
                }
            }catch(EmptyDomainException ex){ //If this exception is thrown, the considered solution isn't correct and we can stop the exploration there.
                System.out.println(ex.getMessage());
                return null;
            }
            SudokuGrid result = exploration(newGrid);
            if(result != null){
                return result;
            }
            //Checking next value
            i++;

        }
        // If we get here, it should mean that this is over, and we have successfully filled the grid
        return grid;
    }

    @Override
    public void run() {
        System.out.println(startExploration());
    }
}
