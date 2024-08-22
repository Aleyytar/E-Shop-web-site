package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.demo.entities.concretes.favorites.FavoriteProduct;

public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct, Integer> {
	
	List<FavoriteProduct> getAllFavoriteProductsByCustomerId(int customerId);

}
