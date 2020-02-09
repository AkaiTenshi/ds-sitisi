package gr.hua.dit.ds.sitisi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "semester")
	private int semester;
	
	@Column(name = "canSubmit")
	private boolean canSubmit;

	public StudentEntity() {
		
	}

	public StudentEntity(String id, String firstname, String lastname, String phone, int semester, boolean canSubmit) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.semester = semester;
		this.canSubmit = canSubmit;
	}

	//Getters & Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public boolean isCanSubmit() {
		return canSubmit;
	}

	public void setCanSubmit(boolean canSubmit) {
		this.canSubmit = canSubmit;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone
				+ ", semester=" + semester + ", canSubmit=" + canSubmit + "]";
	}
	
	
	

}
