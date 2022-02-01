package com.example.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Employee {
	private String identity;
	private String fullname;
	private double salary;
	private String iban;
	private boolean fulltime;
	private int birthYear;
	private Set<Department> departments = new HashSet<>();
	
	
	public Employee() {
		
	}
	
	public Employee(String identity, String fullname, double salary, String iban, boolean fulltime, int birthYear)
			 {
		
		this.identity = identity;
		this.fullname = fullname;
		this.salary = salary;
		this.iban = iban;
		this.fulltime = fulltime;
		this.birthYear = birthYear;
		
	}



	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public boolean isFulltime() {
		return fulltime;
	}
	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public Set<Department> getDepartments() {
		return departments;
	}
	
	public void removeDepartment(Department department) {
		departments.remove(department);
	}

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(identity, other.identity);
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Employee [identity=" + identity + ", fullname=" + fullname + ", salary=" + salary + ", iban=" + iban
				+ ", fulltime=" + fulltime + ", birthYear=" + birthYear + ", departments="
				+ (departments != null ? toString(departments, maxLen) : null) + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

	public void addDepartments(Department...departments ) {
		this.departments.addAll(Arrays.asList(departments));
	}

	
	
	
}
