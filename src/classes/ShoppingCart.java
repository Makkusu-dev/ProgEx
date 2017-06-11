package classes;
import java.util.ArrayList;

/**
 * The ShoppingCart class of the ProgEx project. It contains methods for adding and removing items to and from the shopping cart.
 * 
 * @version 1.0
 */
public class ShoppingCart {

	private ArrayList<Furniture> itemList;

	/**
	 * The addItemToList method adds one object of the Furniture data type to the ArrayList of the shopping cart, if the stock value is greater than one. It then decreases the Stock value of the Furniture object by one.
	 * 
	 * @param item	A Furniture object to be added to the ArrayList of the shopping cart.
	 * @return true if the Furniture object was added to the list, and its stock value was decreased by one. Otherwise false.
	 * @see Furniture
	 */
	public boolean addItemToList(Furniture item) {
		if (this.itemList.add(item)) {
			int stock = item.getStock();
			if (stock < 1) {
				return false;
			} else {
				item.setStock(stock - 1);
			}
			return true;
		} else
			return false;
	}

	/**
	 * The removeItemFromList method removes one object of the Furniture data type from the ArrayList of the shopping cart, if one exists in the ArrayList. It then increases the Stock value of the Furniture object by one.
	 * 
	 * @param id	The id of the Furniture object, that is to be removed from the ArrayList of the shopping cart.
	 * @return true if the Furniture object was removed from the list, and its stock value was increased by one. Otherwise false.
	 * @see Furniture
	 */
	public boolean removeItemFromList(int id) {
		int index = this.containsItemWithId(id);
		if (index >= 0) {
			Furniture item = this.itemList.get(index);
			item.setStock(item.getStock() + 1);
			this.itemList.remove(index);
			return true;
		}
		return false;
	}

	private int containsItemWithId(int id) {
		int index = 0;
		for (Furniture i : this.itemList) {
			index++;
			if (i.getId() == id) {
				return index;
			}
		}
		return -1;
	}

}