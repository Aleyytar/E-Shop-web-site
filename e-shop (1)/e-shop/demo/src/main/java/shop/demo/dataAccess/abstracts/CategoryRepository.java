package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.demo.entities.abstracts.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	
	@Query("From Category C Where C.status.id = 1")
	List<Category> getAllActiveCategories();
	
	@Query("From Category C Where C.status.id = 1 AND C.gender.id = 1")
	List<Category> getAllMenCategories();
	
	@Query("From Category C Where C.status.id = 1 AND C.gender.id = 2")
	List<Category> getAllWomenCategories();
	
	@Query("From Category C Where C.status.id = 1 AND C.gender.id = 3")
	List<Category> getAllUnisexCategories();
	
	
	

}
