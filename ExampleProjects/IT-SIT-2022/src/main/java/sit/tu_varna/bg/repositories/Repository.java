package sit.tu_varna.bg.repositories;

import sit.tu_varna.bg.datasource.UserList;
import sit.tu_varna.bg.models.Login;
import sit.tu_varna.bg.models.User;

import java.util.HashSet;

public class Repository {

    static Repository instance = null;

    HashSet<User> users = new HashSet<User>();
    static int index = 1;

    public Repository() {
        users = new HashSet<>(new UserList().getUserBeans());
    }

    public boolean hasExist(Login login) {
        return users.contains(new User(login));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByLogin(Login login) {
        for (User user : users) {
            if(login.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }

    public User getUserByUsername(Login login) {
        for (User user : users) {
            if(user.equals(new User(login))) {
                return user;
            }
        }
        return null;
    }
}
