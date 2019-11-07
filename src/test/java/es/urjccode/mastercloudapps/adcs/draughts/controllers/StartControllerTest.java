package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.StateValue;

public class StartControllerTest {
	
	private Game game;
	private State state;
	
	@Before
	public void setUp() {
		this.game = new Game();
		this.state = new State();
	}

     @Test
    public void givenStartControllerWhenStartGameThenChangeState() {
        StartController startController = new StartController(game, state);
        assertEquals(StateValue.INITIAL, startController.getValueState());
        startController.start();
        assertEquals(StateValue.IN_GAME, startController.getValueState());
    }

}