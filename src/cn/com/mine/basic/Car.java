package cn.com.mine.basic;

public class Car {
	private String id;
	private String name;

	public Car(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			Car hcc = (Car) obj;
			if (hcc.id.equals(this.id) && hcc.name.equals(this.name)) {
				return true;
			}
			return false;
		}
		return false;

	}
	public int hashCode() {
		System.out.println(this.id.hashCode());
		System.out.println(this.name.hashCode());
		return this.id.hashCode()+this.name.hashCode();
	}

}
