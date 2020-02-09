package gr.hua.dit.ds.sitisi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "applications")
public class ApplicationEntity {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "income")
	private int income;
	
	@Column(name = "sibling")
	private int sibling;
	
	@Column(name = "documents")
	private boolean documents;
	
	@Column(name = "home_city")
	private String homeCity;
	
	@Column(name = "approved")
	private boolean approved;

	public ApplicationEntity() {
		
	}

	public ApplicationEntity(String id, int income, int sibling, boolean documents, String homeCity,
			boolean approved) {
		super();
		this.id = id;
		this.income = income;
		this.sibling = sibling;
		this.documents = documents;
		this.homeCity = homeCity;
		this.approved = approved;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getSibling() {
		return sibling;
	}

	public void setSibling(int sibling) {
		this.sibling = sibling;
	}

	public boolean isDocuments() {
		return documents;
	}

	public void setDocuments(boolean documents) {
		this.documents = documents;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "ApplicationEntity [id=" + id + ", income=" + income + ", sibling=" + sibling + ", documents="
				+ documents + ", homeCity=" + homeCity + ", approved=" + approved + "]";
	}
	
	
	
}
