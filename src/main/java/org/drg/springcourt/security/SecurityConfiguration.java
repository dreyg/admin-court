package org.drg.springcourt.security;

import org.drg.springcourt.services.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*
         * 1. Disable cookies usage
         * 2. Enable CORS configuration with default values
         * 3. Disable CSRF filter
         * 4. Specify not needed authentication endpoints
         * 5. Any other URL is secured, authentication is needed
         */
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .cors().and().csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.POST, Constants.LOGIN_URL).permitAll()
                //.authorizeRequests()
                //.antMatchers(HttpMethod.POST, Constants.LOGIN_URL).permitAll()
                //.antMatchers(HttpMethod.GET, Constants.GET_USERS_URL).permitAll()
                //.antMatchers(HttpMethod.GET, Constants.GET_USER_BY_USER_ID_URL).permitAll()
                .antMatchers(HttpMethod.POST, Constants.CREATE_USERS_URL).permitAll()
                .antMatchers(HttpMethod.GET, Constants.GET_USER_WHO_ME_URL).permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .anyRequest().authenticated().and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()));
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Define the class that recover the users and the algorithm to process paswords
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

}
