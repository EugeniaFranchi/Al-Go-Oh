package fiuba.modelo.fases;

import fiuba.modelo.Jugador;
import fiuba.modelo.Turno;

public class FasePreparacion extends Fase {

	public FasePreparacion(Jugador unJugador, Turno unTurno) {
		super(unJugador,unTurno);
		this.nombre = "Fase de Preparacion";
	}

	@Override
	public Fase pasarFase() {
		if (turno.getNumeroDeTurno() == 1) {
			return new FaseFinal(jugador,turno);
		}
		return new FaseAtaque(jugador,turno);
	}

}