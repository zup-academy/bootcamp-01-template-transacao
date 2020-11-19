package dev.arielalvesdutra.transacao.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

import static org.springframework.http.HttpMethod.GET;


@Profile("!test")
@Configuration
public class SegurancaConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(GET, "/actuator/**").permitAll()
                .antMatchers(GET, "/api/cartoes/**").hasAuthority("SCOPE_cartoes:read")
                .anyRequest().authenticated()
                .and().oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
