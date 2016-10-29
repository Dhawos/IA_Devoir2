package ca.uqac.ia_devoir2.view;

import ca.uqac.ia_devoir2.model.Position;
import ca.uqac.ia_devoir2.model.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TextTile extends JFormattedTextField implements Observer {

    private static Font DEFAULT_FONT = new Font("SansSerif", Font.BOLD, 20);

    private Position position;

    public TextTile(AbstractFormatter formatter, Position position) {
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
        }
    }

    public Position getPosition() {
        return position;
    }
}
