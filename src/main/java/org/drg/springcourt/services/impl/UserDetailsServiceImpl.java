package org.drg.springcourt.services.impl;

import org.drg.springcourt.models.UserEntity;
import org.drg.springcourt.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findByUsername(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		else {
			return new User(user.get().getUsername(), user.get().getPassword(), emptyList());
		}
	}

}
