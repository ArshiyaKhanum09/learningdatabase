package com.snipe.learning.service;

import java.util.List;

import com.snipe.learning.dao.IStudentDao;
import com.snipe.learning.dao.StudentDaoImpl;
import com.snipe.learning.model.Student;

public class StudentJDBCServiceImpl implements IStudentJDBCService{
	IStudentDao studentDao = new StudentDaoImpl();

	@Override
	public void create(int id,String name, Integer age) {
		studentDao.create(id,name, age);
	}

	@Override
	public boolean remove(int id) {
		return studentDao.remove(id);
	}

	@Override
	public Student modify(Student student) {
		return studentDao.modify(student);
	}

	@Override
	public Student getStudent(Integer id) {
		return studentDao.getStudent(id);
	}

	@Override
	public List<Student> listStudents() {
		return studentDao.listStudents();
	}

	public void clear() {
		studentDao.clear();
	}


}