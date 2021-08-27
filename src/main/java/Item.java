import java.util.HashMap;

public class Item {
    HashMap<String, HashMap<String, Float>> itemHashMap;

    public Item() {
        itemHashMap = new HashMap<>();
    }

    public void createItem(String itemCategory, String brand, float price) {

        if (itemHashMap.containsKey(itemCategory)) {
            HashMap<String, Float> brandHashMap = itemHashMap.get(itemCategory);

            if (brandHashMap.containsKey(brand)) {
                System.out.println("Item already exists");
            }

            else {
                brandHashMap.put(brand, price);
                System.out.println("Item created successfully");
            }
        }
        else {

            HashMap<String, Float> brandHashMap = new HashMap<>();
            brandHashMap.put(brand, price);
            itemHashMap.put(itemCategory, brandHashMap);
            System.out.println("Item created successfully");
        }
    }

    public HashMap<String, HashMap<String, Float>> getItemHashMap() {
        return itemHashMap;
    }

    public void setItemHashMap(HashMap<String, HashMap<String, Float>> itemHashMap) {
        this.itemHashMap = itemHashMap;
    }
}
