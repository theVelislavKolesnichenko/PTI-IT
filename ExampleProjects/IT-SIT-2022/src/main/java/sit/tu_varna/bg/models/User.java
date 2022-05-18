package sit.tu_varna.bg.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;
import java.util.Objects;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    //Task 1
    private String name;
    private Login login;

    private String imageName;
    private String jobTitle;
    private String info;

    private Skills skills;

    private Contact contact;

    public User() {

    }

    public User(String name,
                String jobTitle,
                String info,
                String imageName,
                Login login,
                Contact contact,
                Skills skills) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.info = info;
        this.login = login;
        this.imageName = imageName;
        this.contact = contact;
        this.skills = skills;
    }

    public User(String name, Login login) {
        this(name,
                "",
                "",
                "male.svg",
                login,
                new Contact("", "", new Address("", "")),
                new Skills());
    }

    public User(Login login) {
        this("", login);
    }

    public Skills getSkills() {
        return skills;
    }

    public Contact getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public Login getLogin() {
        return login;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        Login objLogin = user.getLogin();
        if (login == objLogin) return true;
        if (objLogin == null || login.getClass() != objLogin.getClass()) return false;
        return Objects.equals(login.getUsername(), user.login.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    public boolean update(User newUser) {
        this.setName(newUser.getName());
        this.setJobTitle(newUser.getJobTitle());
        this.setInfo(newUser.getInfo());
        return true;
    }

    public boolean update(Map<String, Short> skills) {
        return this.skills.update(skills);
    }
}
