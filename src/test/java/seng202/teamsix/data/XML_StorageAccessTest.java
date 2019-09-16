package seng202.teamsix.data;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class XML_StorageAccessTest {
    @Test
    public void testConstructor() {
        XML_StorageAccess invalid;
        XML_StorageAccess valid;

        // Test pass case
        try {
            valid = new XML_StorageAccess("test_data");
        }catch (IOException e) {
            fail("XML_StorageAccess unable to create valid directory");
        }catch (JAXBException e) {
            System.out.println(e.toString());
            fail("XML_StorageAccess could not create jaxb object contexts");
        }

        // Test fail case
        boolean caught_exception = false;
        try {
            invalid = new XML_StorageAccess("impossibledirectory/shouldnotexist");
        }catch (IOException e) {
           caught_exception = true;
        }catch (JAXBException e) {
            fail("XML_StorageAccess could not create jaxb object contexts");
        }

        assertTrue(caught_exception);
    }

    @Test
    public void testUpdateItem() {
        XML_StorageAccess storage;

        // Test pass case
        try {
            storage = new XML_StorageAccess("test_data");
            Item item = new Item("Test Item",
                                 "This item is being used to test the xml system",
                                 new Currency(10, 50),
                                 new Currency(14,99),
                                 new Recipe("1. Create a test\n2. Run test\n3. See if build passes\n"),
                                 new ArrayList<ItemTag_Ref>(),
                                 UnitType.NUM);
            storage.updateItem(item);
            storage.saveData();

            // Reload
            storage.loadData();
            Item_Ref ref = storage.getItem(item);
            assertTrue(ref.equals(item));
        }catch (IOException e) {
            fail("XML_StorageAccess unable to create valid directory");
        }catch (JAXBException e) {
            System.out.println(e.toString());
            fail("XML_StorageAccess could not create jaxb object contexts");
        }
    }

    @Test
    public void testUpdateItemTag() {
        XML_StorageAccess storage;

        // Test pass case
        try {
            storage = new XML_StorageAccess("test_data");
            ItemTag tag = new ItemTag("Gluten Free", true);
            storage.updateItemTag(tag);
            storage.saveData();

            // Reload
            storage.loadData();
            assertTrue(storage.getItemTag(tag).equals(tag));

        }catch (IOException e) {
            fail("XML_StorageAccess unable to create valid directory");
        }catch (JAXBException e) {
            System.out.println(e.toString());
            fail("XML_StorageAccess could not create jaxb object contexts");
        }
    }

    @Test
    public void testUpdateMenu() {
        XML_StorageAccess storage;

        // Test pass case
        try {
            storage = new XML_StorageAccess("test_data");
            Menu menu = new Menu();
            menu.setName("My Menu");
            menu.setDescription("Hello I am a menu description");
            menu.addToMenu(new MenuItem());
            storage.updateMenu(menu);
            storage.saveData();

            // Reload
            storage.loadData();
            assertTrue(storage.getMenu(menu).equals(menu));
        }catch (IOException e) {
            fail("XML_StorageAccess unable to create valid directory");
        }catch (JAXBException e) {
            System.out.println(e.toString());
            fail("XML_StorageAccess could not create jaxb object contexts");
        }
    }

    @Test
    public void testUpdateOrder() {
        XML_StorageAccess storage;

        // Test pass case
        try {
            storage = new XML_StorageAccess("test_data");
            Order order = new Order();
            order.setTimestamp(new Date());
            order.getOrderTree().addDependant(new OrderItem());
            storage.updateOrder(order);
            storage.saveData();

            // Reload
            storage.loadData();
            assertTrue(storage.getOrder(order).equals(order));

        }catch (IOException e) {
            fail("XML_StorageAccess unable to create valid directory");
        }catch (JAXBException e) {
            System.out.println(e.toString());
            fail("XML_StorageAccess could not create jaxb object contexts");
        }
    }


    @Test
    public void testUpdateStockInstance() {
        XML_StorageAccess storage;

        // Test pass case
        try {
            storage = new XML_StorageAccess("test_data");
            StockInstance stock = new StockInstance(new Date(), true, new Date(), 4);
            storage.updateStockInstance(stock);
            storage.saveData();

            // Reload
            storage.loadData();
            assertTrue(storage.getStockInstance(stock).equals(stock));

        }catch (IOException e) {
            fail("XML_StorageAccess unable to create valid directory");
        }catch (JAXBException e) {
            System.out.println(e.toString());
            fail("XML_StorageAccess could not create jaxb object contexts");
        }
    }

    @Test
    public void testGetAll() {
        XML_StorageAccess storage;

        // Test pass case
        try {
            storage = new XML_StorageAccess("test_data");
            for (Item_Ref ref : storage.getAllItems()) {
                assertNotNull(storage.getItem(ref));
            }
            for (ItemTag_Ref ref : storage.getAllItemTags()) {
                assertNotNull(storage.getItemTag(ref));
            }
            for (Menu_Ref ref : storage.getAllMenus()) {
                assertNotNull(storage.getMenu(ref));
            }
            for (Order_Ref ref : storage.getAllOrders()) {
                assertNotNull(storage.getOrder(ref));
            }
            for (StockInstance_Ref ref : storage.getAllStockInstances()) {
                assertNotNull(storage.getStockInstance(ref));
            }

        }catch (IOException e) {
            fail("XML_StorageAccess unable to create valid directory");
        }catch (JAXBException e) {
            System.out.println(e.toString());
            fail("XML_StorageAccess could not create jaxb object contexts");
        }
    }
}