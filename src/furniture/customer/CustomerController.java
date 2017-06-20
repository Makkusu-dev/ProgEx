package furniture.customer;

import classes.*;
import core.Database;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
	protected Furniture selectedItem;

	static ObservableList<Furniture> furnitureList = FXCollections.observableArrayList();

	@FXML
	private Text priceTag;

	@FXML
	private Text name;

	@FXML
	Text exText;

	@FXML
	private ImageView imgView;

	@FXML
	private Text amount;
	@FXML
	private Text priceFull;
	@FXML
	private Text respText;

	@FXML
	private Button goTo;
	@FXML
	private Button addTo;

	@FXML
	private TableView<Furniture> furnitureTable;
	@FXML
	private TableColumn<Furniture, String> nameColumn;
	@FXML
	private TableColumn<Furniture, String> priceColumn;
	@FXML
	private TableColumn<Furniture, String> amountColumn;

	@FXML
	private TableView<Furniture> cartTable;
	@FXML
	private TableColumn<Furniture, String> nameColumnCart;
	@FXML
	private TableColumn<Furniture, String> priceColumnCart;
	@FXML
	private TableColumn<Furniture, String> amountColumnCart;

	@FXML
	private TabPane tabPane;
	@FXML
	private Tab firstTab;
	@FXML
	private Tab secondTab;
	@FXML
	private Tab thirdTab;

	@FXML
	private TextField filterField;

	@FXML
	private ListView<Furniture> listView;

	ShoppingCart shoppingCart = new ShoppingCart();

	private float pricetag;
	private String nameIn;
	private String exTextIn;
	int currentId;

	private Image img;

	public void fillTable() {
		nameColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Furniture, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TableColumn.CellDataFeatures<Furniture, String> p) {
						return new SimpleStringProperty(p.getValue().getName());
					}
				});

		priceColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Furniture, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TableColumn.CellDataFeatures<Furniture, String> p) {
						return new SimpleStringProperty(Float.toString(p.getValue().getPrice()));
					}
				});

		amountColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Furniture, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TableColumn.CellDataFeatures<Furniture, String> p) {
						return new SimpleStringProperty(Integer.toString(p.getValue().getStock()));
					}
				});

		furnitureTable.setItems(furnitureList);
	}

	private void filter() {

		// Wrap the ObservableList in a FilteredList (initially display all
		// data).
		FilteredList<Furniture> filteredData = new FilteredList<>(furnitureList, p -> true);

		// Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(items -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter
				// text.
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

		// Add sorted (and filtered) data to the table.
		furnitureTable.setItems(filteredData);
		furnitureTable.refresh();

	}

	@FXML
	private void initialize() {
		furnitureList = Database.loadFurniture();
		selectedItem = furnitureList.get(0);
		pricetag = furnitureList.get(selectedItem.getId() - 1).getPrice();
		nameIn = furnitureList.get(selectedItem.getId() - 1).getName();
		exTextIn = furnitureList.get(selectedItem.getId() - 1).getDescription();
		img = new Image(furnitureList.get(selectedItem.getId() - 1).getPictureFile());

		priceTag.setText(pricetag + euro);
		name.setText(nameIn);
		exText.setText(exTextIn);
		imgView.setImage(img);
		fillTable();
		filter();
	}

	@FXML
	private void select() {

		selectedItem = furnitureTable.getSelectionModel().getSelectedItem();
		int currentId = selectedItem.getId() - 1;
		pricetag = furnitureList.get(currentId).getPrice();
		nameIn = furnitureList.get(currentId).getName();
		exTextIn = furnitureList.get(currentId).getDescription();
		img = new Image(furnitureList.get(currentId).getPictureFile());

		priceTag.setText(pricetag + euro);
		name.setText(nameIn);
		exText.setText(exTextIn);
		imgView.setImage(img);
		tabPane.getSelectionModel().select(firstTab);

		respText.setText("");
	}

	@FXML
	private void goZoom() throws IOException {
		respText.setText("");
		Main.showCustZomm();
	}

	int x = 1;

	//ADD TO CART
	@FXML
	private void buyAdd() throws IOException {
		respText.setText("");
		if (x < 99) {
			x++;
			String temp = Integer.toString(x);
			amount.setText(temp);
		}
	}

	@FXML
	private void buySub() throws IOException {
		respText.setText("");
		if (x > 1) {
			x--;
			String temp = Integer.toString(x);
			amount.setText(temp);
		}
	}
	
	//REMOVE FROM CART
	@FXML
	private void removeAdd() throws IOException {
		if (x < shoppingCart.containsItemWithId(cartTable.getSelectionModel().getSelectedItem().getId())) {
			x++;
			String temp = Integer.toString(x);
			LOLOLOLAMOUNTOLOLO.setText(temp);
		}
	}

	@FXML
	private void removeSub() throws IOException {
		if (x > 1) {
			x--;
			String temp = Integer.toString(x);
			LOLOLOLAMOUNTOLOLO.setText(temp);
		}
	}

	
	@FXML
	private boolean addToCartButton() throws InterruptedException {

		String temp = amount.getText();
		int i = Integer.parseInt(temp);
		if (i == 1) {
			if (shoppingCart.addItemToList(selectedItem)) {
				fillCartTable();
				respText.setText("Added item to cart!");
				amount.setText("1");
				x = 1;
				return true;
			} else {
				respText.setText("Item stock not sufficient!");
				amount.setText("1");
				x = 1;
				return false;
			}
		}
		if (i > 1) {
			if (shoppingCart.addItemToList(selectedItem, i)) {
				fillCartTable();
				respText.setText("Added items to cart!");
				amount.setText("1");
				x = 1;
				return true;
			} else {
				respText.setText("Item stock not sufficient!");
				amount.setText("1");
				x = 1;
				return false;
			}
		}
		return false;
	}

	private boolean removeFromCartButton() {

		String temp = LOLOLOLAMOUNTOLOLO.getText();
		int i = Integer.parseInt(temp);
		if (i == 1) {
			if (shoppingCart.removeItemFromList(selectedItem.getId())) {
				fillCartTable();
				return true;
			} else {
				LOLOLOLRESPONSEOLOLOO.setText("Error!");
				return false;
			}
		}
		if (i > 1) {
			if (shoppingCart.removeItemFromList(selectedItem.getId(), i)) {
				fillCartTable();
				return true;
			} else {
				LOLOLOLRESPONSEOLOLOO.setText("Error!");
				return false;
			}
		}
		return false;
	}

}
