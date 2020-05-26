package bg.tu.varna.sit.repositories;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import bg.tu.varna.sit.beans.Address;
import bg.tu.varna.sit.beans.SkillBeen;
import bg.tu.varna.sit.beans.UserBean;
import bg.tu.varna.sit.utility.XMLWorker;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {

    static Repository instance = null;

    @XmlElement(name = "user")
    HashSet<UserBean> users = new HashSet<UserBean>();
	static int index = 1;
	private static String fileName = "F:\\DevRepository\\eclipse-workspace\\PIT-IT-2020\\src\\main\\webapp\\storage\\users.xml";
    
	private Repository() {
		
	}
	
	/*private Repository(String fileName) {
		XMLWorker worker = new XMLWorker();
		try {
			//UserList userList = worker.readerFromXMLFile(fileName);
			Repository repository = worker.readerFromXMLFileR(fileName);
			users.addAll(repository.getUsers());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		index = users.size() + 1;
	}*/
	
    /*private Repository() {  
    	new UserBean("Ivan", "passvord");
    	users.add(new UserBean("ivan@mail.mail", "password") { { 
    			setId(index++);
    			setName("Ivan");
    			setJobTitle("Софтуерен инжинер");
    			setInfo("Известен факт е, че читателя обръща внимание на съдържанието, което чете, а не на оформлението му. Свойството на Lorem Ipsum е, че до голяма степен има нормално разпределение на буквите и се чете по-лесно, за разлика от нормален текст на английски език като \"Това е съдържание, това е съдържание\".");
    			addJobSkill(new SkillBeen("Java", 30));
    			addJobSkill(new SkillBeen("HTML", 50));
    			addJobSkill(new SkillBeen("CSS", 70));
    			addJobSkill(new SkillBeen("JavaScript", 20));
    			addPersonSkill(new SkillBeen("Communicative", 10));
    			addPersonSkill(new SkillBeen("Teamwork", 40));
    			addPersonSkill(new SkillBeen("Creativity", 60));
    			setPhone("09876543219");
    			setAddress(new Address("Varna", "Students 1"));
    		} });
    	users.add(new UserBean("petar@mail.mail", "password") { { 
			setId(index++);
			setName("Petar");
			setJobTitle("Софтуерен инжинер");
			setInfo("Известен факт е, че читателя обръща внимание на съдържанието, което чете, а не на оформлението му. Свойството на Lorem Ipsum е, че до голяма степен има нормално разпределение на буквите и се чете по-лесно, за разлика от нормален текст на английски език като \"Това е съдържание, това е съдържание\".");
			addJobSkill(new SkillBeen("Java", 30));
			addJobSkill(new SkillBeen("HTML", 50));
			addJobSkill(new SkillBeen("CSS", 70));
			addJobSkill(new SkillBeen("JavaScript", 10));
			addPersonSkill(new SkillBeen("Communicative", 5));
			addPersonSkill(new SkillBeen("Teamwork", 40));
			addPersonSkill(new SkillBeen("Creativity", 25));
			setPhone("09876543219");
			setAddress(new Address("Varna", "Students 1"));
		} });
    }*/
    
    static public Repository getInstance() {
        if (instance == null) {
        	XMLWorker worker = new XMLWorker();
			try {
				instance = worker.readerFromXMLFile(fileName);
				instance.index = instance.users.size() + 1;
			} catch (FileNotFoundException | UnsupportedEncodingException | JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
             //instance = new Repository(fileName);
        return instance;
    }

    public HashSet<UserBean> getUsers() {
		return users;
	}
 
    public void addUser(UserBean user) {
    	user.setId(index++);
    	users.add(user);
    	update();
    }

    public UserBean getById(int id) {
    		UserBean user = null;
    		for (UserBean userBeen : users) {
    			if(id == userBeen.getId())
    			user = userBeen;
    		}
    		return user;
    }

    public boolean hasExist(UserBean user) {
    	return users.contains(user);
    }

	public UserBean getUserByUsername(String username) {
		for (UserBean user : users) {
			if(username.equals(user.getUsername())) {
				return user;
			}
		}
		return null;		
	}

	public void update() {
    	XMLWorker worker = new XMLWorker();
    	try {
			worker.writeToXMLFile(fileName, this);
			
			//worker.write("F:\\DevRepository\\eclipse-workspace\\PIT-IT-2020\\src\\main\\webapp\\storage\\users1.xml", users);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
