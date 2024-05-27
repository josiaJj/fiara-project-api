package school.hei.fiara.fiaraproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import school.hei.fiara.fiaraproject.repository.UserRepository;
import school.hei.fiara.fiaraproject.service.CustomUserDetailsService;
import school.hei.fiara.fiaraproject.service.JwtService;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Lazy
    @Autowired
    private JwtService jwtService;

    @Lazy
    @Autowired
    private UserDetailsService userDetailsService;

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    private final UserRepository userRepository;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    public SecurityConfig(CustomUserDetailsService customUserDetailsService, UserRepository userRepository1) {
        this.customUserDetailsService = customUserDetailsService;
        this.userRepository = userRepository1;
    }

    @Bean
    SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        (auth) -> auth
                                .requestMatchers("/ping", "/User/login").permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    List<InMemoryUserDetailsManager> userDetailsManager() {
        List<school.hei.fiara.fiaraproject.model.User> userList = userRepository.findAll();
        List<InMemoryUserDetailsManager> managers = new ArrayList<>();
        for (school.hei.fiara.fiaraproject.model.User user : userList) {
            UserDetails userDetails = User.builder()
                    .username(user.getUsername())
                    .password(passwordEncoder().encode(user.getPassword()))
                    .roles("USER")
                    .build();
            managers.add(new InMemoryUserDetailsManager(userDetails));
        }
        return managers;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtService, userDetailsService);
    }
}
