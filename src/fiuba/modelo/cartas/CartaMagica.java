package fiuba.modelo.cartas;

import fiuba.modelo.Jugador;
import fiuba.modelo.efectos.*;
import fiuba.modelo.estrategiaPosicion.*;

public class CartaMagica implements Carta {

	private String nombre;
	private EstrategiaPosicion modo;
	private EfectoMagica efecto;
	private Jugador jugador;
	
	public CartaMagica(String nombre , EfectoMagica efecto, Jugador jugador) {
		this.nombre = nombre;
		this.efecto = efecto;
		this.jugador = jugador;
		this.modo = new BocaAbajo();
	}

	public String getNombre() {
		return nombre;
	}

	public void activarEfecto(Jugador oponente) {
		efecto.activar(jugador,oponente);
	}
	
}