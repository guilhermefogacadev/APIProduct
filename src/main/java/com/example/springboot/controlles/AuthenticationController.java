package com.example.springboot.controlles;

import com.example.springboot.dtos.AuthenticationDTO;
import com.example.springboot.dtos.RegisterDTO;
import com.example.springboot.models.UserModel;
import com.example.springboot.repositories.UserRepository;
import jakarta.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity  login(@RequestBody@Valid AuthenticationDTO data){
        UsernamePasswordAuthenticationToken userPassword= new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth=this.authenticationManager.authenticate(userPassword);
        return  ResponseEntity.ok().build();
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.userRepository.findByLogin(data.login())!=null)return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser= new UserModel(data.login(),encryptedPassword,data.role());

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
