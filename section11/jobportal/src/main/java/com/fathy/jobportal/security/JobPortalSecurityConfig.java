package com.fathy.jobportal.security;

import com.fathy.jobportal.security.filter.JwtTokenValidatorFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class JobPortalSecurityConfig {

    @Qualifier("publicPaths")
    private final List<String> publicPaths;

    @Qualifier("securedPaths")
    private final List<String> securedPaths;

    @Bean
    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) {
        return http.csrf(csrfConfigurer -> csrfConfigurer.disable())
                .cors(corsConfig -> corsConfig.configurationSource(corsConfigurationSource()))
                       .authorizeHttpRequests(requests ->{
                            publicPaths.forEach(path -> requests.requestMatchers(path).permitAll());
                            securedPaths.forEach(path -> requests.requestMatchers(path).authenticated());
                           requests.anyRequest().denyAll();
                       })
                .addFilterBefore(new JwtTokenValidatorFilter(publicPaths), BasicAuthenticationFilter.class)
                       .formLogin(flc -> flc.disable())
                       .httpBasic(withDefaults())
                       .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public UserDetailsService  userDetailsService() {
//        var password1 = passwordEncoder().encode("Mohamed@123");
//        System.out.println("password1 = " + password1);
//        var password2 = passwordEncoder().encode("Amr@123");
//        System.out.println("password2 = " + password2);

        var user1 = User.builder().username("mohamed").password("$2a$10$NdxjC6TfK7C327nvQdP4guGLBGzPVfe0hArr1Bc3zGdaM735yV6Tq")
                .roles("ADMIN").build();

        var user2 = User.builder().username("amr").password("$2a$10$eDk6Y.FzDlVTS.VLjXs67eFAvmw6L8RwoSsljkg9xeszlDkrEife6")
                .roles("USER").build();

        return new InMemoryUserDetailsManager(
                user1,
                user2
        );


    }

    @Bean
    public AuthenticationManager authenticationManager()  {
        var authenticationProvider = new DaoAuthenticationProvider(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
