package fiuba.vista.eventos;

import fiuba.modelo.Jugador;
import fiuba.modelo.Turno;
import fiuba.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonSiguienteEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    TextField nombreJugador1,nombreJugador2;

    public BotonSiguienteEventHandler(Stage stage, TextField nombre1, TextField nombre2) {
        this.stage = stage;
        this.nombreJugador1 = nombre1;
        this.nombreJugador2 = nombre2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	Jugador jugador1 = new Jugador(nombreJugador1.getText());
    	jugador1.tomarCartasDelMazo(5);
    	Jugador jugador2 = new Jugador(nombreJugador2.getText());
    	jugador2.tomarCartasDelMazo(5);
    	Turno turno = new Turno(jugador1,jugador2);
    	
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,turno,jugador1,jugador2);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        stage.setScene(escenaJuego);
        stage.setFullScreen(true);
        
        stage.show();
    }
    
}