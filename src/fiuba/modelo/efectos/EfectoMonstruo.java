package fiuba.modelo.efectos;

import fiuba.modelo.Jugador;

public interface EfectoMonstruo extends Efecto{

	public void activar(Jugador unJugador);

	public boolean activarSiendoAtacado(Jugador jugador);
}
