package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("=== TEST 1: seller findById =====");
		Department department = departmentDao.findById(3);	
		System.out.println(department);
		
		System.out.println("=== TEST 3: seller findAll =====");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 4: seller insert =====");
		department = new Department(null, "D4 Test");
		departmentDao.insert(department);		
		System.out.println("Inserted! New id = " + department.getId());
		
		System.out.println("=== TEST 5: seller update =====");
		department = departmentDao.findById(3);
		department.setName("D1 Update");
		departmentDao.update(department);	
		System.out.println("Update completed");
		
		System.out.println("=== TEST 6: seller delete =====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);	
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}
