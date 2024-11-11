package kh.gov.treasury.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kh.gov.treasury.user.User;
import kh.gov.treasury.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HttpUserDetailsService implements UserDetailsService {
	 
    private final UserRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<User> userDtl = repository.findByEmail(username);
    	if(!userDtl.isPresent()) {
    		throw new UsernameNotFoundException("User not found");
    	}

    	System.out.println("userDtl.get()===>>"+userDtl.get().toString());
        return userDtl.get();
    }
    
}