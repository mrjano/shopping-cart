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
        Float total = shoppingCart.processItems(Arrays.<Item>asList(new Apple()));
        assertTrue(total == 0.6f);
    }

    @Test
    public void shopping_cart_accepts_both() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Float total = shoppingCart.processItems(Arrays.asList(new Apple(), new Apple(), new Orange()));
        assertTrue(total == 1.45f);
    }

    @Test
    public void apply_apple_discount() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Float total = shoppingCart.processItems(Arrays.<Item>asList(new Apple(), new Apple()));
        assertTrue(total == 0.6f);
        //Test double discount
        Float totalDouble = shoppingCart.processItems(Arrays.<Item>asList(new Apple(), new Apple(), new Apple(), new Apple()));
        assertTrue(total == 1.2f);
    }

    @Test
    public void apply_orange_discount() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Float total = shoppingCart.processItems(Arrays.<Item>asList(new Orange(), new Orange(), new Orange()));
        assertTrue(total == 0.5f);
        //Test double discount
        Float totalDouble = shoppingCart.processItems(Arrays.<Item>asList(new Orange(), new Orange(), new Orange(), new Orange(), new Orange(), new Orange()));
        assertTrue(totalDouble == 1.0f);
    }

    @Test
    public void apply_both_discounts() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Float total = shoppingCart.processItems(Arrays.asList(new Orange(), new Orange(), new Orange(), new Apple(), new Apple()));
        assertTrue(total == 1.1f);
    }
}