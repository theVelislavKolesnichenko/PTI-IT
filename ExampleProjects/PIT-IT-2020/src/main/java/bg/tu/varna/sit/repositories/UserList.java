package bg.tu.varna.sit.repositories;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import bg.tu.varna.sit.beans.UserBean;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserList {
	
	@XmlElement(name = "user")
    private ArrayList<UserBean> userBeans;

	public ArrayList<UserBean> getUserBeans() {
		return userBeans;
	}

	public void setUserBeans(ArrayList<UserBean> userBeans) {
		this.userBeans = userBeans;
	}

}
