package es.urjccode.mastercloudapps.adcs.draughts.models;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public enum Error {
	
    OUT_COORDINATE("No es una coordenada del tablero"), 
    EMPTY_ORIGIN("No hay ficha que mover"), 
    OPPOSITE_PIECE("No es una de tus fichas"),
    NOT_DIAGONAL("No vas en diagonal"),
    BAD_DISTANCE("No respetas la distancia"),
    NOT_EMPTY_TARGET("No está vacío el destino"),
    NOT_ADVANCED("No avanzas"),
    EATING_EMPTY("No comes contrarias"),
    WRONG_OPTION("Opción incorrecta"),
	WRONG_FORMAT("No te entiendo: <d><d>{,<d><d>}[0-2]"),
	NOT_EAT("No se puede comer tantas en un movimiento"),
	NOT_EAT_JUMP("No se puede comer tantas en un salto");
	
    private String error;
    
	private static Console console = new Console();
	
    Error(String error) {
        this.error = error;
    }
 
    public String getError() {
        return error;
    }
    
	public void write() {
		Error.console.write("Error!!! " + this.error);
	}
	
	public void writeln() {
		Error.console.writeln("Error!!! " + this.error);
	}
}