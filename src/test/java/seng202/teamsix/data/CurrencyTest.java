package seng202.teamsix.data;

import org.junit.Test;
import static org.junit.Assert.*;

public class CurrencyTest {
    @Test
    public void testSetAndGetDollars() {
        Currency cash = new Currency();
        cash.setCents(500);
        assertEquals(5, cash.getDollars());
    }
    @Test
    public void testSetAndGetCents() {
        Currency cash = new Currency();
        cash.setCents(50);
        assertEquals(50, cash.getCents());
    }
    @Test
    public void testSetAndGetTotalCash() {
        Currency cash = new Currency();
        cash.setTotalCash(100);
        assertEquals(100, cash.getDollars());
    }
    @Test
    public void testAddCash() {
        Currency cash = new Currency();
        cash.setTotalCash(100);
        cash.addCash(5, 0);
        assertEquals(105, cash.getDollars());

        cash.setTotalCash(100);
        cash.addCash(5, 10);
        assertEquals(105, cash.getDollars());
        assertEquals(10, cash.getCents());

        // 10.40 + 6.70 = 17.10
        cash.setDollars(10);
        cash.setCents(40);
        cash.addCash(5, 170);
        assertEquals(17, cash.getDollars());
        assertEquals(10, cash.getCents());
    }
    @Test
    public void testSubCash() {
        Currency cash = new Currency();
        cash.setTotalCash(100);
        cash.subCash(5, 0);
        assertEquals(95, cash.getDollars());
        cash.setTotalCash(100);
        cash.subCash(5, 10);
        assertEquals(94, cash.getDollars());
        assertEquals(90, cash.getCents());

        // 10.40 - 6.70 = 3.70
        cash.setDollars(10);
        cash.setCents(40);
        cash.subCash(5, 170);
        assertEquals(3, cash.getDollars());
        assertEquals(70, cash.getCents());
    }

    @Test
    public void testCompareTo() {
        Currency cash = new Currency(10, 50);
        Currency less = new Currency(8,60);
        Currency more = new Currency(10, 70);

        assertTrue(cash.compareTo(less) < 0);
        assertTrue(cash.compareTo(more) > 0);
        assertTrue(cash.compareTo(cash) == 0);
    }
}
