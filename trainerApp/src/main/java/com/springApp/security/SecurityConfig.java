package com.springApp.security;

import com.springApp.authentication.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // W TEJ METODZIE UDZIELAMY DOSTĘPU DOKONKRETNYCH STRON/POSTRON W ZALEZNOSCI OD ROLI(USER,ADMIN,GOSC),
        //OKRESLAMY TEZ STRONE LOGOWANIA I PRZEKIEROWANIA NA LOGOUT
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/user/login/").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/user/register/save/").permitAll()
                .antMatchers("/trainer/register").permitAll()
                .antMatchers("/trainer/register/save").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN").anyRequest()
                .authenticated().and().csrf().disable()
                .formLogin().loginPage("/user/login").permitAll()
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/", true)
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout");
    }

    public void configure(WebSecurity web) throws Exception {
        // JEZELI MAMY SKONFIGUROWANE SECURITY, BEZ TEJ METODY PLIKI HTML I INNE KOMPONENTY NIE BYLBY BY DOSTEPNE DLA SPRINGA
        web
                .ignoring()
                .antMatchers("/resources/**",
                        "/static/**",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/scss/**",
                        "/fonts/**",
                        "/obrazki/**");
    }
}
