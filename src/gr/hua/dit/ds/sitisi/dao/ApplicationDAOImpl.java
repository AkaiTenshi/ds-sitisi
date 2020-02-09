package gr.hua.dit.ds.sitisi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.sitisi.entity.ApplicationEntity;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<ApplicationEntity> getApplications() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ApplicationEntity> query = currentSession.createQuery("from ApplicationEntity", ApplicationEntity.class);
		List<ApplicationEntity> applications = query.getResultList();
		return applications;
	}

	@Override
	@Transactional
	public ApplicationEntity getApplication(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		ApplicationEntity application = currentSession.get(ApplicationEntity.class, id);
		return application;
	}

	@Override
	@Transactional
	public void saveApplication(ApplicationEntity application) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(application);
		
	}

	@Override
	@Transactional
	public void deleteApplication(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		ApplicationEntity application = currentSession.get(ApplicationEntity.class, id);
		currentSession.delete(application);
		
	}

}
