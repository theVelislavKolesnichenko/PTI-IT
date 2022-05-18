package sit.tu_varna.bg.models;

import javax.xml.bind.annotation.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@XmlRootElement(name = "skills")
@XmlAccessorType(XmlAccessType.FIELD)
public class Skills {
    @XmlElementWrapper(name = "jobsSkills")
    @XmlElement(name = "skill")
    private Set<Skill> jobSkills;
    @XmlElementWrapper(name = "personSkills")
    @XmlElement(name = "skill")
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
        Skill skill = new Skill(name, value);
        if (jobSkills.contains(skill)) {
            jobSkills.remove(skill);
            jobSkills.add(skill);
        }
    }

    public void updatePersonSkills(String name, short value) {
        Skill skill = new Skill(name, value);
        if (personSkills.contains(skill)) {
            personSkills.remove(skill);
            personSkills.add(skill);
        }
    }

    public Set<Skill> getJobSkills() {
        return jobSkills;
    }

    public Set<Skill> getPersonSkills() {
        return personSkills;
    }

    public boolean update(Map<String, Short> skills) {
        for (Map.Entry<String, Short> entry : skills.entrySet()) {
            updateJobSkills(entry.getKey(), entry.getValue());
            updatePersonSkills(entry.getKey(), entry.getValue());
        }
        return true;
    }
}
