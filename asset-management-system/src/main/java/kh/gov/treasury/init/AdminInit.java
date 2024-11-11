package kh.gov.treasury.init;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import kh.gov.treasury.role.Role;
import kh.gov.treasury.role.RoleRepository;
import kh.gov.treasury.user.User;
import kh.gov.treasury.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdminInit {
	
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	Role roleAdmin = Role.builder().name("ADMIN").createdDate(LocalDateTime.now()).build();
	Role roleManagement = Role.builder().name("MANAGMENT").createdDate(LocalDateTime.now()).build();
	Role roleStaff = Role.builder().name("STAFF").createdDate(LocalDateTime.now()).build();
	Role roleGuest = Role.builder().name("GUEST").createdDate(LocalDateTime.now()).build();
	
	@PostConstruct
	void init() { 
		if(!userRepository.findByEmail("admin@gmail.com").isPresent()) {
			// save role ========================================================
			var roles = List.of(roleAdmin, roleManagement, roleStaff, roleGuest);
			roleRepository.saveAll(roles);
			// ==================================================================
			 
			// save default admin user ==========================================
			User user = User.builder()
					.firstName("Admin").lastName("System")
					.email("admin@gmail.com").password(passwordEncoder.encode("123456"))
					.gender("Male")
					.thumbnail("admin.jpg")
					.roles(roles)
					.enabled(true).accountLocked(false)
					.createdDate(LocalDateTime.now())
					.build();
			userRepository.save(user);		
			// ==================================================================
		}
		
	}

}
