package fiuba.modelo.efectos;

import fiuba.modelo.Jugador;

public class EfectoOllaDeLaCodicia implements EfectoMagica {

	public void activar(Jugador jugador1, Jugador jugador2) {
		int cantidadDeCartasATomar = 2;
		jugador1.tomarCartasDelMazo(cantidadDeCartasATomar);
	}

}
