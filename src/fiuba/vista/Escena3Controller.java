package fiuba.vista;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Escena3Controller implements Initializable {

	private String nombre1 ,nombre2;
	@FXML  private Label l1,l2;
	
	private ImageView CartaMano;
	
	public void intiDatee(String n ,String nn) {
		 
		this.l1.setText(n);
	//  this. l2.setText(nn);
		
	 }
	 public void invocarCarta() throws IOException {
		 Stage nuevoStage = new Stage();
		 
		 FXMLLoader load = new FXMLLoader();
		 load.setLocation(getClass().getResource("Escena4.fxml"));
		 Parent root = load.load();
		 
		 Scene escena = new Scene(root,183,164);
		 nuevoStage.setScene(escena);
		 
		 nuevoStage.show();
	 }

	 public void jugadorInvocarCarta() {
		 
	 }
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//	CartaMano = new ImageView(new Image("file:fiuba.vista.img/cartaPrueba.jpg"));
//		InputStream inStream = getClass().getResourceAsStream("fiuba.vista.img/cartaPrueba.jpg");
//		Image imageObject = new Image(inStream);
//		 CartaMano = new ImageView(imageObject);  
	}
}
