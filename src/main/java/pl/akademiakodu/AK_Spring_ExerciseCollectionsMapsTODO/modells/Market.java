package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {

    public enum Item {POTATO, ONION, TOMATO, CUCUMBER, GARLIC, PEPER, APPLE, BREAD}
    public static HashMap<Enum, Integer> shopList;

    public Market() {
        shopList = new HashMap<>();
    }

    public void addItem(Item item, int qty){
        // todo
    }

    public String showCurrentList(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Enum, Integer> element : shopList.entrySet()){
            sb.append("Item: " + element.getKey() + " = " + element.getValue() + "pcs; *** ");
        }
        return sb.toString();
    }

    public int calculatePrice(){
        //todo
        return 0;
    }

    public int parseInt(String s){
        int result = 0;
        try {
            result = Integer.parseInt(s);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Cannot parse " + s + " to integer..");
        }
        return result;
    }

    public Item parseEnum(String s){
        Item result = null;
        List<Item> tempList = getItems();
        for (Item item : tempList) {
            if (s.equals(item.toString())){
                return item;
            }
        }
        throw new IllegalArgumentException("We do not have item: " + s + " in our item list..");
    }

    public String showAllItems(){
        StringBuilder sb = new StringBuilder();
        sb.append("Items: ");
        for (Item item : getItems()) {
            sb.append(item.toString() + ", ");
        }
        return sb.toString();
    }

    public List<Item> getItems(){
        return Arrays.asList(Item.POTATO, Item.ONION, Item.TOMATO, Item.CUCUMBER, Item.GARLIC,
                Item.PEPER, Item.APPLE, Item.BREAD);
    }

}
