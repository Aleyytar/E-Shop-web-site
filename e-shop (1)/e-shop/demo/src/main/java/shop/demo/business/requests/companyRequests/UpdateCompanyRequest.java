package shop.demo.business.requests.companyRequests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import shop.demo.core.business.requests.UpdateRequest;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompanyRequest extends UpdateRequest{
	
	private int id;
	
	@NotBlank(message = "Şirket adı alanı boş bırakılamaz")
	@Size(min = 3,message = "Şirket adı alanı en az 3 karakterden oluşmalıdır")
	private String companyName;
	
	private String description;
	
	@NotBlank(message = "Email alanı boş bırakılamaz")
	@Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "Email alanı regex ile uyuşmadı")
	private String accountEmail;
	
	@NotBlank(message = "Telefon alanı boş bırakılamaz")
	private String accountPhoneNumber;
	
	@NotBlank(message = "Kullanıcı adı alanı boş bırakılamaz")
	@Size(min = 3,message = "Şirket kullanıcı adı alanı en az 3 karakterden oluşmalıdır")
	private String accountUsername;
	
	@NotBlank(message = "Şifre alanı boş bırakılamaz")
	@Size(min = 3,message = "Şifre alanı en az 3 karakter içermelidir")
	private String accountPassword;
	
	@NotBlank(message = "Şifre doğrulama alanı boş bırakılamaz")
	private String accountConfirmPassword;
	
	private int accountStatusId;

}
