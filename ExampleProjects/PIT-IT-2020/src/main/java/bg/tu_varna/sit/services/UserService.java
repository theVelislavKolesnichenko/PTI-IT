package bg.tu_varna.sit.services;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import bg.tu.varna.sit.beans.User;
import bg.tu_varna.sit.dao.IUserDao;

//@ManagedBean
public class UserService implements IUserService {
	
	private IUserDao userDao;
	
	@Inject
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

}
