package com.bartrip.main.configurations;

import com.bartrip.main.security.JwtConfigure;
import com.bartrip.main.entity.User.Permission;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private final JwtConfigure jwtConfigure;

    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtConfigure jwtConfigure,
            @Qualifier("userDetailsServiceImp") UserDetailsService userDetailsService) {
        this.jwtConfigure = jwtConfigure;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                // .requiresChannel(channel -> channel.anyRequest().requiresSecure())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/secure").hasAnyAuthority(Permission.DEVELOPERS_READ.getPermission())
                .antMatchers("/").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/register").permitAll()
                .antMatchers("/logout").permitAll()
                // .antMatchers(HttpMethod.GET, "/short/nextbar").permitAll()
                .antMatchers(HttpMethod.GET, "/short/changebar")
                .hasAnyAuthority(Permission.DEVELOPERS_WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .apply(jwtConfigure);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder()).and();
        return authenticationManagerBuilder.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://localhost:8080", "http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}