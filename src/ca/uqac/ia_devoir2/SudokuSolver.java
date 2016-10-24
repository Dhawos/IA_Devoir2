package ca.uqac.ia_devoir2;

import ca.uqac.ia_devoir2.model.Position;
import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;

/**
 * Created by dhawo on 24/10/2016.
 */
public class SudokuSolver {
    public static void main(String[] args) {
        /*Example Grid*/
        SudokuGrid example = new SudokuGrid();
        example.setTileValue(2,new Position(0,0));
        example.setTileValue(3,new Position(1,0));
        example.setTileValue(8,new Position(2,0));
        example.setTileValue(6,new Position(4,0));
        example.setTileValue(4,new Position(5,0));
        example.setTileValue(1,new Position(8,0));
        example.setTileValue(9,new Position(5,1));
        example.setTileValue(5,new Position(7,1));
        example.setTileValue(8,new Position(8,1));
        example.setTileValue(5,new Position(0,2));
        example.setTileValue(7,new Position(1,2));
        example.setTileValue(3,new Position(7,2));
        example.setTileValue(2,new Position(4,3));
        example.setTileValue(7,new Position(5,3));
        example.setTileValue(1,new Position(6,3));
        example.setTileValue(6,new Position(7,3));
        example.setTileValue(7,new Position(0,4));
        example.setTileValue(6,new Position(3,4));
        example.setTileValue(8,new Position(5,4));
        example.setTileValue(5,new Position(8,4));
        example.setTileValue(2,new Position(1,5));
        example.setTileValue(6,new Position(2,5));
        example.setTileValue(1,new Position(3,5));
        example.setTileValue(5,new Position(4,5));
        example.setTileValue(1,new Position(1,6));
        example.setTileValue(7,new Position(7,6));
        example.setTileValue(3,new Position(8,6));
        example.setTileValue(9,new Position(0,7));
        example.setTileValue(4,new Position(1,7));
        example.setTileValue(8,new Position(3,7));
        example.setTileValue(8,new Position(0,8));
        example.setTileValue(3,new Position(3,8));
        example.setTileValue(1,new Position(4,8));
        example.setTileValue(6,new Position(6,8));
        example.setTileValue(4,new Position(7,8));
        example.setTileValue(9,new Position(8,8));
        /****************************************/
        //example.setTileValue();
        System.out.println(example);
    }


}
