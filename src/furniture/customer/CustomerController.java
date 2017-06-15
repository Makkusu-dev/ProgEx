package furniture.customer;
import classes.*;
import core.Database;

import java.io.IOException;

import furniture.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class CustomerController {
	 String euro = "\u20ac";
	 private Main main;


	@FXML
	private Text priceTag;

	@FXML
	private Text name;

	@FXML Text exText;

	@FXML
	private ImageView imgView;

	@FXML
	private Text amount;


	private float pricetag;
	private String nameIn;
	private String exTextIn;
	private Image img;
	ObservableList<Furniture> furnitureList;

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
	}

	@FXML
	private void goAdmin() throws IOException{

		main.showLoginScene();

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


