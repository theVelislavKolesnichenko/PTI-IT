package bg.tu.varna.sit.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import bg.tu.varna.sit.beans.UserBean;
import bg.tu.varna.sit.repositories.Repository;
import bg.tu.varna.sit.repositories.UserList;

public class XMLWorker {
	public void writeToXMLFile(String xmlFile, Repository users) throws JAXBException {

		// Създаване на JAXB контекст
	    JAXBContext context = JAXBContext.newInstance(Repository.class);
	    // Създаване на marshaller инстанция
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    // Записване в System.out
	    //m.marshal(users, System.out);
	    // Записване във файл
	    m.marshal(users, new File(xmlFile));
	}
	
	public Repository readerFromXMLFile(String xmlFile) throws JAXBException, FileNotFoundException, UnsupportedEncodingException {
	    // Създаване на JAXB контекст
	    JAXBContext context = JAXBContext.newInstance(Repository.class);
	    // Създаване на unmarshaller инстанция
	    Unmarshaller um = context.createUnmarshaller();
	    //FileReader reader = new FileReader(xmlFile);
	    
	    InputStream imInputStream = new FileInputStream(xmlFile);
	    Reader reader = new InputStreamReader(imInputStream, "UTF-8");
	    
	    Repository users = (Repository) um.unmarshal(reader);

	    return users;
	}
}
