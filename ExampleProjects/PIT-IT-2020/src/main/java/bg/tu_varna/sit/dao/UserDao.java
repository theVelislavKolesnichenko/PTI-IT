package bg.tu_varna.sit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import bg.tu.varna.sit.beans.User;

//@ManagedBean
public class UserDao implements IUserDao {

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		
		users.add(new User(1, "User 1"));
		users.add(new User(1, "User 2"));
		users.add(new User(1, "User 3"));
		users.add(new User(1, "User 4"));
		
		return users;
	}

}
