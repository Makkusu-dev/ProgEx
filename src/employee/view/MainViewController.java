package employee.view;

import java.io.IOException;
import employee.Main;
import javafx.fxml.FXML;

public class MainViewController {
	private Main main;
	
	@FXML
	private void goToAbout() throws IOException{			// About button from file menu
		main.showAbout();
	}
	
	@FXML
	private void AddEmployee() throws IOException{		// to implement in Admin Controller
		main.showAddEmployeePage();	
	}
	
	@FXML
	private void adminLogin() throws IOException{
		main.showAdminLogin();
	}
	
	
}
