package gr.hua.dit.ds.sitisi.dao;

import java.util.List;

import gr.hua.dit.ds.sitisi.entity.ApplicationEntity;

public interface ApplicationDAO {
	public List<ApplicationEntity> getApplications();
	public ApplicationEntity getApplication(String id);
	public void saveApplication(ApplicationEntity application);
	public void deleteApplication(String id);

}
