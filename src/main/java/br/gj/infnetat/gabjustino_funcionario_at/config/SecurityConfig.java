package br.gj.infnetat.gabjustino_funcionario_at.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        String senha = passwordEncoder().encode("123");
//        UserDetails fabri = User.builder().username("fabri")
//                .password(senha).roles("USER").build();

        UserDetails gabri = User.builder().username("gabri")
                .password(senha).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(gabri);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider())
                .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
                        auth -> {
                            try {
                                auth
                                        .requestMatchers("/h2-console/**").permitAll()
                                        .requestMatchers("/funcionarios/**").permitAll()
                                        .requestMatchers("/departamentos/**").permitAll()
                                        .requestMatchers("/usuarios/**").permitAll()
                                        .anyRequest().authenticated().and().headers().frameOptions().sameOrigin();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                ).httpBasic(Customizer.withDefaults())
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll());
        return http.build();
    }
}
