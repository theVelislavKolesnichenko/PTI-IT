package sit.tu_varna.bg.models;

import java.util.Objects;

public class User {
    private String name;
    private String jobTitle;
    private String info;
    private Login login;
    private Contact contact;
    private Skills skills;

    public User(String name,
                String jobTitle,
                String info,
                Login login,
                Contact contact,
                Skills skills) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.info = info;
        this.login = login;
        this.contact = contact;
        this.skills = skills;
    }

    public User(String name, Login login) {
        this(name, null, null, login, null, null);
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
}
