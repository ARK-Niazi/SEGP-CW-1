

public class Pat{
	String name;
	String dep;
	String email;
	String load;
	public Pat(String name, String dep, String email, String load) {
		super();
		this.name = name;
		this.dep = dep;
		this.email = email;
		this.load = load;
	}
	public Pat(){
		name=null;
		dep=null;
		email=null;
		load=null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoad() {
		return load;
	}
	public void setLoad(String load) {
		this.load = load;
	}
	
}
