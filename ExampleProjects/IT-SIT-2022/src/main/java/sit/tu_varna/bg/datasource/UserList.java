package sit.tu_varna.bg.datasource;

import sit.tu_varna.bg.models.*;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    //    public User(String name,
    //                String jobTitle,
    //                String info,
    //                Login login,
    //                Contact contact,
    //                Skills skills)
    public ArrayList<User> getUserBeans() {

        final Skills skills = new Skills();
        skills.updateJobSkills("Java", (short) 10);
        skills.updateJobSkills("HTML", (short) 20);
        skills.updateJobSkills("CSS", (short) 30);
        skills.updateJobSkills("JavaScript", (short) 40);

        skills.updatePersonSkills("Комуникативност", (short) 50);
        skills.updatePersonSkills("Работа в екип", (short) 60);
        skills.updatePersonSkills("Креативност", (short) 70);

        return new ArrayList<User>() {{
            add(new User(
                    "Име Именно",
                    "Студент",
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
                    "male.svg",
                    new Login("user1", "pass"),
                    new Contact("email@email.com", "089874562,",
                            new Address("Варна", "ул. Студентска 1")),
                    skills));
        }};
    }
}
