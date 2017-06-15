package core;

import classes.Furniture;
import classes.ShoppingCart;
import javafx.collections.ObservableList;

public class Main {

	public static void main(String[] args) {

		ObservableList<Furniture> furniture = Database.loadFurniture();
		ShoppingCart cart = new ShoppingCart();

		System.out.println("Name: " + furniture.get(0).getName() + " Stock: " + furniture.get(0).getStock());
		System.out.println(cart.itemList.toString());

		cart.addItemToList(furniture.get(0), 4);
		System.out.println("Buy 4");

		System.out.println("Name: " + furniture.get(0).getName() + " Stock: " + furniture.get(0).getStock());
		System.out.println(cart.itemList.toString());

		cart.addItemToList(furniture.get(0));
		System.out.println("Buy 1");

		System.out.println("Name: " + furniture.get(0).getName() + " Stock: " + furniture.get(0).getStock());
		System.out.println(cart.itemList.toString());

		cart.removeItemFromList(1);
		System.out.println("Remove 1");

		System.out.println("Name: " + furniture.get(0).getName() + " Stock: " + furniture.get(0).getStock());
		System.out.println(cart.itemList.toString());

		cart.removeItemFromList(1, 4);
		System.out.println("Remove 4");

		System.out.println("Name: " + furniture.get(0).getName() + " Stock: " + furniture.get(0).getStock());
		System.out.println(cart.itemList.toString());
	}

}
