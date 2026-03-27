package tree;


/**
 * The entity we're storing in our node
 */


public class Employee implements Comparable<Employee> {
	
	private String name;
	private Integer id;
	private String position;
	
	public Employee(String name, Integer id, String position) {
		this.name = name;
		this.id = id;
		this.position = position;
	}
 	
	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public String getPosition() {
		return position;
	}


	

	public boolean equals(Employee e) {
		if (this.name.equals(e.name) && this.id == e.id && this.position.equals(e.position))
			return true;
		return false;
	}

	public String toString() {
		return name + " " + id + " " + position;
	}
	
	//
	public int compareTo(Employee o) {
		
		return (this.id).compareTo(o.id);
	 
	}
}
