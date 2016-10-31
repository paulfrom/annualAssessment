package com.example.securityConfig;

import com.example.filter.SimpleCORSFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

/**
 * Created with WebSecurityConfig
 * User: pual
 * Date: 2016/10/12
 * Desc:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private UserDetailsService userDetailsService;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new SimpleCORSFilter(),ChannelProcessingFilter.class).authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/accounts").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
