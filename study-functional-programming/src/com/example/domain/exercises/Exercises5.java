package com.example.domain.exercises;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import com.example.domain.Department;
import com.example.domain.Employee;

public class Exercises5 {
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
	   //her bir depertmana ne kadar maas veriyoruz
	   
//		[(jack,IT), (jack,FINANCE), (jack,HR)]   Stream<List<Pair>>
//		[(kate,HR), (kate,IT)]
//		[(james, SALES), (james, FINANCE)]
//     [(jin,IT)]		

//     (jack,IT)                                Stream<Pair> 
//     (jack,FINANCE)
//     (jack,HR)
//     (kate,HR)
//     (kate,IT)
//     (james,SALES)
//     (james,FINANCE)
//     (jin,IT)
	   
	   var groupByDepartmenGetTotalSalary =
			   employees.stream()
			   .map(employee-> employee.getDepartments().stream().map(dept->new DepartmentSalaryPair( dept,employee.getSalary())).toList())
	            .flatMap(List::stream)
	            .collect(Collectors.groupingBy(DepartmentSalaryPair::department,Collectors.summarizingDouble(DepartmentSalaryPair::salary)));
			   groupByDepartmenGetTotalSalary.forEach((dept,total)->System.err.println(dept+": " +total));
	            
	  
   }

}

record DepartmentSalaryPair(Department department ,double salary ) {
	
}
