package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.demo.entities.concretes.products.SpecialProduct;

public interface SpecialProductRepository extends JpaRepository<SpecialProduct, Integer> {
	
	List<SpecialProduct> getSpecialProductsByProductCompanyId(int companyId);
	
	@Query("From SpecialProduct Sp Where Sp.product.gender.id = :id and Sp.product.status.id = 1")
	List<SpecialProduct> getSpecialProductsByProductGenderId(int id);

}
 