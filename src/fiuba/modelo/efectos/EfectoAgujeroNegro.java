package fiuba.modelo.efectos;

import fiuba.modelo.Jugador;

public class EfectoAgujeroNegro implements EfectoMagica {

	public void activar(Jugador jugador1, Jugador jugador2) {
		jugador1.destruirMonstruos();
		jugador2.destruirMonstruos();
	}

}