package employee.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployeePageController {
	
	// personal details
	@FXML
	ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");	//add values to the choice box
	@FXML
	private ChoiceBox gender;
	@FXML
	private void initialize(){
		gender.setItems(genderList);
		gender.setValue("choose");
	}
	@FXML
	private TextField dateOfBirth;
	@FXML
	private RadioButton nurse;
	@FXML
	private RadioButton doctor;
	@FXML
	private TextField employeeNumber;
	
	//
	// Contact details
	@FXML
	private TextField firstName;
	@FXML
	private TextField surName;
	@FXML
	private TextField street;
	@FXML
	private TextField houseNummer;
	@FXML
	private TextField zipCode;
	@FXML
	private TextField townCity;
	@FXML
	private TextField phoneNumber;
	@FXML
	private TextField email;
	@FXML
	private Button cancelButton;
	
	@FXML
	private void handleCancelButtonAction(ActionEvent event){								// cancel button ActionHandler
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
	
}



