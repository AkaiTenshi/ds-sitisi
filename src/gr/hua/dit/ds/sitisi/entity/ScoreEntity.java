package gr.hua.dit.ds.sitisi.entity;

import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class ScoreEntity {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "score")
	private int score;
	
	@Column(name = "approved")
	private boolean approved;
	
	@Column(name = "ranking")
	private int rank;
	
	public static final Comparator<ScoreEntity> DESCENDING_COMPARATOR = 
		    Comparator.comparing(ScoreEntity::getScore).reversed();

	public ScoreEntity() {
		
	}

	public ScoreEntity(String id, int score) {
		super();
		this.id = id;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "ScoreEntity [id=" + id + ", score=" + score + ", approved=" + approved + ", rank=" + rank + "]";
	}

	
	
	
	
}
