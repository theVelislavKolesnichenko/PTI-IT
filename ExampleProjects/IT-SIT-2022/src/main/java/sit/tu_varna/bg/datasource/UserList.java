package sit.tu_varna.bg.datasource;

import sit.tu_varna.bg.models.Login;
import sit.tu_varna.bg.models.User;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public ArrayList<User> getUserBeans() {
        return new ArrayList<User>() {{
            add(new User("name", new Login("user@mail.com", "pass")));
        }};
    }
}
