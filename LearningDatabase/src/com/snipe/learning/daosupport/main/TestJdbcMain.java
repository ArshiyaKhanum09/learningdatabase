package com.snipe.learning.daosupport.main;

import com.snipe.learning.model.Student;
import com.snipe.learning.service.IStudentJDBCService;
import com.snipe.learning.service.StudentJDBCServiceImpl;

public class TestJdbcMain {
	
	public static void main(String args[]) {
		IStudentJDBCService service = new StudentJDBCServiceImpl();
		//create a records
		service.create(1,"Arshiya", 23);
		service.create(2,"Vinay", 24);
		service.create(3,"David", 25);
		
		//load all students details
		System.out.println("saved details are");
		for(Student student: service.listStudents()) {
			System.out.println(student.getId()+"::"+student.getName()+"::"+student.getAge());
		}
		
		//update 
	Student student = service.getStudent(3);
		student.setName("Mahesh");
		service.modify(student);
		
		student = service.getStudent(1);
		System.out.println("Modified record");
		System.out.println(student.getId() + "::"+student.getName() + "::"+student.getAge() );
		
		//remove all
//	    service.clear();
	}

}

