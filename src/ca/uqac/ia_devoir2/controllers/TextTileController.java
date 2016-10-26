package ca.uqac.ia_devoir2.controllers;

import ca.uqac.ia_devoir2.model.Position;
import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.view.TextTile;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextTileController implements DocumentListener {

    private SudokuGrid sudokuGrid;

    public TextTileController(SudokuGrid sudokuGrid) {
        this.sudokuGrid = sudokuGrid;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {


    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (e.getDocument().getProperty("parent") instanceof TextTile) {
            TextTile textTile = (TextTile) e.getDocument().getProperty("parent");
            Position tilePosition = textTile.getPosition();
            try {
                sudokuGrid.getTile(tilePosition).setValue(Integer.parseInt(textTile.getText()));
            }
            catch (NumberFormatException ex){
                System.out.println(ex.getMessage());
            }

        }
    }
}
