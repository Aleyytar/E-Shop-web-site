package shop.demo.entities.abstracts;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.entities.concretes.accounts.Company;
import shop.demo.entities.concretes.categories.SubCategory;
import shop.demo.entities.concretes.favorites.FavoriteProduct;
import shop.demo.entities.concretes.photos.ProductPhoto;
import shop.demo.entities.concretes.products.NormalProduct;
import shop.demo.entities.concretes.products.ProductComment;
import shop.demo.entities.concretes.products.ProductDislike;
import shop.demo.entities.concretes.products.ProductLike;
import shop.demo.entities.concretes.products.SpecialProduct;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="minPrice")
	private double minPrice;
	
	@Column(name="maxPrice")
	private double maxPrice;
	
	@ManyToOne()
	@JoinColumn(name="companyId")
	private Company company;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<ProductPhoto> productPhotos;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<ProductComment> productComments;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<ProductLike> productLikes;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<ProductDislike> productDislikes;
	
	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
	private NormalProduct normalProduct;
	
	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
	private SpecialProduct specialProduct;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<FavoriteProduct> favoriteProducts; 
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Color> colors;
	
	@ManyToOne()
	@JoinColumn(name = "subCategoryId")
	private SubCategory subCategory;
	
	@ManyToOne()
	@JoinColumn(name = "statusId")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "genderId")
	private Gender gender;
	
	
}
