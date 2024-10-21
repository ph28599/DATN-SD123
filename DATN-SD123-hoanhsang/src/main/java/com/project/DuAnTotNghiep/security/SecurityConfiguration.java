package com.project.DuAnTotNghiep.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/customer/**").hasRole("CUSTOMER")
                .antMatchers("/staff/**").hasRole("STAFF")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/default", true)
                .permitAll();
    }
}
