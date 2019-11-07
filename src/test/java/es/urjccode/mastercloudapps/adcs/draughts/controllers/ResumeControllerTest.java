package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.StateValue;

public class ResumeControllerTest {
	
	private Game game;
	private State state;
	
	@Before
	public void setUp() {
		this.game = new Game();
		this.state = new State();
	}

    @Test
    public void givenResumeControllerWhenResumeGameMoveToInitialStateRequiereCorrectThenNotError() {
        ResumeController resumeController = new ResumeController(game, state);
        assertEquals(StateValue.INITIAL, resumeController.getValueState());
        resumeController.next();
        assertEquals(StateValue.IN_GAME, resumeController.getValueState());
        resumeController.next();
        assertEquals(StateValue.FINAL, resumeController.getValueState());
        resumeController.reset();
        assertEquals(StateValue.INITIAL, resumeController.getValueState());
    }

    @Test(expected = AssertionError.class)
    public void givenResumeControllerWhenResumeGameMoveOutThenError() {
        ResumeController resumeController = new ResumeController(game, state);
        assertEquals(StateValue.INITIAL, resumeController.getValueState());
        resumeController.next();
        assertEquals(StateValue.IN_GAME, resumeController.getValueState());
        resumeController.next();
        assertEquals(StateValue.FINAL, resumeController.getValueState());
        resumeController.next();
        assertEquals(StateValue.EXIT, resumeController.getValueState());
        resumeController.next();
    }
}