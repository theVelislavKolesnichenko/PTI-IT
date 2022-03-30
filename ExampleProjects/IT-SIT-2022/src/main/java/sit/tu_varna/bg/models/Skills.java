package sit.tu_varna.bg.models;

import java.util.Set;
import java.util.TreeSet;

public class Skills {
    private Set<Skill> jobSkills;
    private Set<Skill> personSkills;

    public Skills() {
        jobSkills = new TreeSet<Skill>() {{
            add(new Skill("Java", (short) 0));
            add(new Skill("HTML", (short) 0));
            add(new Skill("CSS", (short) 0));
            add(new Skill("JavaScript", (short) 0));
        }};
        personSkills = new TreeSet<Skill>() {{
            add(new Skill("Комуникативност", (short) 0));
            add(new Skill("Работа в екип", (short) 0));
            add(new Skill("Креативност", (short) 0));
        }};
    }

    public void updateJobSkills(String name, short value) {
        jobSkills.add(new Skill(name, value));
    }

    public void updatePersonSkills(String name, short value) {
        personSkills.add(new Skill(name, value));
    }

    public Set<Skill> getJobSkills() {
        return jobSkills;
    }

    public Set<Skill> getPersonSkills() {
        return personSkills;
    }
}
