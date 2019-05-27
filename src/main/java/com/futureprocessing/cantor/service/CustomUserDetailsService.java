package com.futureprocessing.cantor.service;

import com.futureprocessing.cantor.model.CustomUserDetails;
import com.futureprocessing.cantor.model.User;
import com.futureprocessing.cantor.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;


    @Override //Email is unique, in our case it's just account name
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByEmail(email);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("We could not find this Account"));
        return optionalUser.map(CustomUserDetails::new).get();
    }
}
