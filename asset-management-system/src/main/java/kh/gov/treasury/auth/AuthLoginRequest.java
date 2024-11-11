package kh.gov.treasury.auth;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthLoginRequest {
	
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;         
    
    @NotEmpty(message = "password should not be empty")
    private String password;
    

}