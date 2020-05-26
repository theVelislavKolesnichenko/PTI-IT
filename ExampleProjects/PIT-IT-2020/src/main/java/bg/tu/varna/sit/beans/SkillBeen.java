package bg.tu.varna.sit.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "skillBean")
@XmlAccessorType(XmlAccessType.FIELD)
public class SkillBeen {
	private String name;
	private int value;
	
	public SkillBeen() {
		this("Умение", 0);
	}
	
	public SkillBeen(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}	
