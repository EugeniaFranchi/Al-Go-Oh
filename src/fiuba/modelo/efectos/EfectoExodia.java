package fiuba.modelo.efectos;

import fiuba.modelo.Jugador;
import fiuba.modelo.cartas.Carta;

public class EfectoExodia implements EfectoMonstruo {
	
	@Override
	public void activar(Jugador jugador) {
		jugador.ganarDuelo();
	}

	@Override
	public boolean activarSiendoAtacado(Jugador jugador) {
		/*No hace nada al ser atacado*/
		return false;
	}

}