package ca.uqac.ia_devoir2.model.exceptions;

import ca.uqac.ia_devoir2.model.Tile;

/**
 * Created by dhawo on 24/10/2016.
 */
public class EmptyDomainException extends RuntimeException {
    Tile tile;

    public EmptyDomainException(Tile tile) {
        super("Tile at : (" + tile.getPosition().getX() + "," + tile.getPosition().getY() + ") has now an empty domain");
        this.tile = tile;
    }

    public EmptyDomainException(String message, Tile tile) {
        super(message);
        this.tile = tile;
    }
}
