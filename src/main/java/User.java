import java.util.HashMap;

public class User {

    HashMap<String, Float> userHashMap;

    public User() {
        userHashMap = new HashMap<>();
    }

    public void addUser(String userName, float walletAmount) {

        if (!userHashMap.containsKey(userName)) {
            userHashMap.put(userName, walletAmount);
            System.out.println("User added successfully");
        }
        else {
            System.out.println("User Already exists");
        }
    }

    public HashMap<String, Float> getUserHashMap() {
        return userHashMap;
    }

    public void setUserHashMap(HashMap<String, Float> userHashMap) {
        this.userHashMap = userHashMap;
    }
}
