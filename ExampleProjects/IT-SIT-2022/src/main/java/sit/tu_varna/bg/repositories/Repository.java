package sit.tu_varna.bg.repositories;

import sit.tu_varna.bg.datasource.UserList;
import sit.tu_varna.bg.datasource.Users;
import sit.tu_varna.bg.models.Login;
import sit.tu_varna.bg.models.Skill;
import sit.tu_varna.bg.models.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Map;

public class Repository {

    private static Repository instance = null;

    //static private HashSet<User> users = new HashSet<User>(new UserList().getUserBeans());
    static private HashSet<User> users;

    private Repository() {
        /*users = new HashSet<>(new UserList().getUserBeans());
        new Users().update(this.users);*/
        users = new HashSet<>(new Users().getUserBeans());
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public boolean hasExist(User user) {
        return users.contains(user);
    }

    public boolean hasExist(Login login) {
        for (User user : users) {
            if (user.getLogin().equals(login))
                return true;
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
        new Users().update(this.users);
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

    public boolean update(User user, User newUser) {
        boolean result = user.update(newUser);
        new Users().update(this.users);
        return result;
    }

    public boolean update(User user, Map<String, Short> skills) {
        boolean result = user.update(skills);
        new Users().update(this.users);
        return result;
    }

    public HashSet<User> getUsers() {
        return users;
    }
}
