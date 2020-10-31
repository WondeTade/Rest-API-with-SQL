package com.bulimas.informationhub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class InformationHubAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    private final String mainRoot = "/api/v1/person";
    private final String admin = "ADMIN";
    private final String user = "USER";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(mainRoot + "/admin/**").hasRole(admin)
                .antMatchers(mainRoot + "/admin").hasRole(admin)
                .antMatchers(mainRoot + "/user/**").hasAnyRole(admin, user)
                .antMatchers(mainRoot + "/user").hasAnyRole(admin, user)
                .antMatchers(mainRoot + "/**").permitAll()
                .antMatchers(mainRoot + "/").permitAll()
                .and()
                .httpBasic();
        http
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, 1 "
                    + "from users "
                    + "where username = ?")
            .authoritiesByUsernameQuery("select username, authority "
                    + "from authorities "
                    + "where username = ?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
