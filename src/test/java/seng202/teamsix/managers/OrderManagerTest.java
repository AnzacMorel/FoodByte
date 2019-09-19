package seng202.teamsix.managers;

import org.junit.jupiter.api.Test;
import seng202.teamsix.data.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {

    @Test
    void addToCartTest() {
        OrderManager orderManager = new OrderManager();
        orderManager.resetCart();
        MenuItem menuItemToAdd = initialiseItem1();
        orderManager.addToCart(menuItemToAdd, 5);
        OrderItem orderItemRetrievedFromOrder = orderManager.getCart().getOrderTree().getDependants().get(0);

        assertEquals(((Item)menuItemToAdd.getItem()).getName(), ((Item)orderItemRetrievedFromOrder.getItem()).getName());
        assertEquals(5, orderItemRetrievedFromOrder.getQuantity());

        orderManager.addToCart(menuItemToAdd, 10);
        orderItemRetrievedFromOrder = orderManager.getCart().getOrderTree().getDependants().get(0);

        assertEquals(15, orderItemRetrievedFromOrder.getQuantity());
    }

    @Test
    void resetCartTest() {
        OrderManager orderManager = new OrderManager();
        orderManager.resetCart();

        assertEquals(0, orderManager.getCart().getOrderTree().getDependants().size());
    }

    @Test
    void testGetCashRequiredTest() {
        OrderManager orderManager = new OrderManager();
        orderManager.resetCart();
        MenuItem menu_item = initialiseItem1();
        orderManager.addToCart(menu_item, 25);

        assertEquals(250.0, orderManager.getCashRequired().getTotalCash());
    }

    MenuItem initialiseItem1() {
        ArrayList<ItemTag_Ref> tagList = new ArrayList<ItemTag_Ref>();
        Recipe recipe = new Recipe("Cut Potatoes, cover in batter, deep-try for 5 minutes.");
        Currency base_price = new Currency();
        base_price.setTotalCash(7.50);
        Currency markup_price = new Currency();
        markup_price.setTotalCash(10.00);
        Item item = new Item("Large Fries", "Deep-fried pieces of potato. ", base_price, markup_price, recipe, tagList, UnitType.G);
        MenuItem menuItem = new MenuItem();
        menuItem.setItem(item);
        return menuItem;
    }
}