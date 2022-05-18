package sit.tu_varna.bg.datasource;

import org.xml.sax.SAXException;
import sit.tu_varna.bg.helpers.XMLWorker;
import sit.tu_varna.bg.models.User;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users implements DataContext {
    @XmlElement(name = "user")
    private ArrayList<User> users;

    private static String fileName;

    public Users() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(
                Objects.requireNonNull(
                        classLoader.getResource("data/users.xml"))
                        .getFile());
        System.out.println(file.getAbsolutePath());
        fileName = file.getAbsolutePath();
    }

    @Override
    public ArrayList<User> getUserBeans() {
        this.setUsers(fileName);
        return users;
    }

    public void update(HashSet<User> users) {
        this.setUsers(users);
        XMLWorker worker = new XMLWorker();
        try {
            worker.writeToXMLFile(fileName, this);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setUsers(HashSet<User> users) {
        this.users = new ArrayList<>(users);
    }

    private void setUsers(String fileName) {
        XMLWorker worker = new XMLWorker();
        try {
            Users users = worker.readerFromXMLFile(fileName);
            if (users != null) {
                this.users = users.users;
            }
        } catch (FileNotFoundException | UnsupportedEncodingException | JAXBException | SAXException e) {
            e.printStackTrace();
        }
    }
}
