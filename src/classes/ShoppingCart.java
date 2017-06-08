package classes;

import java.util.ArrayList;

public class ShoppingCart {

	private ArrayList<Furniture> itemList;

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