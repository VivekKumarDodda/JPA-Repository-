package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;



@Service
public class EmployeeService {
	
	private EmployeeRepo EmpRepo;

	public EmployeeService(EmployeeRepo empRepo) {
		this.EmpRepo = empRepo;
	}
	
	public void UpSert() {
		Employee emp = new Employee();
		emp.setId(205);
		emp.setName("Avinash");
		emp.setDept("Support");
		emp.setGender("Male");
		emp.setSalary(30000);
		
		EmpRepo.save(emp);
	}
	
	public void SaveMultiple() {
		
		Employee emp1 = new Employee();
		emp1.setId(202);
		emp1.setName("Umesh");
		emp1.setDept("Java");
		emp1.setGender("Male");
		emp1.setSalary(30000);
		
		Employee emp2 = new Employee();
		emp2.setId(203);
		emp2.setName("Pooja");
		emp2.setDept("Java");
		emp2.setGender("Female");
		emp2.setSalary(25000);
		
		List<Employee> asList = Arrays.asList(emp1,emp2);
		
		EmpRepo.saveAll(asList);
	}
	
	public void FindByPrimaryKey() {
		
		Optional<Employee> findById = EmpRepo.findById(202);
		if(findById.isPresent()) {
			Employee employee = findById.get();
			System.out.println(employee);
		}
		
	}
	
	public void FindMultipleEmpsById() {
		
		List<Integer> asList = Arrays.asList(201,202);
		Iterable<Employee> findAllById = EmpRepo.findAllById(asList);
		findAllById.forEach(System.out::println);
		
	}
	
	public void GetAllEmps() {
		
		Iterable<Employee> findAll = EmpRepo.findAll();
		findAll.forEach(System.out::println);
	}
	
	public void IsExistById() {
		boolean existsById = EmpRepo.existsById(201);
		if(existsById)
			System.out.println("Employee present");
		else
			System.out.println("Employee absent..");
	}
	
	public void CountEmployees() {
		long count = EmpRepo.count();
		System.out.println(count);
	}
	
	public void DeleteByEmpId() {
		 EmpRepo.deleteById(201);
		
	}
	
//	public void DeleteAllByEmpIDs() {
//		List<Integer> asList = Arrays.asList(202,203);
//		EmpRepo.deleteAllById(asList);
//		
//	}
	
	public void FindEmpByName(String name) {
		List<Employee> findByName = EmpRepo.findByName(name);
		findByName.forEach(System.out::println);
	}
	
	public void FindByDepartmentAndGender() {
		List<Employee> list = EmpRepo.findByDeptAndGender("Java","Male");
		list.forEach(System.out::println);
		
	}
	public void getEmpSalaryGraterThan() {
		List<Employee> list = EmpRepo.findBySalaryGreaterThanEqual(30000);
		
		list.forEach(System.out::println);
		
	}
	
	public void GetAllEmpls () { 
		List<Employee> list = EmpRepo.getAllEmployees();
		list.forEach(System.out::println);
	}
	
	public void GetByGenderAndDept () {
		List<Employee> list = EmpRepo.GetByDeptAndGender("Java", "Male");
		list.forEach(System.out::println);
	}
	
	public void GetByEmpName() {
		List<Employee> getByName = EmpRepo.GetByName("Umesh");
		getByName.forEach(System.out::println);
	}
	
	public void DeleteEmpById() {
		List<Employee> list = EmpRepo.DeleteById(201);
		list.forEach(System.out::println);
	}
	
	public void UpdateSalById() {
		EmpRepo.UpdateById(40000,204);
		
	}
	
	public void UpdateDeptByName() {
		
		EmpRepo.UpdateByName("Java","Vivek");
	}
	
	public void GetAllNamesAndDepts() {
		    List<EmployeeProjection> list = EmpRepo.GetNameAndDept();
		    list.forEach(System.out::println);
		    //System.out.println(list.toString());
	}
	
	//***************************JPA REPO Methods ******************************************//
	
	public void SortEmpsBySalary() {
		Sort sort = Sort.by("salary").descending();
		List<Employee> list = EmpRepo.findAll(sort);
		list.forEach(System.out::println);
		
	}
	
	public void FindAllByPagination(int PageNo, int PageSize) {
		PageRequest of = PageRequest.of(PageNo-1, PageSize);
		Page<Employee> findAll = EmpRepo.findAll(of);
		findAll.forEach(System.out::println);
		}
	
	public void GetEmpByQBE() {
		
		Employee emp = new Employee();
		//Hear we are going ton write if condition if user select department then perform below logic..
		//emp.setDept("Java");
		emp.setGender("Male");	
		Example<Employee> of = Example.of(emp);
		List<Employee> findAll = EmpRepo.findAll(of);
		findAll.forEach(e -> System.out.println(e));
	}
	@Transactional
	public void ProcedureCall() {
		List<Employee> call = EmpRepo.ProcedureCall(201);
		call.forEach(System.out::println);
		
	}
	
	public void InsertRecord() {
		
		EmpRepo.InsertEmployee(208, "Vinodh", "Support","Male",2000);
		
	}
}
