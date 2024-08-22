package shop.demo.entities.concretes.categories;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.entities.abstracts.Category;
import shop.demo.entities.abstracts.Product;
import shop.demo.entities.abstracts.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subCategories")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne()
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@OneToMany(mappedBy = "subCategory")
	private List<Product> products;
	
	@ManyToOne()
	@JoinColumn(name="statusId")
	private Status status;

}
