package shop.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.demo.entities.abstracts.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {

	
	List<Color> getColorsByProductId(int productId);
	
}
