package fiuba.modelo.fases;

import fiuba.modelo.Jugador;
import fiuba.modelo.Turno;
import fiuba.vista.eventos.BotonSacarCartaEventHandler;
import javafx.scene.control.Button;

public class FaseAtaque extends Fase {

	public FaseAtaque(Jugador unJugador, Turno unTurno) {
		super(unJugador, unTurno);
		this.nombre = "Fase de Ataque";
	}

	@Override
	public Fase pasarFase() {
		return new FaseFinal(jugador,turno);
	}

	@Override
	public void activarVisual() {
		
	}

}