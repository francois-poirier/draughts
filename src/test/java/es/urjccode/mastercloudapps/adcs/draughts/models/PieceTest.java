package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PieceTest {

    @Test
    public void testGivenPieceWhenIsAdvancedThenTrue(){
        assertEquals(null,new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(4,1)));
        assertEquals(null,new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(3,2)));
    }

    @Test
    public void testGivenPieceWhenNotIsAdvancedThenFalse(){
    	assertEquals(Error.NOT_ADVANCED,new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(6,1)));
    	assertEquals(Error.NOT_ADVANCED,new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(5,2)));
    	assertEquals(Error.NOT_ADVANCED,new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(2,3)));
    	assertEquals(Error.NOT_ADVANCED,new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(1,2)));
    }
    
    @Test
    public void testGivenPieceNotDiagonalMovementThenError() {
    	assertEquals(Error.NOT_DIAGONAL, new Piece(Color.WHITE).isDiagonal(new Coordinate(5, 2), new Coordinate(4, 2)));
    }
    
    @Test
    public void testGivenPieceWhenMoveBadDistanceThenError() {
        assertEquals(Error.BAD_DISTANCE, new Piece(Color.WHITE).diagonalDistance(new Coordinate(5, 0), new Coordinate(2, 3))); 
    }
}