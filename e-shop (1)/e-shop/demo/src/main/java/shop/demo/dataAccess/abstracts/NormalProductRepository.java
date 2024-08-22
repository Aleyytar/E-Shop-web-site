package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.demo.entities.concretes.products.NormalProduct;

public interface NormalProductRepository extends JpaRepository<NormalProduct, Integer> {
	
	//List<NormalProduct> getNormalProductsByProductCategoryId(int categoryId);
	
	@Query("From NormalProduct NP Where NP.product.status.id = 1")
	List<NormalProduct> getAllActiveNormalProducts();
	
	@Query("From NormalProduct Np Where Np.product.gender.id = :id and Np.product.status.id = 1 ")
	List<NormalProduct> getNormalProductsByProductGenderId(int id);
	
	@Query("From NormalProduct Np Where Np.product.company.id = :companyId and Np.product.status.id = :statusId")
	List<NormalProduct> getAllNormalProductsByCompanyIdAndStatusId(int companyId,int statusId);
	
	@Query("From NormalProduct NP Where NP.product.status.id = 1 AND LOWER(NP.product.name) LIKE LOWER(CONCAT('%', :value, '%'))")
	List<NormalProduct> getAllNormalProductNameContaining(String value);
	
	@Query("From NormalProduct Np Where Np.product.id = :productId")
	NormalProduct getByProductId(int productId);
	
	
}