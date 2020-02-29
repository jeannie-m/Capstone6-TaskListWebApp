package co.gc.tasklist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.gc.tasklist.entities.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{
	
//	@Query("SELECT DISTINCT category FROM Task")
//	List<String> findDistinctCategories();
	
	//List<String> findByCategoryDistinct();
}
