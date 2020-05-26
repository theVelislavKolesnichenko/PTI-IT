package bg.tu.varna.cs.PPTIXMLProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
	
	@XmlElement(name = "user")
	private HashSet<User> users;
	
	public Users() {
		this(new HashSet<User>());
	}
	
	public Users(HashSet<User> users) {
		this.users = users;
	}

	public HashSet<User> getUsers() {
		return users;
	}

	public void setUsers(HashSet<User> users) {
		this.users = users;
	}
}
