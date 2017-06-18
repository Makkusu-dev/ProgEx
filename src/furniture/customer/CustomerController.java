package furniture.customer;
import classes.*;
import core.Database;

import java.io.IOException;

import furniture.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class CustomerController {
	 String euro = "\u20ac";
	 private Main main;
	 private Furniture furniture;

	@FXML
	private Text priceTag;

	@FXML
	private Text name;

	@FXML Text exText;

	@FXML
	private ImageView imgView;

	@FXML
	private Text amount;


	@FXML
	private TableView<Furniture> furnitureTable;
	@FXML
	private TableColumn<Furniture, String> nameColumn;
	@FXML
	private TableColumn<Furniture, String> priceColumn;
	@FXML
	private TableColumn<Furniture, String> amountColumn;

	@FXML
	private TabPane tabPane;
	@FXML
	private Tab firstTab;

	@FXML
	private TextField filterField;



	private float pricetag;
	private String nameIn;
	private String exTextIn;
	private int currentId;



	private Image img;
	static ObservableList<Furniture> furnitureList = FXCollections.observableArrayList();
//	ObservableList<String> stringList;

	public void fillTable(){
	nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Furniture, String>, ObservableValue<String>>(){
	    @Override
	    public ObservableValue<String> call(TableColumn.CellDataFeatures<Furniture, String> p) {
	        return new SimpleStringProperty(p.getValue().getName());
	    }
	});

	priceColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Furniture, String>, ObservableValue<String>>(){
	    @Override
	    public ObservableValue<String> call(TableColumn.CellDataFeatures<Furniture, String> p) {
	        return new SimpleStringProperty(Float.toString(p.getValue().getPrice()));
	    }
	});

	amountColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Furniture, String>, ObservableValue<String>>(){
	    @Override
	    public ObservableValue<String> call(TableColumn.CellDataFeatures<Furniture, String> p) {
	        return new SimpleStringProperty(Integer.toString(p.getValue().getStock()));
	    }
	});

	furnitureTable.setItems(furnitureList);
	}

	private void filter(){
		// Wrap the ObservableList in a FilteredList (initially display all data).
				FilteredList<Furniture> filteredData = new FilteredList<>(furnitureList, p -> true);

				 //Set the filter Predicate whenever the filter changes.
				filterField.textProperty().addListener((observable, oldValue, newValue) -> {
		            filteredData.setPredicate(items -> {
		                //If filter text is empty, display all persons.
		                if (newValue == null || newValue.isEmpty()) {
		                    return true;
		                }

		                // Compare first name and last name of every person with filter text.
		                String lowerCaseFilter = newValue.toLowerCase();

		                if (items.getName().toLowerCase().contains(lowerCaseFilter)) {
		                    return true; // Filter matches name.
		                }
		                return false; // Does not match.
		            });
		        });

				  // Wrap the FilteredList in a SortedList.
		        SortedList<Furniture> sortedData = new SortedList<>(filteredData);

		     // Bind the SortedList comparator to the TableView comparator.
		        sortedData.comparatorProperty().bind(furnitureTable.comparatorProperty());

		     //  Add sorted (and filtered) data to the table.
		    	furnitureTable.setItems(filteredData);

			}

	@FXML
	private void initialize(){
	furnitureList = Database.loadFurniture();

	pricetag = furnitureList.get(0).getPrice();
	nameIn = furnitureList.get(0).getName();
	exTextIn = furnitureList.get(0).getDescription();
	img = new Image(furnitureList.get(0).getPictureFile());

	priceTag.setText(pricetag + euro);
	name.setText(nameIn);
	exText.setText(exTextIn);
	imgView.setImage(img);
	fillTable();
	filter();






/*	listView.setItems(value);
*/
	}
	@FXML
	private void select(){

		Furniture fury = furnitureTable.getSelectionModel().getSelectedItem();
		int currentId = fury.getId();
		pricetag = furnitureList.get(currentId).getPrice();
		nameIn = furnitureList.get(currentId).getName();
		exTextIn = furnitureList.get(currentId).getDescription();
		img = new Image(furnitureList.get(currentId).getPictureFile());

		priceTag.setText(pricetag + euro);
		name.setText(nameIn);
		exText.setText(exTextIn);
		imgView.setImage(img);
		tabPane.getSelectionModel().select(firstTab);
	}



	@FXML
	private void goZoom() throws IOException{
		main.showCustZomm();
	}
	int x=0;
	@FXML
	private void add() throws IOException{
		if(x<99){
		x++;
		String temp=Integer.toString(x);
		amount.setText(temp);
		}
	}


	@FXML
	private void sub() throws IOException{



		if(x>0){
			x--;
			String temp=Integer.toString(x);
			amount.setText(temp);
		}
	}

}


