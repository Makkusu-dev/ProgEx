package employee.view;

import java.io.IOException;

import employee.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class MainItemsController {
	private Main main;
	
	@FXML
	private TextField loginField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label label;
	@FXML
	private Button loginButton;
	
	@FXML
	private void handleLoginButtonAction()throws IOException{
		label.setText("Wrong login details!");
		label.setTextFill(Color.RED);
	}
	
	
	
	
}
