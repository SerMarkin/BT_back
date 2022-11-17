package com.bartrip.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bartrip.main.entity.User.AuthenticationRequestDTO;
import com.bartrip.main.entity.User.Role;
import com.bartrip.main.entity.User.Status;
import com.bartrip.main.entity.User.User;
import com.bartrip.main.entity.User.UserRepository;
import com.bartrip.main.security.JwtTokenProvider;

@Service
public class AuthiticateRestService {
    
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthiticateRestService(AuthenticationManager authenticationManager, UserRepository userRepository,
            JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String createTokenByEmail(AuthenticationRequestDTO request) {
        
        String email = request.getEmail();

        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, new String(request.getPassword())));
		SecurityContextHolder.getContext().setAuthentication(auth);
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("not found user"));
        String token = jwtTokenProvider.createToken(request.getEmail(), user.getRole().name());
        
        return token;
    }

    public String registrationByEmail(AuthenticationRequestDTO request) {
        String email = request.getEmail();
        CharSequence password = new String(request.getPassword());

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password).toCharArray());
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);

        userRepository.save(user);
        
        String token = createTokenByEmail(request);
        return token;
    }
    
}
