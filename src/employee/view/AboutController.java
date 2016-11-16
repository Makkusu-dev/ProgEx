package employee.view;

import java.io.IOException;

import employee.Main;
import javafx.fxml.FXML;

public class AboutController {
	
	private Main main;
	
	@FXML
	
	private void goToHome() throws IOException{
		main.showMainItems();
	}
	
	

}
