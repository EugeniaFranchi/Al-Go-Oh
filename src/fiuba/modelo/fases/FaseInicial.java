package fiuba.modelo.fases;

import fiuba.modelo.Jugador;
import fiuba.modelo.Turno;
import fiuba.vista.ContenedorPrincipal;
import fiuba.vista.eventos.BotonSacarCartaEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FaseInicial extends Fase {
	
	public FaseInicial(Jugador unJugador, Turno unTurno)	{
		super(unJugador,unTurno);
		this.nombre = "Fase Inicial";
	}
	
	@Override
	public Fase pasarFase() {
		return new FasePreparacion(jugador,turno);
	}

	@Override
	public void activarVisual(ContenedorPrincipal contenedor) {
		Label etiquetaFase = new Label();
        etiquetaFase.setText(nombre);
        etiquetaFase.setFont(Font.font("System Bold", FontWeight.BOLD,20));
        etiquetaFase.setTextFill(Color.BLACK);
        
        Button botonSacarCarta = new Button();
        botonSacarCarta.setText("Sacar carta");
        BotonSacarCartaEventHandler sacarCartaButtonHandler = new BotonSacarCartaEventHandler(jugador,botonSacarCarta);
        botonSacarCarta.setOnAction(sacarCartaButtonHandler);
        
        contenedor.agregarBoton(etiquetaFase);
        contenedor.agregarBoton(botonSacarCarta);
		
	}

}