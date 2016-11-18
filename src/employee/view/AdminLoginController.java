package employee.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import employee.Admin;
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
	private Label labelField;
	
	
	@FXML
	private void handleLoginButtonAction(ActionEvent event) throws IOException{				// login button ActionHandler
			Admin newAdmin = new Admin();													// creates new admin with default attributes
			if (loginField.getText().equals(newAdmin.getName()) && passwordField.getText().equals(newAdmin.getPassword())){										// password check to implement
			Stage stage = (Stage) loginButton.getScene().getWindow();
			stage.close();
			main.launchMainAdmin();						
			}
			
			else {
				labelField.setText("Wrong login details!");
				labelField.setTextFill(Color.RED);
			}
					
			
	}
	
	@FXML
	private void handleCancelButtonAction(ActionEvent event){								// cancel button ActionHandler
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
	
}
