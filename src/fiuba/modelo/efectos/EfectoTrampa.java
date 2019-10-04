package fiuba.modelo.efectos;

import fiuba.modelo.Jugador;
import fiuba.modelo.cartas.CartaMonstruo;

public interface EfectoTrampa extends Efecto {

	public boolean activar(CartaMonstruo carta1, CartaMonstruo carta2, Jugador oponente);

}
