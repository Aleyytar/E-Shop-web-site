package shop.demo.entities.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.entities.concretes.accountFollowers.CompanyFollower;
import shop.demo.entities.concretes.accountFollowers.CustomerFollower;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="followers")
public class Follower {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@OneToOne(mappedBy = "follower")
	private CustomerFollower customerFollower;
	
	@OneToOne(mappedBy = "follower")
	private CompanyFollower companyFollower;

}
