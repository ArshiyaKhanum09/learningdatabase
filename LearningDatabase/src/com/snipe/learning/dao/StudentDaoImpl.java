package com.snipe.learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.snipe.learning.model.Student;

public class StudentDaoImpl implements IStudentDao{

	DBjdbccon conn = new DBjdbccon();
	public int create(int id, String name, Integer age) {
		String SQL_INSERT = "insert into std (id, name, age) values (?, ?, ?)";
		Connection con = conn.getCon();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);

			int row = preparedStatement.executeUpdate();

			System.out.println("Created Record Name = " + name + " Age = " + age);
			return row;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
		return 0;
	}

	public boolean remove(int id) {
		String SQL_REMOVE = "delete from std where id=?";
		try {
			Connection con = conn.getCon();
			Statement stmt = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(SQL_REMOVE);

			preparedStatement.setInt(1, id);

			int row = preparedStatement.executeUpdate();
			if(row!=0)
				return true;
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return false;
	}

	public Student modify(Student student) {
		String SQL_UPDATE = "update  std set name=?, age=? where id=?";
		try {
			Connection con = conn.getCon();
			Statement stmt = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(SQL_UPDATE);

			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setInt(3, student.getId());

			int row = preparedStatement.executeUpdate();
			if(row!=0)
			return student;
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return student;
	}

	public Student getStudent(Integer id) {
		Student student = new Student();
		String SQL_SELECT = "select * from std";
		try {
			Connection con = conn.getCon();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT);
			while (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				con.close();
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return student;
	}

	public List<Student> listStudents() {
		Connection con = null;
		List<Student> studentList = new ArrayList<Student>();
		String SQL_SELECT = "select * from std";
		try {
			con = conn.getCon();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT);
			while (rs.next()) {
				Student student =new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				studentList.add(student);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
				
		return studentList;
	}
	
	public void clear() {
		String SQL_DELETE = "delete from std";
		try {
			Connection con = conn.getCon();
			Statement stmt = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(SQL_DELETE);
			int row = preparedStatement.executeUpdate();
			if(row!=0) {
				System.out.println("successfully deleted");
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}


}