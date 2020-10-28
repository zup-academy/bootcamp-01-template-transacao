package com.marcoscoutozup.transacao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

import static org.springframework.http.HttpMethod.GET;

@Configuration
public class SegurancaConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(GET, "/actuator/prometheus").permitAll()
                .antMatchers(GET, "/transacoes/**").hasAuthority("SCOPE_transacoes")
                .anyRequest().hasAuthority("SCOPE_admin")
                .and()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }

}
