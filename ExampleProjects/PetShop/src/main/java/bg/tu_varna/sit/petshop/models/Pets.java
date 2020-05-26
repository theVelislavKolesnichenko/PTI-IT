package bg.tu_varna.sit.petshop.models;

import java.util.Collection;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pets")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pets {
	
	@XmlElement(name = "pet")
	private static HashSet<Pet> pets = new HashSet<Pet>();
	
	public Pets() {
		// TODO Auto-generated constructor stub
	}

	public void add(Pet pet) {
		pets.add(pet);
	}
	
	public void add(Collection<Pet> pets) {
		this.pets.addAll(pets);
	}
	
	public HashSet<Pet> getPets() {
		return pets;
	}
	
	public Pet get(String name) {
		Pet result = null;
		
		for (Pet pet : pets) {
			if(pet.equals(new Pet(name))) {
				result = pet;
				break;
			}
		}
		
		return result;
	}

	public int getPet(Pet pet) {
		Pet pet1 = get(pet.getName());
		int count = 0;
		
		if(pet1.compareTo(pet) > -1) {	
			pet1.get(pet.getCount());
			count = pet1.getCount();
		} else {
			pet1.setCount(count);
		}
		
		return count;
	}
		
}
