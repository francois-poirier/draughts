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

	/*
	 * protected Error isAdvanced(Coordinate origin, Coordinate target) { int
	 * difference = origin.getRow() - target.getRow(); if (color == Color.WHITE){
	 * return difference>0 ? null : Error.NOT_ADVANCED; } return difference<0 ? null
	 * : Error.NOT_ADVANCED; }
	 * 
	 * protected Error isDiagonal(Coordinate origin , Coordinate target) { assert
	 * target != null && target.isValid(); assert origin != null &&
	 * origin.isValid(); boolean isDiagonal = origin.getRow() + origin.getColumn()
	 * == target.getRow() + target.getColumn() || origin.getRow() -
	 * origin.getColumn() == target.getRow() - target.getColumn(); return isDiagonal
	 * ? null : Error.NOT_DIAGONAL; }
	 * 
	 * protected Error diagonalDistance(Coordinate origin, Coordinate target) {
	 * assert target != null && target.isValid(); assert origin.isValid() &&
	 * origin.isDiagonal(target); return Math.abs(origin.getRow() - target.getRow())
	 * >= 3 ? Error.BAD_DISTANCE :null; }
	 */

	public Error isValidMovement(Coordinate origin, Coordinate target) {
		/*
		 * Error error = isDiagonal(origin, target); if (error != null) return error;
		 * error = isAdvanced(origin, target); if (error != null) return error; error =
		 * diagonalDistance(origin, target); if (error != null) return error;
		 */
		
		Optional<Error> validate = new ChainedValidator().validate(origin, target, color);
		if (validate.isPresent()) {
			return validate.get();
		}
		
		return null;
	}
	    
}