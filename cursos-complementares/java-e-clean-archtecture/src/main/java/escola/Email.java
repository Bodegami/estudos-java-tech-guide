package escola;

public class Email {
	
	private String email;

	public Email(String email) {
		this.email = isValid(email);
	}
	
	public String isValid(String email) {
		if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			throw new IllegalArgumentException("invalid email!");
		}
		
		return email;
	}
	
}
