package ca.uqac.ia_devoir2.model.exceptions;

import ca.uqac.ia_devoir2.model.Tile;

/**
 * Created by dhawo on 24/10/2016.
 */
public class ValueNotInDomainException extends RuntimeException {
    public ValueNotInDomainException(Tile tile, Integer value) {
        super("Attempting to affect a value that was not part of domain. Value : " + tile.getValue() + " Tile at : (" + tile.getPosition().getX() + "," + tile.getPosition().getY() + ")" );
    }
}
