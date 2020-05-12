package bg.tu_varna.sit.web_app.modes;

import java.util.Collection;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fruits")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fruits {
	
	@XmlElement(name = "fruit")
	private static HashSet<Fruit> fruits = new HashSet<Fruit>();

	public Fruits() {
		
	}
	
	public void add(Fruit fruit) {
		fruits.add(fruit);
	}
	
	public void add(Collection<Fruit> fruits) {
		fruits.addAll(fruits);
	}
	
	public Fruit get(String name) {
		Fruit fruit = null;
		for (Fruit item : fruits) {
			if(item.equals(new Fruit(name))) {
				fruit = item;
			}
		}
		return fruit;
	}	
	
	public HashSet<Fruit> getAll() {
		return fruits;
	}
	
	public int extraction(Fruit fruit) {
		Fruit fruit2 = get(fruit.getName());
		int count = 0;
		if(fruit2.getCount() > count) {
			fruit2.extraction(fruit.getCount());
			count = fruit2.getCount();
		}
		else {
			fruit2.setCount(count);
		}
		
		return count;
	}
}
