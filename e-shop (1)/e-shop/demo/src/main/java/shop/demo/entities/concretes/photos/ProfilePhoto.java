package shop.demo.entities.concretes.photos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.demo.entities.abstracts.Account;
import shop.demo.entities.abstracts.Photo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="profilePhotos")
public class ProfilePhoto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	
	@OneToOne()
	@JoinColumn(name="accountId")
	private Account account;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="photoId")
	private Photo photo;
	
	
}
