package bg.tu.varna.cs.JAXBProject;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User user = new User(1, "User 1", "User 1");
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user);
        userList.add(new User(2, "User 2", "User 2"));
        
        Users users = new Users(userList);
        
		try {
			JAXBContext context = JAXBContext.newInstance(Users.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			marshaller.marshal(users, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
    }
}
