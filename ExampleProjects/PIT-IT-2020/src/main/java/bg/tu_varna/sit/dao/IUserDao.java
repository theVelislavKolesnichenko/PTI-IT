package bg.tu_varna.sit.dao;

import bg.tu.varna.sit.beans.User;
import java.util.List;

public interface IUserDao {
	List<User> findAll();
}
