package fiuba.modelo.efectos;

import fiuba.modelo.Jugador;
import fiuba.modelo.cartas.CartaMonstruo;

public class EfectoCilindroMagico implements EfectoTrampa {

	@Override
	public boolean activar(CartaMonstruo miMonstruo, CartaMonstruo monstruoEnemigo, Jugador oponente) {
		int danio = monstruoEnemigo.getPuntosDeBatalla();
		oponente.recibirDanio(danio);
		return false;
	}
}