package datasource;

import helpers.XMLWorker;
import models.Task;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskRepository {
    @XmlElement(name = "task")
    private Set<Task> tasks;
    private static TaskRepository instance;
    private String filename;

    private TaskRepository() {
        File file = new File(
                Objects.requireNonNull(
                                getClass().getClassLoader().getResource("tasks.xml"))
                        .getFile());
        filename = file.getAbsolutePath();
        this.tasks = new HashSet<>();
    }

    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
            try {
                instance = XMLWorker.read(instance.filename);
            } catch (JAXBException | FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void add(Task task) {
        tasks.add(task);
        try {
            XMLWorker.write(filename, this);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Set<Task> getTasks() {
        return tasks;
    }
}
