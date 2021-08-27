import java.util.HashMap;

public class Inventory {
    HashMap<String, HashMap<String, Integer>> inventoryHashMap;

    public Inventory() {
        inventoryHashMap = new HashMap<>();
    }

    public void addInventory(String itemCategory, String brand, Integer quantity) {
        if (inventoryHashMap.containsKey(itemCategory)) {
            HashMap<String, Integer> brandHashMap = inventoryHashMap.get(itemCategory);

            if (brandHashMap.containsKey(brand)) {
                System.out.println("Item already exists in inventory");
            }

            else {
                brandHashMap.put(brand, quantity);
                System.out.println("Item added to inventory");
            }
        }
        else {

            HashMap<String, Integer> brandHashMap = new HashMap<>();
            brandHashMap.put(brand, quantity);
            inventoryHashMap.put(itemCategory, brandHashMap);
            System.out.println("Item added to inventory");
        }
    }

    public HashMap<String, HashMap<String, Integer>> getInventoryHashMap() {
        return inventoryHashMap;
    }

    public void setInventoryHashMap(HashMap<String, HashMap<String, Integer>> inventoryHashMap) {
        this.inventoryHashMap = inventoryHashMap;
    }
}
