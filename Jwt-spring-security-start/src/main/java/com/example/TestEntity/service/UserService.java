package com.example.TestEntity.service;

import com.example.TestEntity.Response.AuthenticationResponse;
import com.example.TestEntity.dto.AuthenticationRequest;
import com.example.TestEntity.repositery.UserRepositery;
import com.example.TestEntity.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    //loginService
    //registerUserService
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserRepositery userRepositery;

    public ResponseEntity<?> loginService(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (Exception e) {
            System.out.println(e+ "incorrect username or password");
            return new ResponseEntity<>("This user not found", HttpStatus.NOT_FOUND);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

//    public UserEntity registerUserService(UserModel userModel){
//        UserEntity userEntity=new UserEntity(userModel.getUsername(),userModel.getPassword(),userModel.getRole());
////         return new ResponseEntity<UserEntity>(this.userRepositery.save(userEntity), HttpStatus.OK);
//        return this.userRepositery.save(userEntity);
//    }

}
