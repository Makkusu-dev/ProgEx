package employee.admin;


import javafx.fxml.FXML;
import java.io.IOException;
import employee.Main;

public class MainAdminController {
	private Main main;
	
	@FXML
	private void handleaddNewEmployeeButtonAction() throws IOException{								// cancel button ActionHandler
		main.showAddEmployeePage();
	
	}
}
