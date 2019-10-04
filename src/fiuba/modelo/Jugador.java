package fiuba.modelo;

import java.util.ArrayList;

import fiuba.modelo.excepciones.*;
import fiuba.modelo.cartas.*;

public class Jugador {
	
	private String nombre;
	private int vida;
	private Tablero tablero;
	private ArrayList<Carta> cartasEnMano;
	private ArrayList<CartaExodia> coleccionExodia;
	private Jugador oponente;
	
	public static final int VIDA = 8000 ;
		
	public Jugador( String nombre) {
		this.nombre = nombre;
		this.vida = VIDA;
		this.tablero = new Tablero(this);
		this.cartasEnMano = new ArrayList<Carta>();
		this.coleccionExodia = new ArrayList<CartaExodia>();
		this.oponente = null;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setOponente(Jugador unJugador) {
		oponente = unJugador;
	}
	
	public Jugador getOponente() {
		return oponente;
	}
	
	public ArrayList<Carta> getCartasEnMano() {
		return cartasEnMano;
	}
	
	public void verZonaDeMonstruos() {
		tablero.verZonaDeMonstruos();		
	}
	
	public void verCementerio() {
		tablero.verCementerio();		
	}
	
	public void tomarCartasDelMazo(int cantidadDeCartasATomar) {
		for (int i = 0; i < cantidadDeCartasATomar; i++) {
			Carta cartaNueva = tablero.sacarUnaCartaDelMazo();
			this.agregarCartaALaMano(cartaNueva);
		}
	}
	
	public void agregarCartaALaMano(Carta cartaNueva) {
		cartasEnMano.add(cartaNueva);
		if (cartaNueva.getClass() == CartaExodia.class) {
			CartaExodia exodia = (CartaExodia) cartaNueva;
			coleccionExodia.add(exodia);
			if (coleccionExodia.size() == 5) {
				exodia.activarEfecto(this);
			}
		}
	}
	
	public void recibirDanio(int danio) {
		vida -= danio;
		if (vida <= 0) {
			this.perderDuelo();
		}
	}
	
	public void recibirAtaqueDirecto(CartaMonstruo monstruo) {
		if (this.cantidadDeMonstruos() > 0) throw new NoSePuedeAtacarDirectamenteError();
		monstruo.validarAtaque();
		if(this.verificarTrampas(null ,monstruo ,monstruo.getJugador())) {
			recibirDanio(monstruo.getPuntosDeBatalla());
		}
	}
	
	public void invocar(CartaMonstruo carta) {		
		tablero.invocar(carta);
	}
	
	public void invocar(CartaMagica carta) {		
		tablero.invocar(carta);
	}
	
	public void invocar(CartaTrampa carta) {		
		tablero.invocar(carta);
	}
	
	public void invocar(CartaDeCampo carta) {		
		tablero.invocar(carta);
	}
	
	public void invocar(CartaExodia carta) {
		this.coleccionExodia.remove(carta);
		tablero.invocar(carta);
	}
	
	public void activar(Carta carta, Jugador oponente) {
		carta.activarEfecto(oponente);
	}
	
	public void enviarAlCementerio(CartaMonstruo carta) {
		tablero.mandarAlCementerio(carta);
	}
	
	public boolean estaEnLaZonaDeMonstruos(CartaMonstruo carta) {
		return tablero.estaEnLaZonaDeMonstruos(carta);
	}

	public boolean estaEnElCementerio(Carta carta) {
		return tablero.estaEnElCementerio(carta);
	}

	public void destruirMonstruos() {
		tablero.vaciarZonaDeMonstruos();
	}
	
	public CartaMonstruo getMonstruoConMayorNivel() {
		return tablero.getMonstruoConMayorNivel();
	}

	public void aumentarAtaqueMonstruos(int aumento) {
		tablero.aumentarAtaqueMonstruos(aumento);
	}

	public void aumentarDefensaMonstruos(int aumento) {
		tablero.aumentarDefensaMonstruos(aumento);
	}

	public void destruirMonstruoConMenorAtaque() {
		CartaMonstruo monstruo = tablero.getMonstruoConMenorAtaque();
		enviarAlCementerio(monstruo);
	}

	public void sacrificarMonstruo() {
		tablero.sacrificarMonstruo();
	}
	
	public int cantidadDeMonstruos(){
		return tablero.getCantidadDeMonstruos();
	}

	public CartaMonstruo obtenerMonstruoEnCampo(String nombre) {
		return tablero.obtenerMonstruoEnCampo(nombre);
	}

	public int cantidadCartasMonstruoEnCampo(String nombre) {
		return tablero.cantidadDeMonstruosEnCampo(nombre);
	}
	
	public boolean verificarTrampas(CartaMonstruo miMonstruo,CartaMonstruo monstruoEnemigo ,Jugador oponente) {
		return tablero.verificarTrampas(miMonstruo,monstruoEnemigo,oponente);
	}
	
	public void perderDuelo() {
		//Implementar derrota del jugador, por ahora lo pongo como excepcion para los test
		System.out.println(nombre + " perdio el duelo");
		throw new JugadorPerdioElDueloError();
	}

	public void ganarDuelo() {
		//Implementar derrota del jugador, por ahora lo pongo como excepcion para los test
		System.out.println(nombre + " gano el duelo");
		throw new JugadorGanoElDueloError();
	}
	
}