package com.snipe.learning.dao;

import java.util.List;

import com.snipe.learning.model.Student;

public interface IStudentDao {
	public int create(int id,String name,Integer age);
	
	public Student getStudent(Integer id);
	
	public List<Student> listStudents();
	
	public Student modify(Student student);
	
	public boolean remove(int id);
	
	public void clear();

}
