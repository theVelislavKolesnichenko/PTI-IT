package bg.tu.varna.cs.XMLProject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	private int id;
	private String firstName;
	private String lastName;
	
	public User() {}

	public User(int i, String string, String string2) {
		id = i;
		firstName = string;
		lastName = string2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
