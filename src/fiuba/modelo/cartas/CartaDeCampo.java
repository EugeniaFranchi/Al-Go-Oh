package fiuba.modelo.cartas;

import fiuba.modelo.Jugador;
import fiuba.modelo.efectos.EfectoCampo;

public class CartaDeCampo implements Carta {

	private String nombre;
	private EfectoCampo efecto;
	private Jugador jugador;
	
	public CartaDeCampo(String nombre ,EfectoCampo efecto, Jugador jugador) {
		this.nombre= nombre;
		this.efecto = efecto;
		this.jugador = jugador;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void activarEfecto(Jugador oponente) {
		efecto.activar(jugador,oponente);
	}

}