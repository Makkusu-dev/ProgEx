package furniture.admin;

import java.io.IOException;

import furniture.Main;
import javafx.fxml.FXML;

public class AdminController {

	private Main main;

	@FXML
	private void logOut() throws IOException{

		main.showLoginScene();
	}




	@FXML
	private void goCustomer() throws IOException{
		main.showCustomerScene();

	}


}
