package sit.tu_varna.bg.repositories;

import sit.tu_varna.bg.datasource.UserList;
import sit.tu_varna.bg.models.Login;
import sit.tu_varna.bg.models.User;

import java.util.HashSet;

public class Repository {

    private static Repository instance = null;

    //static
    private HashSet<User> users; //= new HashSet<User>(new UserList().getUserBeans());

    private Repository() {
        users = new HashSet<>(new UserList().getUserBeans());
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

    public void update(User user, User newUser) {
        user.update(newUser);
//        User updateUser = this.getUserByUsername(user.getLogin());
//        updateUser.update(newUser);
//        this.addUser(updateUser);
    }

    public HashSet<User> getUsers() {
        return users;
    }
}
