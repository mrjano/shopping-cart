package mrjano.com.shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mrjano.com.shoppingcart.data.Apple;
import mrjano.com.shoppingcart.data.Item;
import mrjano.com.shoppingcart.data.Orange;

/**
 * Created by Jano Amigo on 19/04/2018.
 */

public class ShoppingCart {

    public Float processItems(List<Item> list) {
        List<Item> discountedList = new ArrayList<>(list);
        discountedList = applyAppleDiscount(discountedList);
        discountedList = applyOrangeDiscount(discountedList);
        Float total = 0f;
        for (Item item : discountedList) {
            total += item.price;
        }
        return total;
    }

    private List<Item> applyAppleDiscount(List<Item> list) {
        Iterator<Item> iterator = list.iterator();
        boolean firstFound = false;
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if(item instanceof Apple) {
                if(firstFound) {
                    iterator.remove();
                    firstFound = false;
                }
                else {
                    firstFound = true;
                }
            }
        }
        return list;
    }

    private List<Item> applyOrangeDiscount(List<Item> list) {
        Iterator<Item> iterator = list.iterator();
        List<Orange> orangesFound = new ArrayList<>();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if(item instanceof Orange) {
                if(orangesFound.size() == 2) {
                    iterator.remove();
                    orangesFound.clear();
                }
                else {
                    orangesFound.add((Orange) item);
                }
            }
        }
        return list;
    }
}
