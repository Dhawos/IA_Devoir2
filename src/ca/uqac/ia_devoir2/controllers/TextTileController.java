package ca.uqac.ia_devoir2.controllers;

import ca.uqac.ia_devoir2.model.Position;
import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;
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
        updateValue(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateValue(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    private void updateValue(DocumentEvent e) {
        if (e.getDocument().getProperty("parent") instanceof TextTile) {
            TextTile textTile = (TextTile) e.getDocument().getProperty("parent");
            Position tilePosition = textTile.getPosition();
            try {
                if (!textTile.getText().toString().equals(sudokuGrid.getTile(tilePosition).getValue().toString()))
                    if (!textTile.getText().equals(""))
                        sudokuGrid.getTile(tilePosition).setValue(Integer.parseInt(textTile.getText()));
                    else
                        sudokuGrid.getTile(tilePosition).setValue(Tile.NOT_SET_VALUE);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
