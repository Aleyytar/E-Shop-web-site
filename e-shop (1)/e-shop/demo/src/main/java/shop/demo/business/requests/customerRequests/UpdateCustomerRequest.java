package shop.demo.business.requests.customerRequests;

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
public class UpdateCustomerRequest extends UpdateRequest{
	
	private int id;
	private int accountStatusId;
	@NotBlank(message = "İsim alanı boş bırakılamaz")
	@Size(min = 3,message = "İsim alanı en az 3 karakterden oluşmalıdır")
	private String firstName;
	
	@NotBlank(message = "Soyisim alanı boş bırakılamaz")
	@Size(min = 3,message = "Soyisim alanı en az 3 karakterden oluşmalıdır")
	private String lastName;
	
	@NotBlank(message = "Email alanı boş bırakılamaz")
	@Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$",message = "Email alanı regex ile uyuşmadı")
	private String accountEmail;
	
	@NotBlank(message = "Telefon alanı boş bırakılamaz")
	private String accountPhoneNumber;
	
	@NotBlank(message = "Kullanıcı adı alanı boş bırakılamaz")
	private String accountUsername;
	
	@NotBlank(message = "Şifre alanı boş bırakılamaz")
	@Size(min = 3,message = "Şifre alanı en az 3 karakter içermelidir")
	private String accountPassword;
	
	@NotBlank(message = "Şifre doğrulama alanı boş bırakılamaz")
	private String accountConfirmPassword;
	

}
