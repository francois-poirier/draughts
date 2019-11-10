package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.Optional;

public class Piece {

	private Color color;

	Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public Error isValidMovement(Coordinate origin, Coordinate target) {
		Optional<Error> validate = new ChainedValidator().validate(origin, target, color);
		if (validate.isPresent()) {
			return validate.get();
		}	
		return null;
	}
	    
}