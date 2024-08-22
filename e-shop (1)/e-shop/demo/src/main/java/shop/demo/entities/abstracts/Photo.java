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
import shop.demo.entities.concretes.photos.ProductPhoto;
import shop.demo.entities.concretes.photos.ProfilePhoto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="photos")
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="url")
	private String url;
	
	@OneToOne(mappedBy = "photo")
	private ProfilePhoto profilePhoto;
	
	@OneToOne(mappedBy = "photo")
	private ProductPhoto productPhoto;

}
