package gr.hua.dit.ds.sitisi.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.ds.sitisi.dao.ApplicationDAO;
import gr.hua.dit.ds.sitisi.dao.ScoreDAO;
import gr.hua.dit.ds.sitisi.dao.StudentDAO;
import gr.hua.dit.ds.sitisi.entity.ApplicationEntity;
import gr.hua.dit.ds.sitisi.entity.ScoreEntity;
import gr.hua.dit.ds.sitisi.entity.StudentEntity;

@Controller
@Secured("ROLE_STAFF")
public class StaffController {
	
	
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private ScoreDAO scoreDAO;

	@RequestMapping("/")
	public String showStaff() {
		return "staff";
	}	
	@RequestMapping("/student-approval")
	public String showStudentApproval(Model model) {
		//Initialize our model attributes for display and form data
		List<StudentEntity> students = studentDAO.getStudents();
		
		//add them to the model
		model.addAttribute("student", new StudentEntity());
		model.addAttribute("students", students);
		
		return "pending-student";
	}
	@RequestMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") StudentEntity student) {
		//change the students permission and update the db
		student.setCanSubmit(true);
		studentDAO.saveStudent(student);
		
		return "redirect:/student-approval";
	}	
	@RequestMapping("/application-approval")
	public String showApplicationApproval(Model model) {
		//Initialize model attributes
		List<ApplicationEntity> applications = applicationDAO.getApplications();
		
		//add to the model
		model.addAttribute("applications", applications);
		model.addAttribute("application", new ApplicationEntity());
		
		return "pending-application";
	}
	@RequestMapping("/saveApplication")
	public String saveApplication(@ModelAttribute("application") ApplicationEntity application) {
		//change the applications approval status and update the db
		application.setApproved(true);
		applicationDAO.saveApplication(application);
		
		//Calculate score
		int score = 0;
		// Income points
		if(application.getIncome() == 0) {
			score = 1000;
		}
		else if(application.getIncome() < 10000) {
			score += 100;
		}
		else if(application.getIncome() < 15000) {
			score += 30;
		}
		
		//City points
		if(application.getHomeCity().equalsIgnoreCase("Athens")) {
			score += 50;
		}
		
		//Sibling points
		score += application.getSibling() * 20;
		
		//Add to db
		ScoreEntity newScore = new ScoreEntity(application.getId(), score);
		scoreDAO.saveScore(newScore);
 		
		return "redirect:/application-approval";
	}
	
	@PostMapping("/conclude-applications")
	public String endApplications(@ModelAttribute("maxAllowed") int maxAllowed, Model model) {
		List<ScoreEntity> scores = scoreDAO.getScores();
		Collections.sort(scores, ScoreEntity.DESCENDING_COMPARATOR);
		
		for(int i=0; i < scores.size();i++) {
			scores.get(i).setRank(i);
			if(i < maxAllowed) {
				scores.get(i).setApproved(true);
			}
			scoreDAO.saveScore(scores.get(i));
		}
		model.addAttribute(scores);
		return "rankings";
	}
	
	@GetMapping("/conclude-applications")
	public String showConclusionForm(Model model) {
		int maxAllowed = 0;
		model.addAttribute(maxAllowed);
		return "conclusion-form";
	}
	
}