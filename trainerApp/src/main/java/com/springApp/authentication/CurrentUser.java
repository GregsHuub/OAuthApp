package com.springApp.authentication;


import com.springApp.user.UserEntity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {


    private final UserEntity user;
    private final boolean enabled;

    public CurrentUser(String email, String password, Collection<? extends GrantedAuthority> authorities, UserEntity user, Boolean enabled){
        super(email, password, authorities);
        this.user = user;
        this.enabled = enabled;
    }

    public UserEntity getUser(){
        return user;
    }

}
