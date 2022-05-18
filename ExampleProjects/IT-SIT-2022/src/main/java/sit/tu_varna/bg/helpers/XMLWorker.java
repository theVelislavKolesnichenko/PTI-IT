package sit.tu_varna.bg.helpers;

import org.xml.sax.SAXException;
import sit.tu_varna.bg.datasource.Users;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;

public class XMLWorker {
    public void writeToXMLFile(String xmlFile, Users users) throws JAXBException {

        // Създаване на JAXB контекст
        JAXBContext context = JAXBContext.newInstance(Users.class);
        // Създаване на marshaller инстанция
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // Записване в System.out
        //m.marshal(users, System.out);
        // Записване във файл
        marshaller.marshal(users, new File(xmlFile));
    }

    public Users readerFromXMLFile(String xmlFile) throws JAXBException, FileNotFoundException, UnsupportedEncodingException, SAXException {
        // Създаване на JAXB контекст
        JAXBContext context = JAXBContext.newInstance(Users.class);
        // Създаване на unmarshaller инстанция
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //FileReader reader = new FileReader(xmlFile);

        InputStream imInputStream = new FileInputStream(xmlFile);
        Reader reader = new InputStreamReader(imInputStream, "UTF-8");

        //Setup schema validator
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema employeeSchema = sf.newSchema(new File(xmlFile.replace(".xml", ".xsd")));
        unmarshaller.setSchema(employeeSchema);

        Users users = (Users) unmarshaller.unmarshal(reader);

        return users;
    }
}
