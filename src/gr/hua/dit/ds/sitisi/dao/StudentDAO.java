package gr.hua.dit.ds.sitisi.dao;

import java.util.List;

import gr.hua.dit.ds.sitisi.entity.StudentEntity;

public interface StudentDAO {
	public List<StudentEntity> getStudents();
	public StudentEntity getStudent(String id);
	public void saveStudent(StudentEntity student);
	public void deleteStudent(String id);

}
