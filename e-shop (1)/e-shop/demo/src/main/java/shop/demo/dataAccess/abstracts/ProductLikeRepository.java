package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.demo.entities.concretes.products.ProductLike;

public interface ProductLikeRepository extends JpaRepository<ProductLike, Integer> {
	
	List<ProductLike> getProductLikesByProductId(int id);

}
