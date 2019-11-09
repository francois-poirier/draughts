package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class CoordinateViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @InjectMocks
    CoordinateView coordinateView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testInteract(){
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("32.41\n");
        String[] numbers = coordinateView.read(playController);
        assertEquals("32", numbers[0]);
        assertEquals("41", numbers[1]);
    }
    
    @Test
    public void testInteractOuterCoordinate(){
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("08.08\n").thenReturn("32.41\n");
        String[] numbers = coordinateView.read(playController);
        assertEquals("32", numbers[0]);
        assertEquals("41", numbers[1]);
    }
}
