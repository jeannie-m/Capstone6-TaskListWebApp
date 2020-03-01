package co.gc.tasklist;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import co.gc.tasklist.dao.UserRepo;
import co.gc.tasklist.entities.Task;
import co.gc.tasklist.entities.User;

@Controller
public class UserController {
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private HttpSession sesh;
	
	@RequestMapping("/")
	public ModelAndView redirect() {
		//if user is not logged in, "log in to get started"
		//if user is logged in, redirect to dashboard
		return new ModelAndView("redirect:/login");
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("password") String password){
		User user = uRepo.findByUsernameIgnoreCase(username);

		if (user == null) {
			return new ModelAndView("login","messageU", "User not found. Try <a href=\"/register\">Registering</a> instead!");
		}else if (!password.equals(user.getPassword())) {
			return new ModelAndView("login","messagePw", "Incorrect password.");
		} else {
			sesh.setAttribute("user", user);
			Set<Task> myTasks = user.getMyTasks();
		return new ModelAndView("dashboard", "myTasks", myTasks);
		}
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		sesh.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/register")
	public ModelAndView createAccount() {
		return new ModelAndView("register");
	}
	
	@PostMapping ("/register")
	public ModelAndView createAccount(User user) {
		if (uRepo.findByUsernameIgnoreCase(user.getUsername()) == null) {
			uRepo.save(user);
			sesh.setAttribute("user", user);
			return new ModelAndView("dashboard", "user", user); 
		}else {
			return new ModelAndView("register", "messageUnTaken", "That username is taken. Try again!");
		}
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView showDashboard(RedirectAttributes rd) {
		
		User user = (User) sesh.getAttribute("user");
		if (user == null) {
			rd.addFlashAttribute("messageLoginPlz", "Please login first");
			return new ModelAndView("redirect:/login");
			//redirect to login with redir attribute
		}else {
			//System.out.println(user.getMyTasks());
		return new ModelAndView("dashboard");
		}
	}
	@PostConstruct 	
	public void testIt() {
		System.out.println("tester"); 
		User user = (User)uRepo.findById(1L);
		}
}
