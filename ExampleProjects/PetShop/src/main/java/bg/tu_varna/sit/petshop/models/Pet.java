package bg.tu_varna.sit.petshop.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pet")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pet implements Comparable<Pet> {
	private String name;
	private String type;
	private int count;
	
	public Pet() {
		this("", "", 0);
	}
	
	public Pet(String name) {
		this(name, "", 0);
	}
	
	public Pet(String name, String type, int count) {
		this.name = name;
		this.type = type;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void get(int count) {
		this.count -= count;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Pet o) {
		return new Integer(count).compareTo(new Integer(o.count));
	}
	
}
