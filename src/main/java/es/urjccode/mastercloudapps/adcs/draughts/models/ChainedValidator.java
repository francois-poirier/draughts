package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.Optional;

public class ChainedValidator implements Validator {

	@Override
	public Optional<Error> validate(Coordinate origin, Coordinate target, Color color) {
		return validateUsing(validateAdvanced(), origin, target, color).map(Optional::of)
				.orElseGet(() -> validateUsing(validateIsDiagonal(),
						origin, target, color)).map(Optional::of)
				.orElseGet(() -> validateUsing(validateDiagonalDistance(),
						origin, target, color));
	}

	
	private Optional<Error> validateUsing(Validator validator,
			Coordinate origin, Coordinate target, Color color) {
		return validator.validate(origin, target, color);
	}
	
	private Validator validateAdvanced() {
		
		return (origin, target,color) -> {
			int difference = origin.getRow() - target.getRow();
			if (color == Color.WHITE){
				return difference>0 ?  Optional.empty() : Optional.of(Error.NOT_ADVANCED);
			}		
			return difference<0 ?  Optional.empty() : Optional.of(Error.NOT_ADVANCED);
		};
	}
	
	private Validator validateIsDiagonal() {
		return (origin, target, color) -> {
			 assert target != null && target.isValid();
		     assert origin != null && origin.isValid();
		     boolean isDiagonal = origin.getRow() + origin.getColumn() == target.getRow() + target.getColumn()
		                || origin.getRow() - origin.getColumn() == target.getRow() - target.getColumn();
		     return isDiagonal ? Optional.empty()  : Optional.of(Error.NOT_DIAGONAL);
		};
	}
	
	private Validator validateDiagonalDistance() {
		return (origin, target, color) -> {
			assert target != null && target.isValid();
			assert origin.isValid() && origin.isDiagonal(target);
			return Math.abs(origin.getRow() - target.getRow()) >= 3 ? Optional.of(Error.BAD_DISTANCE) :Optional.empty();
		};
	}

}
