package fiuba.vista.eventos;

import fiuba.modelo.Jugador;
import fiuba.modelo.Turno;
import fiuba.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonPasarFaseEventHandler implements EventHandler<ActionEvent> {
	Turno turno;
	ContenedorPrincipal contenedor;
	
	public BotonPasarFaseEventHandler(Turno turno, ContenedorPrincipal contenedor) {
		this.turno = turno;
		this.contenedor = contenedor;
	}
	 
	@Override
	public void handle(ActionEvent actionEvent) {
		turno.pasarFase();
		turno.activarVisualDeLaFase(contenedor);
	}

}