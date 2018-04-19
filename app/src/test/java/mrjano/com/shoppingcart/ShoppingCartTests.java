package mrjano.com.shoppingcart;

import org.junit.Test;

import java.util.Arrays;

import mrjano.com.shoppingcart.data.Apple;
import mrjano.com.shoppingcart.data.Item;
import mrjano.com.shoppingcart.data.Orange;

import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ShoppingCartTests {
    
    @Test
    public void shopping_cart_accepts_oranges() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Float total = shoppingCart.processItems(Arrays.<Item>asList(new Orange(), new Orange()));
        assertTrue(total == 0.5f);
    }

    @Test
    public void shopping_cart_accepts_apples() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Float total = shoppingCart.processItems(Arrays.<Item>asList(new Apple(), new Apple()));
        assertTrue(total == 1.2f);
    }
}