package gr.hua.dit.ds.sitisi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.sitisi.entity.StudentEntity;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<StudentEntity> getStudents(){
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<StudentEntity> query = currentSession.createQuery("from StudentEntity", StudentEntity.class);	
		
		List<StudentEntity> students = query.getResultList();
		return students;
				
	}

	@Override
	@Transactional
	public StudentEntity getStudent(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		StudentEntity student = currentSession.get(StudentEntity.class, id);
		
		return student;
	}

	@Override
	@Transactional
	public void saveStudent(StudentEntity student) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(student);
	}
	

	@Override
	@Transactional
	public void deleteStudent(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		StudentEntity student = currentSession.get(StudentEntity.class, id);
		currentSession.delete(student);
		
	}
	
	

}
