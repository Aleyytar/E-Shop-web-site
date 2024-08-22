package shop.demo.entities.concretes.photos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.entities.abstracts.Photo;
import shop.demo.entities.abstracts.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productPhotos")
public class ProductPhoto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="productId")
	private Product product;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="photoId")
	private Photo photo;
	
}
 