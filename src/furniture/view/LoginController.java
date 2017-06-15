package furniture.view;


import java.io.IOException;

import furniture.Main;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	private Main main;

	@FXML
	private TextField loginField;
	@FXML
	private PasswordField pwdField;


	@FXML
	private void goAdmin() throws IOException{
		if((loginField.getText().equals("admin"))&&(pwdField.getText().equals("admin"))){
		main.showAdminScene();
		}
	}

	



}
