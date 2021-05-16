package com.tpsbackendsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tpsbackendsystem.model.Role;
import com.tpsbackendsystem.model.User;
import com.tpsbackendsystem.repository.UserRepository;
@Service
public class MyUserDetialsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		List<GrantedAuthority> list = new ArrayList<>();
		for(Role r : user.getRoles()) {
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(r.getName());
			list.add(sga);			
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(),list );
	}

}
