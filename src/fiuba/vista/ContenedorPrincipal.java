package fiuba.vista;

import fiuba.modelo.Jugador;
import fiuba.modelo.Turno;
import fiuba.vista.eventos.BotonPasarFaseEventHandler;
import fiuba.vista.eventos.BotonSacarCartaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
//    VistaTablero vistaTablero;
    Canvas canvasCentral;
    VBox contenedorVertical;
    Jugador jugador1, jugador2;
    Button pasarFase;
    Turno turno;

    public ContenedorPrincipal(Stage stage, Turno turno, Jugador jugador1, Jugador jugador2) {
    	this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turno = turno;
        this.pasarFase = new Button();
    	pasarFase.setText("Pasar de fase");
        this.setMenu(stage);
        this.setCentro();
        this.setConsola();
        this.iniciarJuego(stage, turno, jugador1, jugador2);;
    }
    
    public void iniciarJuego(Stage stage, Turno turno, Jugador jugador1, Jugador jugador2) {
    	this.contenedorVertical = new VBox();
    	contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        this.setBotonera();
        
        turno.activarVisualDeLaFase(this);
    }

    private void setBotonera() {
    	Jugador jugador = turno.getJugadorActual();
    	turno.activarVisualDeLaFase(this);
    	
        BotonPasarFaseEventHandler PasarFaseButtonHandler = new BotonPasarFaseEventHandler(turno, this);
        pasarFase.setOnAction(PasarFaseButtonHandler);
		pasarFase.setDisable(true);
		
        Label etiquetaTurno = new Label();
        etiquetaTurno.setText("Turno " + jugador.getNombre());
        etiquetaTurno.setFont(Font.font("System Bold", FontWeight.BOLD,20));
        etiquetaTurno.setTextFill(Color.BLACK);
        
        contenedorVertical.getChildren().add(etiquetaTurno);
        contenedorVertical.getChildren().add(this.pasarFase);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
//        canvasCentral = new Canvas(460, 220);
//        vistaRobot = new VistaRobot(robot, canvasCentral);
//        vistaRobot.dibujar();

        contenedorVertical = new VBox();
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setPadding(new Insets(25));
        Image tablero = new Image("file:src/fiuba/vista/img/tablero.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(tablero, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        
        contenedorVertical.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorVertical);
    }

    private void setConsola() {

        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

	public void agregarBoton(Label etiquetaFase) {
		this.contenedorVertical.getChildren().add(etiquetaFase);
		
	}

}