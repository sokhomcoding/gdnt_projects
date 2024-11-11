package kh.gov.treasury.user;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import kh.gov.treasury.role.Role;
import lombok.Builder;

@Builder
public record UserDto(

	    @NotEmpty(message = "First Name should not be empty")
		String firstName,
		
	    @NotEmpty(message = "Last Name should not be empty")
	    String lastName,

	    @NotEmpty(message = "Last Name should not be empty")
	    String gender,
	    
	    @NotEmpty(message = "Email should not be empty")
	    @Email 
	    String email,   
	    String phone,   

	    @NotEmpty(message = "Password should not be empty")
	    String password,
	    
	    String thumbnail,
	    
	    List<Role> roles
	    
		) {

}
