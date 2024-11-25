package fr.diginamic.tempsLibre.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Décris la configuration de Sécurité Spring mise en place
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    private String baseUrl = "http://localhost:8080";
    @Value("${roles.admin")
    private String roleAdmin;

    /**
     * Crée un bean pour le gestionnaire d'authentification.
     *
     * @param authenticationConfiguration la configuration d'authentification.
     * @return le gestionnaire d'authentification.
     * @throws Exception en cas d'erreur.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Crée un bean pour l'encodeur de mot de passe.
     *
     * @return l'encodeur de mot de passe.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Définit les endpoints autorisés sans authentification.
     *
     * @return un tableau de chaînes de caractères représentant les endpoints autorisés.
     */
    private String[] allowedEndpoints() {
        return new String[]{
                "/**",
        };
    }

    /**
     * Définit les endpoints nécessitant une authentification.
     *
     * @return un tableau de chaînes de caractères représentant les endpoints autorisés.
     */
    private String[] authenticatedEndpoints() {
        return new String[]{
                "/**",
        };
    }

    /**
     * Définit les endpoints PUT autorisés pour les administrateurs.
     *
     * @return un tableau de chaînes de caractères représentant les endpoints PUT autorisés pour les administrateurs.
     */
    public String[] adminPutEndpoints() {
        return new String[]{
                "/**",
        };
    }

    /**
     * Définit les endpoints DELETE autorisés pour les administrateurs.
     *
     * @return un tableau de chaînes de caractères représentant les endpoints DELETE autorisés pour les administrateurs.
     */
    public String[] adminDeleteEndpoints() {
        return new String[]{
                "/**",

        };
    }

    /**
     * Configure les requêtes autorisées selon les rôles des utilisateurs et leur état de connexion.
     *
     * @param http l'objet HttpSecurity.
     * @return l'objet SecurityFilterChain configuré.
     * @throws Exception en cas d'erreur.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(requests -> requests
//                .requestMatchers(HttpMethod.PUT, adminPutEndpoints()).hasAuthority(roleAdmin)
//                .requestMatchers(HttpMethod.DELETE, adminDeleteEndpoints()).hasAuthority(roleAdmin)
                        .requestMatchers(HttpMethod.PUT, adminPutEndpoints()).permitAll()
                        .requestMatchers(HttpMethod.DELETE, adminDeleteEndpoints()).permitAll()
                        .requestMatchers(allowedEndpoints()).permitAll()
                        .requestMatchers(authenticatedEndpoints()).authenticated()
                        .anyRequest().authenticated());
        return http.build();
    }

    /**
     * Configure les règles CORS pour permettre à certaines origines d'envoyer des requêtes au serveur.
     *
     * @return l'objet CorsConfigurationSource configuré.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        List<String> allowedOriginsUrl = new ArrayList<>();
        allowedOriginsUrl.add(baseUrl);
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}