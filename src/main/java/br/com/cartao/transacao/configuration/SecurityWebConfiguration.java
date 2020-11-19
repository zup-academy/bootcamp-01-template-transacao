package br.com.cartao.transacao.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityWebConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/v1/transacoes/**").hasAuthority("SCOPE_transacao:write")
                .antMatchers(HttpMethod.GET, "/v1/transacoes/**").hasAuthority("SCOPE_transacao:read")
                .antMatchers(HttpMethod.GET, "/v1/transacoes/**").hasAuthority("SCOPE_transacao:write")
                .anyRequest().authenticated()
                .and()
                    .csrf().disable()
                    .httpBasic().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .oauth2ResourceServer().jwt();
    }
}
