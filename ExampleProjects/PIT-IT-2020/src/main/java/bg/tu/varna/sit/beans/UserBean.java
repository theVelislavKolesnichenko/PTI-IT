package bg.tu.varna.sit.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserBean {
	private int id;
	//Login data
	private String username;
	private String password;
	
	//Profile data
	private String name;
	private String jobTitle;
	private String info;	
	
	//Skills
	@XmlElementWrapper(name = "jobsSkills")
    @XmlElement(name = "skillBean")
	private ArrayList<SkillBeen> jobsSkills;
	@XmlElementWrapper(name = "personSkills")
    @XmlElement(name = "skillBean")
	private ArrayList<SkillBeen> personSkills;
	
	//Contacts data
	private String phone;
	private Address address;
	
	public UserBean() {
		this(null, null);
	}
	
	public UserBean(String username, String password) {
		this.username = username;
		this.password = password;
		this.jobsSkills = new ArrayList<SkillBeen>();
		this.personSkills = new ArrayList<SkillBeen>();
		this.address = new Address();
		Locale.setDefault(new Locale("bg", "BG"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void addJobSkill(SkillBeen skillBeen) {
		jobsSkills.add(skillBeen);
	}
	
	public void addPersonSkill(SkillBeen skillBeen) {
		personSkills.add(skillBeen);
	}

	public ArrayList<SkillBeen> getJobsSkills() {
		return jobsSkills;
	}

	public ArrayList<SkillBeen> getPersonSkills() {
		return personSkills;
	}

	public void setJobsSkills(ArrayList<SkillBeen> jobsSkills) {
		this.jobsSkills = jobsSkills;
	}

	public void setPersonSkills(ArrayList<SkillBeen> personSkills) {
		this.personSkills = personSkills;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserBean updateUserInfo(UserBean user) {
		
		this.setName(user.getName());
		this.setJobTitle(user.getJobTitle());
		this.setInfo(user.getInfo());
		
		return this;
	}

	public UserBean updateUserSkill(Map<String, String> newUser) {
		
		Map<String, String> mapJobsSkills = new HashMap<String, String>();
		Map<String, String> mapJPersonSkills = new HashMap<String, String>();
		
		for(Map.Entry<String, String> entry : newUser.entrySet()) {
			if(entry.getKey().contains("jobSkill")) {
				mapJobsSkills.put(entry.getKey(), entry.getValue());
			} else {
				mapJPersonSkills.put(entry.getKey(), entry.getValue());
			}
		}
		
		ArrayList<SkillBeen> jobsSkills = new ArrayList<SkillBeen>();
		ArrayList<SkillBeen> personSkills = new ArrayList<SkillBeen>();
		
		for(int i = 0; i < mapJobsSkills.size() / 2; i++) {
			SkillBeen skillBeen = new SkillBeen(
					mapJobsSkills.get("jobSkill"+i), 
					Integer.parseInt(mapJobsSkills.get("jobSkillValue"+i)));
			
			jobsSkills.add(skillBeen);
		}
		
		for(int i = 0; i < mapJPersonSkills.size() / 2; i++) {
			SkillBeen skillBeen = new SkillBeen(
					mapJPersonSkills.get("personSkill"+i), 
					Integer.parseInt(mapJPersonSkills.get("personSkillValue"+i)));
			
			personSkills.add(skillBeen);
		}
		
		this.setJobsSkills(jobsSkills);
		this.setPersonSkills(personSkills);
		
		return this;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(this instanceof UserBean))
			return false;
		UserBean other = (UserBean) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
