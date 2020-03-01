package co.gc.tasklist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.gc.tasklist.entities.Task;
import co.gc.tasklist.entities.User;

public interface TaskRepo extends JpaRepository<Task, Long>{
	
	List<Task> findByUserId(Long id);
//	@Query("SELECT DISTINCT category FROM Task")
//	List<String> findDistinctCategories();
	
	//List<String> findByCategoryDistinct();
}
