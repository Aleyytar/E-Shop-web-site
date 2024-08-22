package shop.demo.entities.concretes.products;

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
import shop.demo.entities.abstracts.Dislike;
import shop.demo.entities.abstracts.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productDislikes")
public class ProductDislike {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="productId")
	private Product product;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dislikeId")
	private Dislike dislike;
	

}
