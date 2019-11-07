package es.urjccode.mastercloudapps.adcs.draughts.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class PlayView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};
	private static String regex = "[1-8][1-8]";
	private static Pattern pattern = Pattern.compile(regex);

    public PlayView(){
        super();
    }

    public void interact(PlayController playController) {
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            String[] numbers = command.split("\\.|\\n");
			if (isValidCoordinate(numbers[0], numbers[1])) {
				error = playController.move(new Coordinate(numbers[0]),new Coordinate(numbers[1]));
				if (error != null) {
					error.writeln();
					gameView.write(playController);
				}
			}
			else {
				Error.OUT_COORDINATE.writeln();
				error = Error.OUT_COORDINATE;
			}
        } while (error != null); 
        if (playController.isBlocked()){
        	MessageView.MESSAGE.write();
        }
    }

	private boolean isValidCoordinate(String source, String target) {
		Matcher matcherSource = pattern.matcher(source);
		Matcher matcherTarget = pattern.matcher(target);
		return matcherSource.matches() && matcherTarget.matches();
	}
}