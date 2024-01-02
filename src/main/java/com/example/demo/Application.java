package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt  = 
				SpringApplication.run(Application.class, args);
		
		EmployeeService bean = ctxt.getBean(EmployeeService.class);
		
		//bean.UpSert();
		
		//bean.SaveMultiple();
		
		//bean.FindByPrimaryKey();
		
		//bean.FindMultipleEmpsById();
		
		//bean.GetAllEmps();
		
		//bean.IsExistById();
		
		//bean.CountEmployees();
		
		//bean.DeleteByEmpId();
		
		//bean.DeleteAllByEmpIDs();
		
		//bean.FindEmpByName("Vivek");
		
		//bean.FindByDepartmentAndGender();
		
		//bean.getEmpSalaryGraterThan();
		
		//bean.FindEmpByName("Vivek");
		
		//bean.GetAllEmpls();
		
		//bean.GetByGenderAndDept();
		
		//bean.GetByEmpName();
		
		//bean.DeleteByEmpId();
		
		//bean.GetAllNamesAndDepts();
		
		//bean.UpdateSalById();
		
		//bean.UpdateDeptByName();
		
		//bean.SortEmpsBySalary();
		
		//bean.FindAllByPagination(3, 2);
		
		//bean.GetEmpByQBE();
		
		//bean.ProcedureCall();
		
		//bean.InsertRecord();
		
	}

}
