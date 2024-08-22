package shop.demo.entities.concretes.favorites;

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
import shop.demo.entities.abstracts.Favorite;
import shop.demo.entities.abstracts.Product;
import shop.demo.entities.concretes.accounts.Customer;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="favoriteProducts")
public class FavoriteProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="favoriteId")
	private Favorite favorite;
	
	@ManyToOne()
	@JoinColumn(name="productId")
	private Product product;
	
	@ManyToOne()
	@JoinColumn(name = "customerId")
	private Customer customer;

}
