package ca.uqac.ia_devoir2.model;

import ca.uqac.ia_devoir2.model.exceptions.EmptyDomainException;
import ca.uqac.ia_devoir2.model.exceptions.ValueNotInDomainException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Observable;

/**
 * Created by dhawo on 24/10/2016.
 */
//Represents a tile in the Sudoku grid.
//The domain represents the list of integer that are still legal for this tile
//If the field value is set to -1, this means the tile has no value yet
//The tile is meant for a 3x3 grid
public class Tile extends Observable {
    private Integer value;
    private LinkedList<Integer> domain;
    private Position position;
    private HashSet<Tile> neighbors;

    private final static int MAXVALUE = 9;
    public final static int NOT_SET_VALUE = -1;
    public final static Integer[] POSSIBLE_VALUES = {1,2,3,4,5,6,7,8,9};

    public Tile(Position pos){
        this.value = NOT_SET_VALUE;
        this.domain = new LinkedList<Integer>(Arrays.asList(Tile.POSSIBLE_VALUES));
        this.position = pos;
    }

    public Tile(LinkedList<Integer> domain, Position position) {
        this.value = NOT_SET_VALUE;
        this.domain = domain;
        this.position = position;
    }

    public Tile(LinkedList<Integer> domain, int x, int y) {
        this.value = NOT_SET_VALUE;
        this.domain = domain;
        this.position = new Position(x,y);
    }

    public Tile(int value, Position position) {
        this.value = value;
        this.position = position;
        this.domain = null;
    }

    public Tile(int value, int x, int y) {
        this.value = value;
        this.position = new Position(x,y);
        this.domain = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        if(domain != null && this.domain.contains(value)){
            this.value = value;
            this.domain = null;
            //Removing this value from all neighbors domain
            for(Tile currentNeighbor : this.getNeighbors()){
                currentNeighbor.removeFromDomain(value);
            }
        }else if(value == Tile.NOT_SET_VALUE){
            this.value = value;
        }else{
            throw new ValueNotInDomainException(this,value);
        }
        setChanged();
        notifyObservers();
    }


    public LinkedList<Integer> getDomain() {
        return domain;
    }

    public Position getPosition() {
        return position;
    }

    public void removeFromDomain(Integer value) throws EmptyDomainException{
        if(this.domain != null){
            this.domain.remove(value);
        }
        if(this.domain != null && this.domain.size() == 0){
            throw new EmptyDomainException(this);
        }
    }

    public void addToNeighborsDomain(Integer value){
        for(Tile currentTile : this.neighbors){
            currentTile.domain.add(value);
        }
    }

    public boolean isEmpty(){
        return this.value == NOT_SET_VALUE;
    }

    public HashSet<Tile> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(HashSet<Tile> neighbors) {
        this.neighbors = neighbors;
    }

    public void setDomain(LinkedList<Integer> domain) {
        this.domain = domain;
    }
}
