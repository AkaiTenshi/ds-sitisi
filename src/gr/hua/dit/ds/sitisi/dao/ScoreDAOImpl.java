package gr.hua.dit.ds.sitisi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.sitisi.entity.ScoreEntity;

@Repository
public class ScoreDAOImpl implements ScoreDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<ScoreEntity> getScores() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ScoreEntity> query = currentSession.createQuery("from ScoreEntity", ScoreEntity.class);
		List<ScoreEntity> scores = query.getResultList();
		return scores;
	}

	@Override
	@Transactional
	public ScoreEntity getScore(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		ScoreEntity score = currentSession.get(ScoreEntity.class, id);
		return score;
	}

	@Override
	@Transactional
	public void saveScore(ScoreEntity score) {
		Session currentSession = sessionFactory.getCurrentSession();	
		currentSession.saveOrUpdate(score);
		
	}

	@Override
	@Transactional
	public void deleteScore(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		ScoreEntity score = currentSession.get(ScoreEntity.class, id);
		currentSession.delete(score);
		
	}

}
