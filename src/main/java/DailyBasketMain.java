import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DailyBasketMain {

    public static void main(String args[]) throws IOException {



        Item itemObj = new Item();
        Inventory inventoryObj = new Inventory();
        User userObj = new User();
        Cart cartObj = new Cart();

        File file = new File("C:\\Users\\Rahul Chaudhary\\IdeaProjects\\DailyBasket\\src\\main\\resources\\input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            String [] strArr = st.split("\\(");
            String newStrArr[] = strArr[1].split(",");
            switch (strArr[0]){
                case "createItem":
                    itemObj.createItem(newStrArr[0].trim(), newStrArr[1].trim(), Float.parseFloat(newStrArr[2].trim().substring(0, newStrArr[2].trim().length()-1)));
                    break;
                case "addInventory":
                    inventoryObj.addInventory(newStrArr[0].trim(), newStrArr[1].trim(), Integer.parseInt(newStrArr[2].trim().substring(0, newStrArr[2].trim().length()-1)));
                    break;
                case "addUser":
                    userObj.addUser(newStrArr[0].trim(), Float.parseFloat(newStrArr[1].trim().substring(0, newStrArr[1].trim().length()-1)));
                    break;
                case "addToCart":
                    cartObj.addToCart(newStrArr[0].trim(), newStrArr[1].trim(), newStrArr[2].trim(), Integer.parseInt(newStrArr[3].trim().substring(0, newStrArr[3].trim().length()-1)));
                    break;
                case "updateCart":
                    cartObj.updateCart(newStrArr[0].trim(), newStrArr[1].trim(), newStrArr[2].trim(), Integer.parseInt(newStrArr[3].trim().substring(0, newStrArr[3].trim().length()-1)));
                    break;
                case "removeFromCart":
                    //System.out.println(newStrArr[0] + newStrArr[1] + " " + newStrArr[2].trim().substring(0, newStrArr[2].length()-2));
                    cartObj.removeFromCart(newStrArr[0].trim(), newStrArr[1].trim(), newStrArr[2].trim().substring(0, newStrArr[2].trim().length()-1));
                    break;
                case "getCart":
                    cartObj.getCart(newStrArr[0].trim().substring(0, newStrArr[0].trim().length()-1), itemObj);
                    break;
                case "cartCheckout":
                    cartObj.cartCheckout(newStrArr[0].trim().substring(0, newStrArr[0].length()-1), itemObj, inventoryObj, userObj);
                    break;
                default:
                    System.out.println("enter correct command");
                    break;
            }

        }
    }
}
