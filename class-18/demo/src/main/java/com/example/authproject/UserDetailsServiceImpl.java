package com.example.authproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    DBUserRepository dbUserRepository;

    // polymorphism
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DBUser dbUser = dbUserRepository.findByUsername(username);

        if(dbUser == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User "+username+" does not exist");
        }
        System.out.println("User "+ username + " found");
        return new ApplicationUser(dbUser);
    }
}
