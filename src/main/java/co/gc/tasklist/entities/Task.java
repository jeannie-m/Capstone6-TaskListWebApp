package co.gc.tasklist.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private LocalDate dueDate;
	private Boolean status;
	private String priorityLevel;
	//private String category;
	
	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public String getPriorityLevel() {
		return priorityLevel;
	}

//	public String getCategory() {
//		return category;
//	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDueDate(String date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dueDate = LocalDate.parse(date, format);
		this.dueDate = dueDate;
	}

//	public void setStatus(Boolean status) {
//		this.status = status;
//	}
	
	public void setStatus(String status) {
		Boolean statusToBool = false;
		if(status.equals("true")){
			statusToBool = true;
		}
		this.status = statusToBool;
	}

	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

//	public void setCategory(String category) {
//		this.category = category;
//	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description
				+ ", priorityLevel=" + priorityLevel + "]";
	}

	
//	@Override
//	public String toString() {
//		return "Tester";
//	}
	
	
}
