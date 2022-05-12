package com.snipe.learning.service;

import java.util.List;

import com.snipe.learning.model.Student;

public interface IStudentJDBCService {
	public void create(int id,String name, Integer age);

	public boolean remove(int id);

	public Student modify(Student student);

	public Student getStudent(Integer id);

	public List<Student> listStudents();

	public void clear();

}