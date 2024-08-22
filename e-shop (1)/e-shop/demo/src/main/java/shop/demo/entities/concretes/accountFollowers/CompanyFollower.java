package shop.demo.entities.concretes.accountFollowers;

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
import shop.demo.entities.abstracts.Follower;
import shop.demo.entities.concretes.accounts.Company;
import shop.demo.entities.concretes.accounts.Customer;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="companyFollowers")
public class CompanyFollower {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="followerId")
	private Follower follower;
	
	@ManyToOne()
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@ManyToOne()
	@JoinColumn(name="companyId")
	private Company company;
	
	
	
	

}
