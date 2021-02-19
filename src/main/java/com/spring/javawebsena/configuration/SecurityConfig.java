package com.spring.javawebsena.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementsUserDetailsService UserDetailsService;
	
    private static final String[] AUTH_LIST = {
            "/",
            "/simulador",
            "/simulador/{id}"
        };
	

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.csrf().disable().authorizeRequests()
                    .antMatchers(AUTH_LIST).permitAll() // Lista de URI's podem ser acessadas sem autenticação
                    .anyRequest().authenticated()		// Todas as outras URI's precisam de autenticação
                    .and().formLogin().permitAll()		// Formulario padrão de Login do spring
                    .and().logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/simulador");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception{
            auth.userDetailsService(UserDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
        }        
        
        @Override
        public void configure(WebSecurity web) throws Exception{
            web.ignoring().antMatchers("/bootstrap/**");
//            web.ignoring().antMatchers("/bootstrap/**", "/style/**");
        }

}
