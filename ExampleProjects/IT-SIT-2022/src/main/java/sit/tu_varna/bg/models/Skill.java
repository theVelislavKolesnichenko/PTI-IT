package sit.tu_varna.bg.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "skill")
@XmlAccessorType(XmlAccessType.FIELD)
public class Skill implements Comparable<Skill> {
    private String name;
    private short value;

    public Skill() {
    }

    public Skill(String name, short value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public short getValue() {
        return value;
    }

    @Override
    public int compareTo(Skill o) {
        return this.getName().compareTo(o.getName());
    }
}
