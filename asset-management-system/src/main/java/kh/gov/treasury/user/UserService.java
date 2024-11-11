package kh.gov.treasury.user;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.gov.treasury.role.Role;
import kh.gov.treasury.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

	    private final UserRepository userRepository;
	    private final RoleRepository roleRepository;
	    private final PasswordEncoder passwordEncoder;

	    /**
	     * Save User
	     * @param UserDto
	     * @void
	     */
	    public void saveUser(UserDto request) {	    	
	        User user = User.builder()
	        		.firstName(request.firstName())
	        		.lastName(request.lastName())
	        		.gender(request.gender())
	        		.email(request.email())
	        		.phone(request.phone())
	        		.password(passwordEncoder.encode(request.password()))
	        		.build();	 

	        Optional<Role> role = roleRepository.findByName("ADMIN");	        
	        user.setRoles(Arrays.asList(role.get()));   	        
	        userRepository.save(user);
	    }

}
