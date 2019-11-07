package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.StateValue;

public abstract class Controller {

    protected Game game;
    protected State state;
    
    protected Controller(Game game, State state) {
        this.game = new Game();
        this.state = new State();
    }

    public Color getColor(Coordinate coordinate) {
		return this.game.getColor(coordinate);
	}

	public int getDimension() {
		return this.game.getDimension();
	}

	public StateValue getValueState() {
		return this.state.getValueState();
	}
	
	abstract public void accept(ControllersVisitor controllersVisitor);
    
}
