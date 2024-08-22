package shop.demo.business.rules.accountRules;

public interface AccountBusinessRules {
	
	void existsEmailBefore(String email);
	void existsUsernameBefore(String username);
	void checkPasswordFields(String password,String confirmPassword);

}
