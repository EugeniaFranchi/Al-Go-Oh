package fiuba.modelo.efectos;

import fiuba.modelo.Jugador;

public interface EfectoCampo extends Efecto{

	public void activar(Jugador jugador1, Jugador jugador2);

}