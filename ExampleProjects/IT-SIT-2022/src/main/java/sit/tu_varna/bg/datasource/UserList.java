package sit.tu_varna.bg.datasource;

import sit.tu_varna.bg.models.Login;
import sit.tu_varna.bg.models.User;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> userBeans;

    public ArrayList<User> getUserBeans() {
        return new ArrayList<User>(){{
            new User("user1", new Login("name", "pass"));
            new User("user1", new Login("name", "pass"));
            new User("user1", new Login("name", "pass"));
            new User("user1", new Login("name", "pass"));
            new User("user1", new Login("name", "pass"));
            new User("user1", new Login("name", "pass"));
        }};
    }

    public void setUserBeans(ArrayList<User> userBeans) {
        this.userBeans = userBeans;
    }
}
