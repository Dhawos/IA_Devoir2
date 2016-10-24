package ca.uqac.ia_devoir2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by dhawo on 24/10/2016.
 */
//Represents a 9x9 sudoku grid
public class SudokuGrid {
    private ArrayList<ArrayList<Tile>> grid;
    private int nbValueSet;
    private static final int NB_REGIONS = 3; //The size of the grid in terms of regions
    private static final int REGION_SIZE = 3; //The size of one region
    private static final int ARRAY_SIZE = NB_REGIONS * REGION_SIZE; //The total size of the grid in terms of tile

    public SudokuGrid() {
        this.nbValueSet = 0;
        this.grid = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            this.grid.add(i,new ArrayList<Tile>(ARRAY_SIZE));
            for(int j = 0; j < ARRAY_SIZE; j++){
                this.grid.get(j).add(new Tile(new LinkedList<Integer>(Arrays.asList(Tile.POSSIBLE_VALUES)),i,j));
            }
        }
    }

    public int getNbValueSet() {
        return nbValueSet;
    }

    public void incrementNbValueSet(){
        this.nbValueSet = this.nbValueSet+1;
    }

    public Tile getTile(Position pos){
        return this.grid.get(pos.x).get(pos.y);
    }

    public Tile getTile(int x, int y){
        return this.grid.get(x).get(y);
    }
}
