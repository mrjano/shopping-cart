package mrjano.com.shoppingcart;

import java.util.List;

import mrjano.com.shoppingcart.data.Item;

/**
 * Created by Jano Amigo on 19/04/2018.
 */

public class ShoppingCart {

    public Float processItems(List<Item> list) {
        Float total = 0f;
        for (Item item : list) {
            total += item.price;
        }
        return total;
    }
}
