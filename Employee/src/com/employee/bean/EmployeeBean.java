package com.employee.bean;

public class EmployeeBean {

	private int empId;
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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", name=" + name + ", salary="
				+ salary + ", doj=" + doj + ", dname=" + dname + "]";
	}
	
}
