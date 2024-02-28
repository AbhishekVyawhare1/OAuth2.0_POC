package com.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RegisterLogin.Entity.RegisterUser;
import com.example.RegisterLogin.Repo.EmployeeRepo;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepo userRepository;



	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		RegisterUser user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("No User Found");
		}
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), 
				user.getPassword(),
				true, 
				true, 
				true, 
				true, 
				getAuthorities(List.of(user.getEmail())));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}
