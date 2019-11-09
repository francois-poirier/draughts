package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class PlayView extends SubView {

    public PlayView(){
        super();
    }

    public void interact(PlayController playController) {
        Error error = null;
        GameView gameView = new GameView();
        CoordinateView coordinateView = new CoordinateView();
        do {
        	String[] numbers = coordinateView.read(playController);
			if (numbers!=null) {
				error = playController.move(new Coordinate(numbers[0]),new Coordinate(numbers[1]));
				if (error != null) {
					console.writeln("Error!!!" + error.name());
					gameView.write(playController);
				}
			}
        } while (error != null); 
        if (playController.isBlocked()){
        	MessageView.MESSAGE.write();
        }
    }
}