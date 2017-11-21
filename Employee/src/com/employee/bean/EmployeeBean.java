package com.employee.bean;

public class EmployeeBean {

	private String name;
	private int salary;
	String doj;
	private String dname;
	
	public EmployeeBean() {
		super();
	}

	public EmployeeBean(String name, int salary,String doj, String dname)
	{
		super();
		this.name = name;
		this.salary = salary;
		this.doj=doj;
		this.dname = dname;
	}

	public String getDoj() {
		return doj;
	}

	/*public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
*/
	public String getName() {
		return name;
	}

	/*public void setName(String name) {
		this.name = name;
	}*/

	public int getSalary() {
		return salary;
	}

	/*public void setSalary(int salary) {
		this.salary = salary;
	}*/

	public String getDname() {
		return dname;
	}

	/*public void setDname(String dname) {
		this.dname = dname;
	}*/
	
	
}
