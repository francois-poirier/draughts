package es.urjccode.mastercloudapps.adcs.draughts.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class CoordinateView extends SubView {

	private static final String[] COLORS = {"blancas", "negras"};
	private static String regex = "[1-8][1-8]";
	private static Pattern pattern = Pattern.compile(regex);
	
	public String[] read(PlayController playController) {
		String color = CoordinateView.COLORS[playController.getColor().ordinal()];
		String[] numbers = null;
		boolean isValid = false;
		while (!isValid) {
			String command = this.console.readString("Mueven las " + color + ": ");
	        numbers = command.split("\\.|\\n");
	        isValid = isValidCoordinate(numbers[0], numbers[1]);
	        if (!isValid) {
	        	console.writeln("Error!!!" + Error.OUT_COORDINATE.getError());
	        }
		}
		return numbers;
	}
	
	private boolean isValidCoordinate(String source, String target) {
		Matcher matcherSource = pattern.matcher(source);
		Matcher matcherTarget = pattern.matcher(target);
		return matcherSource.matches() && matcherTarget.matches();
	}
}
