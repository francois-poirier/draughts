package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Piece {

	private Color color;

	Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public Error isAdvanced(Coordinate origin, Coordinate target) {
		int difference = origin.getRow() - target.getRow();
		if (color == Color.WHITE){
			return difference>0 ? null : Error.NOT_ADVANCED;
		}
		return difference<0 ? null : Error.NOT_ADVANCED;
	}

	public Error isDiagonal(Coordinate origin , Coordinate target) {
        assert target != null && target.isValid();
        assert origin != null && origin.isValid();
        boolean isDiagonal = origin.getRow() + origin.getColumn() == target.getRow() + target.getColumn()
                || origin.getRow() - origin.getColumn() == target.getRow() - target.getColumn();
        return isDiagonal ? null : Error.NOT_DIAGONAL;
	}
	
	public Error diagonalDistance(Coordinate origin, Coordinate target) {
		assert target != null && target.isValid();
		assert origin.isValid() && origin.isDiagonal(target);
		return Math.abs(origin.getRow() - target.getRow()) >= 3 ? Error.BAD_DISTANCE :null;
	}

	    
}