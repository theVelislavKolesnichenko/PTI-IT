package helpers;

import datasource.TaskRepository;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLWorker {
    public static void write(String xmlFile, TaskRepository taskRepository) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TaskRepository.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(taskRepository, new File(xmlFile));
    }

    public static TaskRepository read(String xmlFile) throws JAXBException, FileNotFoundException, UnsupportedEncodingException {
        JAXBContext context = JAXBContext.newInstance(TaskRepository.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        InputStream imInputStream = new FileInputStream(xmlFile);
        Reader reader = new InputStreamReader(imInputStream, "UTF-8");

        TaskRepository taskRepository = (TaskRepository) unmarshaller.unmarshal(reader);

        return taskRepository;
    }
}
