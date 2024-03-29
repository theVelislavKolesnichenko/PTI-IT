package sit.tu_varna.bg.datasource;

import sit.tu_varna.bg.models.*;

import java.util.ArrayList;
import java.util.HashSet;

public class UserList implements DataContext {
    private ArrayList<User> users;

    public ArrayList<User> getUserBeans() {
        init();
        return this.users;
    }

    @Override
    public void update(HashSet<User> users) {
        this.users = new ArrayList<>(users);
    }

    private void init() {
        if (users == null) {
            final Skills skills = new Skills();
            skills.updateJobSkills("Java", (short) 10);
            skills.updateJobSkills("HTML", (short) 20);
            skills.updateJobSkills("CSS", (short) 30);
            skills.updateJobSkills("JavaScript", (short) 40);

            skills.updatePersonSkills("Комуникативност", (short) 50);
            skills.updatePersonSkills("Работа в екип", (short) 60);
            skills.updatePersonSkills("Креативност", (short) 70);

            this.users = new ArrayList<User>() {{
                add(new User(
                        "Име Именно",
                        "Студент",
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
                        "male.svg",
                        new Login("user1", "pass"),
                        new Contact("email@email.com", "089874562,",
                                new Address("Варна", "ул. Студентска 1")),
                        skills));
                add(new User(
                        "Име Именно 2",
                        "Студент",
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
                        "male.svg",
                        new Login("user2", "pass"),
                        new Contact("email2@email.com", "089874562,",
                                new Address("Варна", "ул. Студентска 1")),
                        skills));
                add(new User(
                        "Име Именно 3",
                        "Студент",
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
                        "male.svg",
                        new Login("user3", "pass"),
                        new Contact("email3@email.com", "089874562,",
                                new Address("Варна", "ул. Студентска 1")),
                        skills));
                add(new User(
                        "Име Именно 4",
                        "Студент",
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
                        "male.svg",
                        new Login("user4", "pass"),
                        new Contact("email3@email.com", "089874562,",
                                new Address("Варна", "ул. Студентска 1")),
                        skills));
            }};
        }
    }
}
