package co.gc.tasklist;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.gc.tasklist.dao.TaskRepo;
import co.gc.tasklist.dao.UserRepo;
import co.gc.tasklist.entities.Task;
import co.gc.tasklist.entities.User;

@Controller @RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepo tRepo;
	@Autowired
	private UserRepo uRepo;
	@Autowired
	private HttpSession sesh;
	
	@RequestMapping("/add")
	public ModelAndView addTask(@RequestParam(name="name", required=false) String name) {
		return new ModelAndView("add");
	}
	//@RequestParam(name="name") String name, 
	//	@RequestParam(name="description") String description,
	//	@RequestParam(name="dueDate") Date dueDate,
	//	@RequestParam(name="status") Boolean status,
	//	@RequestParam(name="priorityLevel") String priorityLevel,
	//	@RequestParam(name="category") String Category
	
	
	@PostMapping("/add")
	public ModelAndView addTask(Task task, RedirectAttributes rd) {		
		User user = (User) sesh.getAttribute("user");
		if (user == null) {
			rd.addFlashAttribute("messageLoginPlz", "Please login first");
			return new ModelAndView("redirect:/login");
			//redirect to login with redir attribute
		}
		task.setUser(user);
		tRepo.save(task);
		return new ModelAndView("dashboard", "recentTask", task);
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteTask(@RequestParam("id") Long id) {
		tRepo.deleteById(id);
		return new ModelAndView("redirect:/dashboard");
	}
}
