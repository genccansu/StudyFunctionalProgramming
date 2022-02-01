package com.example.domain.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

import com.example.domain.Department;
import com.example.domain.Employee;

public class Exercises {
	public static List<Employee> employees;
	
	static {
		employees = new ArrayList<>();
		var jack = new Employee("1", "jack bauer", 100_000, "tr1", true, 1956);
		jack.addDepartments(Department.HR,Department.FINANCE,Department.IT);
		var kate = new Employee("2", "kate austen", 200_000, "tr2", false, 1986);
		kate.addDepartments(Department.HR,Department.IT);
		var james = new Employee("3", "james sawyer", 150_000, "tr3", true, 1978);
		james.addDepartments(Department.SALES,Department.FINANCE);
		var jin = new Employee("4", "jin kwon", 250_000, "tr4", false, 1987);
		jin.addDepartments(Department.IT);
		employees.add(jack);
		employees.add(kate);
		employees.add(james);
		employees.add(jin);
	}
	
   public static void main(String[] args) {
	   //parttime calısanlar icerisinde en yuksek maas ne kadar 
	   
	   
	   Predicate<Employee> ifFullTime = employee-> employee.isFulltime();
	   Predicate<Employee> ifPartTime = ifFullTime.negate();
	   ToDoubleFunction<Employee> toSalary = employee->employee.getSalary();
	   
	   var maxSalaryToPartTimeEmployees=
	   employees.stream() //stream<employee>,intermadiate functions
	   .filter(ifPartTime) //stream<employe>,intermadiate functions
      .mapToDouble(toSalary) //stream<double>,intermadiate functions
        .max().getAsDouble();  //terminal functional.. terminal functionla bitirmek zorundayım.
	   
	   System.err.println(maxSalaryToPartTimeEmployees);
   }

}
