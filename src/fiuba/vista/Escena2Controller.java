package fiuba.vista;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Escena2Controller {
	
	public TextField texto1,texto2;
	
	public void botonSiguiente(ActionEvent event) throws IOException {
			
		FXMLLoader load = new FXMLLoader ();
		load.setLocation( getClass().getResource("Escena3.fxml") );
		Parent root = load.load();
		
		Escena3Controller escena3 = load.getController();
		escena3.intiDatee( texto1.getText() ,texto2.getText()    );
		
		Scene escena = new Scene(root);
		Stage stage_2 = (Stage) ( (Node) event.getSource() ) .getScene().getWindow()  ;
		
		stage_2.setScene(escena);
		stage_2.show();
	}

}
