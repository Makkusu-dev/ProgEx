package furniture.view;

import java.io.IOException;

import furniture.Main;
import javafx.fxml.FXML;



public class MainViewController {



	private Main main;

	@FXML
	private void goAdmin() throws IOException{
		main.showLoginScene();

	}
}

