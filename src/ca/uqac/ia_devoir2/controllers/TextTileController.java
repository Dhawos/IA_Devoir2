package ca.uqac.ia_devoir2.controllers;

import ca.uqac.ia_devoir2.model.Position;
import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;
import ca.uqac.ia_devoir2.model.exceptions.ValueNotInDomainException;
import ca.uqac.ia_devoir2.view.TextTile;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextTileController implements FocusListener {

    private SudokuGrid sudokuGrid;

    public TextTileController(SudokuGrid sudokuGrid) {
        this.sudokuGrid = sudokuGrid;
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof TextTile) {
            TextTile textTile = (TextTile) e.getSource();
            Position tilePosition = textTile.getPosition();
            try {
                if (!textTile.getText().toString().equals(sudokuGrid.getTile(tilePosition).getValue().toString()))
                    if (!textTile.getText().equals("")){
                        sudokuGrid.setTileValue(Integer.parseInt(textTile.getText()),sudokuGrid.getTile(tilePosition));
                    }
                    else{
                        sudokuGrid.setTileValue(Tile.NOT_SET_VALUE,sudokuGrid.getTile(tilePosition));
                    }
            } catch (ValueNotInDomainException ex) {
                sudokuGrid.setTileValue(Tile.NOT_SET_VALUE,sudokuGrid.getTile(tilePosition));
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println(textTile.getText() + " is not a correct number!");
                sudokuGrid.setTileValue(Tile.NOT_SET_VALUE, sudokuGrid.getTile(tilePosition));
            }
        }
    }

}
