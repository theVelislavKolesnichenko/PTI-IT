package bg.tu_varna.sit.vegetables_webapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vegetable")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vegetable {
	
	private String name;
	private int count;
	private double price;
	
	public Vegetable() {
		this("", 0, 0);
	}
	
	public Vegetable(String name, int count, double price) {
		this.name = name;
		this.count = count;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public void get(int count) {
		if(this.count > count) {
			this.count -= count;
		} else {
			this.count = 0;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		Vegetable veg = (Vegetable) obj;
		return this.name.equals(veg.name);
	}
}
