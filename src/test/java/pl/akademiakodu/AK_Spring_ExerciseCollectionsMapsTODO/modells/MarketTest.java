package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MarketTest {

    private static Market market;

    @BeforeClass
    public static void start() {
        market = new Market();
    }

    @AfterClass
    public static void stop() throws Exception {
        market = null;
    }

    @Test
    public void test() throws Exception {
        HashMap<Enum, Integer> actual = new HashMap<>();
        actual.put(Market.Item.APPLE, 5);
        actual.put(Market.Item.TOMATO, 3);
        market.addItem(Market.Item.TOMATO, 3);
        market.addItem(Market.Item.APPLE, 5);
        assertEquals(43, market.calculatePrice());
        comparatorHashMap(actual, Market.shopList);
        market.addItem(Market.Item.APPLE, 2);
        market.addItem(Market.Item.APPLE, -1);
        market.addItem(Market.Item.APPLE, -1);
        assertEquals(43, market.calculatePrice());
        comparatorHashMap(actual, Market.shopList);
        actual.put(Market.Item.BREAD, -4);
        market.addItem(Market.Item.BREAD, -4);
        assertEquals(23, market.calculatePrice());
        comparatorHashMap(actual, Market.shopList);
    }

    @Test public void testExc(){
        String test = "Onion 54";
        try {
            market.parseInt(test);
            fail("Exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse " + test + " to integer..");
        }

        try{
            market.parseEnum(test);
            fail("Exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "We do not have item: " + test + " in our item list..");
        }
    }

    private void comparatorHashMap(HashMap<Enum, Integer> actual, HashMap<Enum, Integer> expected){
        int c1 = 0;
        for (Map.Entry<Enum, Integer> elementActual : actual.entrySet()){
            int c2 = 0;
            for (Map.Entry<Enum, Integer> elementExcepted : expected.entrySet()){
                if (c1==c2){
                    assertEquals(elementActual.getKey(), elementExcepted.getKey());
                    assertEquals(elementActual.getValue(), elementExcepted.getValue());
                    break;
                }
                c2++;
            }
            c1++;
        }
    }
}