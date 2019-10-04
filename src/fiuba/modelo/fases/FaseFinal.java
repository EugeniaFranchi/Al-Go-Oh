package fiuba.modelo.fases;

import fiuba.modelo.Jugador;
import fiuba.modelo.Turno;

public class FaseFinal extends Fase {

	public FaseFinal(Jugador unJugador, Turno unTurno) {
		super(unJugador, unTurno);
		this.nombre = "Fase Final";
	}

	@Override
	public Fase pasarFase() {
		turno.terminarTurno();
		return new FaseInicial(jugador.getOponente(),turno);
	}

}