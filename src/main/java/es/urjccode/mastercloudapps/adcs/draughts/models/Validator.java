package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.Optional;

@FunctionalInterface
public interface Validator {
	Optional<Error> validate (Coordinate origin, Coordinate target, Color color);
}
