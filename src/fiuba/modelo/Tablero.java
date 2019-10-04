package fiuba.modelo;

import java.util.ArrayList;

import fiuba.modelo.excepciones.ZonaLlenaError;
import fiuba.modelo.cartas.*;

public class Tablero {
	
	private ArrayList<CartaMonstruo> zonaDeMonstruos;
	private ArrayList<Carta> zonaDeCartasMagicasOTrampa;
	private CartaDeCampo zonaDeCampo;
	private ArrayList<Carta> cementerio;
	private Mazo mazo;
	
	public Tablero(Jugador jugador) {
		this.zonaDeMonstruos = new ArrayList<CartaMonstruo>();
		this.zonaDeCartasMagicasOTrampa = new ArrayList<Carta>();
		this.cementerio = new ArrayList<Carta>();
		this.mazo = new Mazo(jugador);
	}
	
	public void verZonaDeMonstruos() {
		for(CartaMonstruo monstruo: zonaDeMonstruos) {
			  System.out.println(monstruo.getNombre());
		}
	}

	public void verCementerio() {
		for(Carta carta: cementerio) {
			  System.out.println(carta.getNombre());
		}
	}
	
	public Carta sacarUnaCartaDelMazo() {
		return mazo.tomarCarta();
	}
	
	public void invocar(CartaMonstruo cartaMonstruo) {
		int cantidadSacrificios = cartaMonstruo.sacrificiosNecesarios();
		if (zonaDeMonstruos.size() - cantidadSacrificios == 5) throw new ZonaLlenaError();
		cartaMonstruo.sacrificarNecesarios();
		zonaDeMonstruos.add(cartaMonstruo);
	}

	public void invocar(CartaMagica cartaMagica) {
		if (zonaDeCartasMagicasOTrampa.size() == 5) throw new ZonaLlenaError();
		zonaDeCartasMagicasOTrampa.add(cartaMagica);
	}

	public void invocar(CartaTrampa cartaTrampa) {
		if (zonaDeCartasMagicasOTrampa.size() == 5) throw new ZonaLlenaError();
		zonaDeCartasMagicasOTrampa.add(cartaTrampa);
	}
	
	public void invocar(CartaDeCampo cartaCampo) {
		if (zonaDeCampo != null) throw new ZonaLlenaError();
		zonaDeCampo = cartaCampo;
	}

	public void mandarAlCementerio(CartaMonstruo carta) {
		zonaDeMonstruos.remove(carta);
		cementerio.add(carta);
	}
	
	public void mandarAlCementerio(CartaMagica carta) {
		zonaDeCartasMagicasOTrampa.remove(carta);
		cementerio.add(carta);
	}
	
	public void mandarAlCementerio(CartaTrampa carta) {
		zonaDeCartasMagicasOTrampa.remove(carta);
		cementerio.add(carta);
	}
	
	public boolean estaEnLaZonaDeMonstruos(CartaMonstruo carta) {
		return zonaDeMonstruos.contains(carta);
	}
	
	public boolean estaEnLaZonaDeMagiasYTrampas(Carta carta) {
		return zonaDeCartasMagicasOTrampa.contains(carta);
	}
	
	public boolean estaEnElCementerio(Carta carta) {
		return cementerio.contains(carta);
	}

	public void sacrificarMonstruo() {
		CartaMonstruo monstruoASacrificar = this.getMonstruoConMenorNivel();
		mandarAlCementerio(monstruoASacrificar);
	}
	
	public boolean verificarTrampas(CartaMonstruo miMonstruo, CartaMonstruo monstruoEnemigo, Jugador oponente) {
		for(Carta carta : zonaDeCartasMagicasOTrampa) {
			if(carta.getClass()== CartaTrampa.class) {
				CartaTrampa cartaTrampa = (CartaTrampa) carta;
				mandarAlCementerio((CartaTrampa) carta);
				return (cartaTrampa.activarEfecto(miMonstruo,monstruoEnemigo,oponente)) ;
			}		
		}
		return true;
	}
	
	public void vaciarZonaDeMonstruos() {
		int i = 0;
		while (i < zonaDeMonstruos.size()) {
			mandarAlCementerio(zonaDeMonstruos.get(i));
		}
	}

	public void aumentarAtaqueMonstruos(int aumento) {
		for(CartaMonstruo monstruo: zonaDeMonstruos) {
			monstruo.aumentarPuntosDeAtaque(aumento);
		}
	}

	public void aumentarDefensaMonstruos(int aumento) {
		for(CartaMonstruo monstruo: zonaDeMonstruos) {
			monstruo.aumentarPuntosDeDefensa(aumento);
		}
	}

	public CartaMonstruo getMonstruoConMenorAtaque() {
		CartaMonstruo monstruoConMenorAtaque = null;
		for(CartaMonstruo monstruo: zonaDeMonstruos) {
			if (monstruoConMenorAtaque == null || monstruo.tieneMenosPuntosDeAtaqueQue(monstruoConMenorAtaque)) {
				monstruoConMenorAtaque = monstruo;
			}
		}
		return monstruoConMenorAtaque;
	}
	
	public CartaMonstruo getMonstruoConMenorNivel() {
		CartaMonstruo monstruoConMenorNivel = null;
		for(CartaMonstruo monstruo: zonaDeMonstruos) {
			if (monstruoConMenorNivel == null || monstruo.tieneMenosNivelQue(monstruoConMenorNivel)) {
				monstruoConMenorNivel = monstruo;
			}
		}
		return monstruoConMenorNivel;
	}
	
	public CartaMonstruo getMonstruoConMayorNivel() {
		CartaMonstruo monstruoConMayorNivel = null;
		for(CartaMonstruo monstruo: zonaDeMonstruos) {
			if (monstruoConMayorNivel == null || monstruo.tieneMasNivelQue(monstruoConMayorNivel)) {
				monstruoConMayorNivel = monstruo;
			}
		}
		return monstruoConMayorNivel;
	}

	public int getCantidadDeMonstruos() {
		return zonaDeMonstruos.size();
	}

	public int cantidadDeMonstruosEnCampo(String nombre) {
		int cantidadMonstruos = 0;
		for(CartaMonstruo monstruo : zonaDeMonstruos) {
			if(monstruo.getNombre() == nombre) cantidadMonstruos++;
		}
		return cantidadMonstruos;
	}

	public CartaMonstruo obtenerMonstruoEnCampo(String nombre) {
		for(CartaMonstruo monstruo : zonaDeMonstruos) {
			if(monstruo.getNombre() == nombre) return monstruo;
		}
		return null;
	}

}