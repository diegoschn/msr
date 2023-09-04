package com.diegoschneider.msr.security.service;

import com.diegoschneider.msr.exception.NegocioException;
import com.diegoschneider.msr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(Objects.isNull(username)){
            throw new NegocioException("Usuário não encontrado");
        }

        return userRepository.findByLogin(username);
    }
}
