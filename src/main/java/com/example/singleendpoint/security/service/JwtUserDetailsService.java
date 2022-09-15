package com.example.singleendpoint.security.service;

import com.example.singleendpoint.model.entity.UserEntity;
import com.example.singleendpoint.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByUserName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        Collection<SimpleGrantedAuthority> authorityCollection = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(userEntity.getUserName(), userEntity.getPassword(), authorityCollection);
    }
}