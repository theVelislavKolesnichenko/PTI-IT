package sit.tu_varna.bg.datasource;

import sit.tu_varna.bg.models.User;

import java.util.ArrayList;
import java.util.HashSet;

public interface DataContext {
    ArrayList<User> getUserBeans();
    void update(HashSet<User> users);
}
