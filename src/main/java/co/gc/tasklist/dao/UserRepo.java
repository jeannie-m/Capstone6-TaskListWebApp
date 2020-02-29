package co.gc.tasklist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gc.tasklist.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	public User findByUsernameIgnoreCase(String username);
	
}
