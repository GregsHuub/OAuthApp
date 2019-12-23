package com.springApp.authentication;

import com.springApp.user.UserEntity;
import com.springApp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userByEmail = userService.findUserByEmail(email);

        if(userByEmail == null) {
            throw new UsernameNotFoundException(email);
        }
        if(!userByEmail.isEnabled()){
            throw new DisabledException("Account is not activated");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        userByEmail.getRoles().forEach(r -> grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
        return new CurrentUser(userByEmail.getEmail(), userByEmail.getPassword(), grantedAuthorities, userByEmail, userByEmail.isEnabled());
    }


}
