package sit.tu_varna.bg.models;

public class Skill implements Comparable<Skill> {
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

    @Override
    public int compareTo(Skill o) {
        return this.getName().compareTo(o.getName());
    }
}
