package fiuba.vista.eventos;

import fiuba.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonSacarCartaEventHandler implements EventHandler<ActionEvent> {

	private Jugador jugador;
	private Button botonSacarCarta;
	private Button botonPasarFase;
	
	public BotonSacarCartaEventHandler(Jugador unJugador,Button esteBoton, Button otroBoton) {
		jugador = unJugador;
		botonSacarCarta = esteBoton;
		botonPasarFase = otroBoton;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
		jugador.tomarCartasDelMazo(1);
		botonSacarCarta.setDisable(true);
		botonPasarFase.setDisable(false);
    }
    
}