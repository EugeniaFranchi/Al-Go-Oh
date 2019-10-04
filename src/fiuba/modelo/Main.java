package fiuba.modelo;

public class Main {

	public static void main(String[] args) {
		
		Jugador jugador = new Jugador("g");
		Mazo mazo = new Mazo(jugador);
	
		for ( int i = 0 ; i < 40 ; i++) {
			System.out.println(  mazo.tomarCarta().getNombre()  );
		}
		
			
		
	}

}
