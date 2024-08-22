package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.demo.entities.concretes.categories.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
	
	@Query("From SubCategory Sc Where Sc.category.status.id = 1")
	List<SubCategory> getAllActiveSubCategory();
	
	@Query("From SubCategory Sc Where Sc.category.status.id = 1 AND Sc.category.gender.id = :genderId")
	List<SubCategory> getAllSubCategoriesByCategoryGenderId(int genderId);
	
	
	

}
