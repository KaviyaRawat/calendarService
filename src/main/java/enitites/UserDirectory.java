package enitites;

import java.util.HashMap;

public class UserDirectory {

    private static HashMap<Integer, User> map = new HashMap<>();

    public HashMap<Integer, User> getMap() {
        return map;
    }

    public static  void addUser(User user){
        map.put(user.getId(), user);
    }

    public static User getUser(Integer integer) {
        return map.get(integer);
    }
}
