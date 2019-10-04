package fiuba.vista;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Escena1Controller {
	
	public void apreto(ActionEvent event) throws IOException {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(getClass().getResource("Escena2.fxml"));
		Parent root = load.load();
		
		Scene escena = new Scene(root);
		Stage stage_2 = (Stage) ( (Node) event.getSource() ) .getScene().getWindow()  ;
		
		stage_2.setScene(escena);
		stage_2.show();
	}
	
	public void salir(ActionEvent event) throws IOException {
		System.exit(0);
	}
	
}