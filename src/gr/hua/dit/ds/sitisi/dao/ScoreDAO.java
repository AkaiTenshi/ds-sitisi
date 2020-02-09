package gr.hua.dit.ds.sitisi.dao;

import java.util.List;

import gr.hua.dit.ds.sitisi.entity.ScoreEntity;

public interface ScoreDAO {
	public List<ScoreEntity> getScores();
	public ScoreEntity getScore(String id);
	public void saveScore(ScoreEntity score);
	public void deleteScore(String id);

}
