package com.example.demo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;


public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
	//****************************Curd Repo Methods************************************//
	
	//FindBy custom methods // 
	
	public List<Employee> findByName(String name);

	public List<Employee> findByDeptAndGender(String Dept, String gender );
	
	public List<Employee> findBySalaryGreaterThanEqual(int salary);
	

	
	// HQL Custom queries //
	@Query("from Employee")
	public List<Employee> getAllEmployees();
	
	@Query("from Employee where dept= :dept and gender= :gen")
	public List<Employee> GetByDeptAndGender(String dept, String gen);
	
	//HQL Projection query//
	@Query("Select name,dept from Employee")
	public List<EmployeeProjection> GetNameAndDept();
	
	//HQL Modifying queries //
	@Transactional
	@Modifying 
	@Query("delete from Employee where Id=:Id")
	public List<Employee> DeleteById(int Id);
	
	@Transactional
	@Modifying
	@Query("Update Employee set salary = :salary where Id =:Id")
	public void UpdateById(int salary, int Id);
	
	@Transactional
	@Modifying
	@Query("Update Employee set dept =:dept where name =:name")
	public void UpdateByName(String dept, String name);
	
	@Transactional
	@Modifying
	@Query("Insert into Employee(Id,name,dept,gender,salary) Values(:id,:name,:dept,:gen,:sal)")
	public void InsertEmployee(int id, String name, String dept, String gen, int sal);
	
	
	//SQL Cutom Query //
	@Query(value = "Select * from employee where name = :name", nativeQuery = true)
	public List<Employee> GetByName(String name);
	
	//Calling Procedures//
	
	@Procedure(value = "Find_EmployeeById")
	public List<Employee> ProcedureCall(int id);
	
	

	
}
