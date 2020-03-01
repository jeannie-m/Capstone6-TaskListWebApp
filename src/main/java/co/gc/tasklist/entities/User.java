package co.gc.tasklist.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class User implements Serializable{

 
	private static final long serialVersionUID = 1L;

		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		private String username;
		private String password;
		
		@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
		private Set<Task> myTasks;

		public Long getId() {
			return id;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		public Set<Task> getMyTasks() {
			return myTasks;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setMyTasks(Set<Task> myTasks) {
			this.myTasks = myTasks;
		}

		@Override
		public String toString() {
			return String.format("User [id=%s, username=%s, password=%s, myTasks=%s]", id, username, password, myTasks);
		}
		
		
}
