package furniture.customer;

import java.io.IOException;

import furniture.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class CustomerController {
	 String euro = "\u20ac";
	 private Main main;


	@FXML
	private Text priceTag;

	@FXML
	private Text name;

	@FXML Text exText;

	@FXML
	private ImageView imgView;

	//Image img = new Image("media/stuhl_01.jpg");

	public Image img = new Image("file:media/stuhl_03.jpg");



	@FXML
	private void initialize(){
	priceTag.setText("19.99 " + euro);
	name.setText("Scruffel");
	exText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra erat eget condimentum varius. Ut sit amet facilisis ipsum, sit amet gravida elit. Phasellus quis orci nunc. Nunc et justo faucibus, hendrerit nulla ac, venenatis ipsum. Nunc posuere varius erat, non auctor diam vestibulum ac. ");
	imgView.setImage(img);
	}

	@FXML
	private void goAdmin() throws IOException{

		main.showLoginScene();

	}

}


