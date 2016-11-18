package employee.view;

import java.io.IOException;
import employee.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainViewController {
	private Main main;
	
	@FXML
	private void goToAbout() throws IOException{			// About button from file menu
		main.showAbout();
	}
	
	
	@FXML
	private void adminLogin() throws IOException{
		main.showAdminLogin();
	}
	@FXML
	private void logOut() throws IOException{								// logOut item in menu bar
		main.showMainItems();
	}
	
	
}
