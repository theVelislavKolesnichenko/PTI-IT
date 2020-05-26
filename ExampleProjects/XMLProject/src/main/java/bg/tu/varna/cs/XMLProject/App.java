package bg.tu.varna.cs.XMLProject;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

    	double[] arr = new double[5];// { 1, 5, 8, 10, 9};
    	int n = arr.length;
    	for(int i = 0; i < n - 1; i++)
    		for(int j = 0; j < n-i-1; j++) {
    			if(compare(arr[j], arr[j+1])) {
    				double c = arr[j];
    				arr[j] = arr[j+1];
    				arr[j+1] = c;
    			}
    		}
    }
    
    public static boolean compare(Comparable a, Comparable b) {
    	return a.compareTo(b) == -1;
    }
    
    public void xml() {
        	User user = new User(1, "User 1", "User 1");
        	
        	Users users = new Users();
        	
        	users.setUsers(new ArrayList<User>());
        	
        	users.getUsers().add(user);
        	
    		try {
    			JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
    	    	Marshaller marshaller = jaxbContext.createMarshaller();
    			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    			
    			marshaller.marshal(users, System.out);
    			
    			
    		} catch (JAXBException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
}
