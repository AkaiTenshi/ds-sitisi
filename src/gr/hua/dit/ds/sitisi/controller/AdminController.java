package gr.hua.dit.ds.sitisi.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin")
@Secured("ROLE_ADMNIN")
public class AdminController {
	
	

}
