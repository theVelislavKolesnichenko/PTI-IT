package sit.tu_varna.bg.models;

public class Skill {
    private String name;
    private short value;

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
}
