package fiuba.modelo.fases;

import fiuba.modelo.Jugador;
import fiuba.modelo.Turno;
import fiuba.vista.ContenedorPrincipal;

public abstract class Fase {
	
	protected Jugador jugador;
	protected Turno turno;
	protected String nombre;
	
	public Fase(Jugador unJugador, Turno unTurno){
		jugador = unJugador;
		turno = unTurno;
	}
	
	public String getNombe() {
		return nombre;
	}
	
	public abstract Fase pasarFase();
	
	public abstract void activarVisual(ContenedorPrincipal contenedor);
	
}