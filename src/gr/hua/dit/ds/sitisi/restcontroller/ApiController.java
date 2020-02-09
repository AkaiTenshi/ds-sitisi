package gr.hua.dit.ds.sitisi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import gr.hua.dit.ds.sitisi.dao.ApplicationDAO;
import gr.hua.dit.ds.sitisi.dao.ScoreDAO;
import gr.hua.dit.ds.sitisi.dao.StudentDAO;
import gr.hua.dit.ds.sitisi.entity.ApplicationEntity;
import gr.hua.dit.ds.sitisi.entity.ScoreEntity;
import gr.hua.dit.ds.sitisi.entity.StudentEntity;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private ScoreDAO scoreDAO;
	
	//Student table handling
	@GetMapping("/student/{studentID}")
	public StudentEntity getStudent(@PathVariable String studentID) {
		StudentEntity student = studentDAO.getStudent(studentID);
		
		//check validity of id
		if( student == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found!");
		}
		
		return student;
	}
	
	@PostMapping("/student")
	public StudentEntity updateStudent(@RequestBody StudentEntity student) {
		studentDAO.saveStudent(student);
		return student;
	}
	
	//Application table handling
	@GetMapping("/application/{studentID}")
	public ApplicationEntity getApplication(@PathVariable String studentID) {
		ApplicationEntity application = applicationDAO.getApplication(studentID);
		
		//Check validity
		if(application == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "You have not made an application yet");
		}
		
		
		return application;
	}
	
	@PostMapping("/application")
	public ApplicationEntity updateApplication(@RequestBody ApplicationEntity application) {
		applicationDAO.saveApplication(application);
		return application;
	}
	
	//Score table handling
	@GetMapping("/score/{studentID}")
	public ScoreEntity getScore(@PathVariable String studentID) {
		ScoreEntity score = scoreDAO.getScore(studentID);
		
		if(score == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "You have not made an application yet");
		}
		
		return score;
	}

}
