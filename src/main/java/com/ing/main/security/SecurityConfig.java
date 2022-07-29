/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.main.security;

import javax.ws.rs.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 *
 * @author mirun
 */
@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/addProduct").hasRole("admin")
                .antMatchers(HttpMethod.DELETE, "/deleteProduct").hasRole("admin")
                .antMatchers(HttpMethod.POST, "/changePrice").hasRole("admin")
                .antMatchers(HttpMethod.POST, "/changeName").hasRole("admin")
                .antMatchers(HttpMethod.POST, "/changeNamePrice").hasRole("admin")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
