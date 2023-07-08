package com.example.springsecuritydemodb.config;

import com.example.springsecuritydemodb.constants.Constants;
import com.example.springsecuritydemodb.services.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DemoUserService demoUserService;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(demoUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.authorizeRequests()
                 .antMatchers("/doctor/**").hasAuthority(Constants.DOCTOR_DETAILS_AUTHORITY)
                 .antMatchers("/deo/**").hasAuthority(Constants.DEO_DETAILS_AUTHORITY)
                 .antMatchers("/ceo/**").hasAuthority(Constants.CEO_DETAILS_AUTHORITY)
                 .antMatchers("/schedule/**").hasAuthority(Constants.SCHEDULE_APPOINTMENTS_AUTHORITY)
                 .antMatchers("/**").permitAll()
                 .and()
                 .formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncode() {
        return new BCryptPasswordEncoder();
    }
}
