package shop.demo.entities.concretes.accounts;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.entities.abstracts.Account;
import shop.demo.entities.concretes.accountFollowers.CompanyFollower;
import shop.demo.entities.concretes.accountFollowers.CustomerFollower;
import shop.demo.entities.concretes.favorites.FavoriteProduct;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountId")
	private Account account;
	
	@OneToMany(mappedBy = "customer")
	private List<CustomerFollower> customerFollowers;
	
	@OneToMany(mappedBy = "customer")
	private List<CompanyFollower> companyFollower;
	
	@OneToMany(mappedBy = "customer")
	private List<FavoriteProduct> favoriteProducts;
	
}
