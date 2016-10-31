package ca.uqac.ia_devoir2.view;

import ca.uqac.ia_devoir2.explorations.BruteForceExploration;
import ca.uqac.ia_devoir2.explorations.DepthExploration;
import ca.uqac.ia_devoir2.model.Position;
import ca.uqac.ia_devoir2.model.SudokuGrid;
import ca.uqac.ia_devoir2.model.Tile;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TextTile extends JFormattedTextField implements Observer {

    private static Font DEFAULT_FONT = new Font("SansSerif", Font.BOLD, 20);

    private Position position;

    public TextTile(NumberFormatter formatter, Position position) {
        super(formatter);
        this.position = position;
        setFont(DEFAULT_FONT);
        setHorizontalAlignment(JTextField.CENTER);
        getDocument().putProperty("parent", this);

    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Tile){
            Tile tile = (Tile)o;
            if(tile.getValue() == Tile.NOT_SET_VALUE){
                setText("");
                setForeground(Color.black);
                setFocusable(true);
            }
            else if(!tile.getValue().toString().equals(this.getText().toString())){
                setText(tile.getValue().toString());
                setForeground(Color.RED);
                setFocusable(false);
            }
        } else if(o instanceof DepthExploration || o instanceof BruteForceExploration){
            if(arg instanceof SudokuGrid){
                Tile tile = ((SudokuGrid)arg).getTile(this.position);
                if(!tile.getValue().toString().equals(this.getText().toString())){
                    setText(tile.getValue().toString());
                    setForeground(Color.RED);

                }
                setFocusable(false);
            }
        }
    }

    public Position getPosition() {
        return position;
    }

}

