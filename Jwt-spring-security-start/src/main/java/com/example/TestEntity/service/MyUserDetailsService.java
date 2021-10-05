package com.example.TestEntity.service;

import com.example.TestEntity.entity.UserEntity;
import com.example.TestEntity.repositery.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepositery userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUserEntity =userRepository.findByUsername(userName);
        if(optionalUserEntity.isPresent()){
               UserEntity userEntity= optionalUserEntity.get();
                List<SimpleGrantedAuthority> authorities = new ArrayList();
                authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));
               User user = new User(userEntity.getUsername(),userEntity.getPassword(),authorities);
               return user;
        }
        else {
            throw new UsernameNotFoundException("Not found"+userName);
        }

    }
}