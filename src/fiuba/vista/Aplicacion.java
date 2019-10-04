package fiuba.vista;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Aplicacion extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
						
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Al-Go-Oh!");
		
        ContenedorIngresoJugadores contenedorJugadores = new ContenedorIngresoJugadores(stage);
        Scene escenaJugadores = new Scene(contenedorJugadores,661,372);
		
        ContenedorMenuInicial contenedorInicial = new ContenedorMenuInicial(stage,escenaJugadores);
        Scene escenaBienvenidos = new Scene(contenedorInicial,400,600);

		stage.setScene(escenaBienvenidos);
		
		stage.show();
	}
	
}