package com.example.lab2.service.impl;

import com.example.lab2.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class ImportantUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    public ImportantUserDetailsService(UserRepo userRepo) {

        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByEmail(username);
        var userDetails = new ImportantUserDetails(user);
        return userDetails;
    }

}



