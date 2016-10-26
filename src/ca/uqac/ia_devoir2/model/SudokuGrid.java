package ca.uqac.ia_devoir2.model;

import ca.uqac.ia_devoir2.model.exceptions.ValueNotInDomainException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Observable;

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
                this.grid.get(i).add(new Tile(new LinkedList<Integer>(Arrays.asList(Tile.POSSIBLE_VALUES)),i,j));
            }
        }
        for(ArrayList<Tile> row : this.grid){
            for(Tile tile : row){
                tile.setNeighbors(getNeighbors(tile));
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

    //We don't explicitly declare edges, however this function will return
    //every tile that should not have the same value as the one given as parameter.
    //We call those tiles, the neighbors of a given tile.
    //We use the HashSet class to avoid duplicates.
    public HashSet<Tile> getNeighbors(Tile tile){
        HashSet<Tile> set = new HashSet<>();
        int rowIndex = tile.getPosition().getX();
        int columnIndex = tile.getPosition().getY();
        //First we add the other tiles in the same column
        for(int i = 0; i < ARRAY_SIZE;i++){
            set.add(this.grid.get(i).get(columnIndex));
        }
        //Then we add the other tiles in the same row
        for(int i = 0; i < ARRAY_SIZE;i++){
            set.add(this.grid.get(rowIndex).get(i));
        }
        //We want to find the sub square containing tile
        int subSquareX = tile.getPosition().getX() / REGION_SIZE;
        int subSquareY = tile.getPosition().getY() / REGION_SIZE;
        for(int i = 0; i < REGION_SIZE; i++){
            for(int j = 0; j < REGION_SIZE;j++){
                set.add(this.grid.get(subSquareX*REGION_SIZE + i).get(subSquareY*REGION_SIZE + j));
            }
        }
        //We remove the tile itself from its the set for obvious reasons
        set.remove(tile);
        return set;
    }

    public void setTileValue(Integer value, Tile tile) throws  ValueNotInDomainException{
        tile.setValue(value); //Setting the value to the tile
        incrementNbValueSet();
    }

    public void setTileValue(Integer value, Position pos) throws  ValueNotInDomainException{
        setTileValue(value,grid.get(pos.getX()).get(pos.getY()));
    }

    public boolean isComplete(){
        return this.nbValueSet == ARRAY_SIZE * ARRAY_SIZE;
    }

    public Tile smallestDomainTile(){
        Tile smallestDomainTile = this.grid.get(0).get(0);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for(int j = 0; j < ARRAY_SIZE; j++){
                if (!smallestDomainTile.isEmpty() || (this.grid.get(i).get(j).isEmpty() && this.grid.get(i).get(j).getDomain().size() < smallestDomainTile.getDomain().size())){
                    smallestDomainTile = this.grid.get(i).get(j);
                }
            }
        }
        if (smallestDomainTile.getDomain().size() ==0){
            return null;
        }
        return smallestDomainTile;
    }

    public void resetGrid(){
        for(int i = 0; i < REGION_SIZE; i++){
            for(int j = 0; j < REGION_SIZE;j++){
                //setTileValue(null, new Position(i,j));
            }
        }
    }

    @Override
    public String toString() {
        String output = new String();
        for(ArrayList<Tile> row : this.grid){
            for(Tile tile : row){
                if(tile.getValue() == Tile.NOT_SET_VALUE){
                    output += "X";
                }else{
                    output += tile.getValue().toString();
                }
                output += " ";
            }
            output += "\n";
        }
        return output;
    }
}
