package bg.tu_varna.sit.vegetables_webapp;

import java.util.HashSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vegetables")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vegetables {

	@XmlElement(name = "vegetable")
	private HashSet<Vegetable> vegetables;
	
	public Vegetables() {
		this.vegetables = new HashSet<Vegetable>();
	}
	
	public HashSet<Vegetable> getVegetables() {
		return vegetables;
	}
	
	public void setVegetables(HashSet<Vegetable> vegetables) {
		this.vegetables = vegetables;
	}
	
	public void add(Vegetable vegetable) {
		vegetables.add(vegetable);
	}

	public int getVegetable(Vegetable vegetable) {
		for (Vegetable veg : vegetables) {
			if(veg.equals(vegetable)) {
				veg.get(vegetable.getCount());
				return veg.getCount();
			}
		}
		return 0;
	}
	
}
