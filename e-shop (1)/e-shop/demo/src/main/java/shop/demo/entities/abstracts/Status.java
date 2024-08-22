package shop.demo.entities.abstracts;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.entities.concretes.categories.SubCategory;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "statuses")
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "status")
	private List<Account> accounts;
	
	@OneToMany(mappedBy = "status")
	private List<Product> products;
	
	@OneToMany(mappedBy = "status")
	private List<Category> categories;
	
	@OneToMany(mappedBy = "status")
	private List<SubCategory> subCategories;
}
