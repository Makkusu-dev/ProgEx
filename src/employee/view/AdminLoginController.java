package employee.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import employee.Main;

public class AdminLoginController {
	private Main main;
	@FXML 
	private TextField loginField;
	
	@FXML 
	private PasswordField passwordField;
	
	@FXML
	private Button loginButton;
	
	@FXML
	private Button cancelButton;
	
	
	@FXML
	private void handleLoginButtonAction(ActionEvent event) throws IOException{				// login button ActionHandler
			String pass = passwordField.getText();
			if (loginField.getText().equals("admin")){										// password check to implement
			Stage stage = (Stage) loginButton.getScene().getWindow();
			stage.close();
			main.launchMainAdmin();		// fix admin main page				
			
			}
					//error message
			
	}
	
	@FXML
	private void handleCancelButtonAction(ActionEvent event){								// cancel button ActionHandler
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
	
}
