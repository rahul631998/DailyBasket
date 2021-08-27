import java.util.HashMap;
import java.util.Map;

public class Cart {

    HashMap<String, HashMap<String,HashMap<String, Integer>>> userCartHashMap;

    public Cart() {
        userCartHashMap = new HashMap<>();
    }

    public void addToCart(String userName, String itemCategory, String brand, Integer quantity) {

        if (userCartHashMap.containsKey(userName)) {
            HashMap<String, HashMap<String, Integer>> itemCategoryHashMap = userCartHashMap.get(userName);

            if (itemCategoryHashMap.containsKey(itemCategory)) {
                HashMap<String, Integer> brandHashMap = itemCategoryHashMap.get(itemCategory);

                if (brandHashMap.containsKey(brand)) {
                    System.out.println("Already added in card\n use updateCart to update quantity");
                }
                else {
                    //add
                    brandHashMap.put(brand, quantity);
                    System.out.println("Item added to cart successfully");
                }

            }
            else {
                //add
                HashMap<String, Integer> brandHashMap = new HashMap<>();
                brandHashMap.put(brand, quantity);
                itemCategoryHashMap.put(itemCategory, brandHashMap);
                System.out.println("Item added to cart successfully");
            }
        }
        else {
            //add
            HashMap<String, HashMap<String, Integer>> itemCategoryHashMap = new HashMap<>();
            HashMap<String, Integer> brandHashMap = new HashMap<>();
            brandHashMap.put(brand, quantity);
            itemCategoryHashMap.put(itemCategory, brandHashMap);
            userCartHashMap.put(userName, itemCategoryHashMap);
            System.out.println("Item added to cart successfully");
        }
    }

    public void updateCart(String userName, String itemCategory, String brand, Integer quantity) {

        if (userCartHashMap.containsKey(userName)) {
            HashMap<String, HashMap<String, Integer>> itemCategoryHashMap = userCartHashMap.get(userName);

            if (itemCategoryHashMap.containsKey(itemCategory)) {
                HashMap<String, Integer> brandHashMap = itemCategoryHashMap.get(itemCategory);

                if (brandHashMap.containsKey(brand)) {
                    //update
                    brandHashMap.put(brand, quantity);
                    System.out.println("Updated Cart successfully");
                }
                else {
                    System.out.println("Item doesn't exist in cart");
                }

            }
            else {
                System.out.println("Item doesn't exist in cart");
            }
        }
        else {
            System.out.println("Item doesn't exist in cart");
        }
    }

    public void removeFromCart(String userName, String itemCategory, String brand) {

        if (userCartHashMap.containsKey(userName)) {
            HashMap<String, HashMap<String, Integer>> itemCategoryHashMap = userCartHashMap.get(userName);

            if (itemCategoryHashMap.containsKey(itemCategory)) {
                HashMap<String, Integer> brandHashMap = itemCategoryHashMap.get(itemCategory);

                if (brandHashMap.containsKey(brand)) {
                    //update
                    brandHashMap.remove(brand);
                    System.out.println("removed item from cart successfully");
                }
                else {
                    System.out.println("Item doesn't exist in cart. Can't remove");
                }

            }
            else {
                System.out.println("Item doesn't exist in cart. Can't remove");
            }
        }
        else {
            System.out.println("Item doesn't exist in cart. Can't remove");
        }
    }

    public void getCart(String userName, Item itemObj) {

        float cartValue = 0;

        HashMap<String, HashMap<String, Integer>> itemCategoryHashMap = userCartHashMap.get(userName);

        for (String itemCategory : itemCategoryHashMap.keySet()) {
            for (String brand : itemCategoryHashMap.get(itemCategory).keySet()) {
                System.out.print(itemCategory + " " + brand + " " + itemCategoryHashMap.get(itemCategory).get(brand));

                cartValue += itemObj.getItemHashMap().get(itemCategory).get(brand) * itemCategoryHashMap.get(itemCategory).get(brand);
            }
        }
        System.out.println();
        System.out.println(cartValue);
    }

    public void cartCheckout(String userName, Item itemObj, Inventory inventoryObj, User userObj) {

        float cartValue = 0;
        float walletAmount = userObj.userHashMap.get(userName);

        HashMap<String, HashMap<String, Integer>> itemCategoryHashMap = userCartHashMap.get(userName);


        for (String itemCategory : itemCategoryHashMap.keySet()) {

            if (!inventoryObj.inventoryHashMap.containsKey(itemCategory)) {
                System.out.println("itemCategory doesn't exist in inventory");
                return;
            }
            for (String brand : itemCategoryHashMap.get(itemCategory).keySet()) {

                if (!inventoryObj.inventoryHashMap.get(itemCategory).containsKey(brand)) {
                    System.out.println("brand doesn't exist in inventory");
                    return;
                }

                if (inventoryObj.inventoryHashMap.get(itemCategory).get(brand) <  itemCategoryHashMap.get(itemCategory).get(brand)) {
                    System.out.println("Not sufficient quantity in Inventory");
                    return;
                }


                cartValue += itemObj.getItemHashMap().get(itemCategory).get(brand) * itemCategoryHashMap.get(itemCategory).get(brand);

                if (cartValue > walletAmount) {
                    System.out.println("can't checkout. cartValue > wallletAmount");
                    return;
                }
            }
        }

        //updat user wallet
        userObj.userHashMap.put(userName, userObj.userHashMap.get(userName) - cartValue);

        //remove from inventory
        for (String itemCategory : itemCategoryHashMap.keySet()) {
            for (String brand : itemCategoryHashMap.get(itemCategory).keySet()) {

                inventoryObj.inventoryHashMap.get(itemCategory).put(brand, itemCategoryHashMap.get(itemCategory).get(brand) - itemCategoryHashMap.get(itemCategory).get(brand));
            }
        }
    }

    public HashMap<String, HashMap<String, HashMap<String, Integer>>> getCartHashMap() {
        return userCartHashMap;
    }

    public void setCartHashMap(HashMap<String, HashMap<String, HashMap<String, Integer>>> cartHashMap) {
        this.userCartHashMap = cartHashMap;
    }
}
