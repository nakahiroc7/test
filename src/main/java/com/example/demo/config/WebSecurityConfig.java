package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        // セキュリティ設定を無視するリクエスト設定
	        // 静的リソース(api)に対するアクセスはセキュリティ設定を無視する（ずるずるだが・・・）
	        web.ignoring().antMatchers(
	                            "/api/**");
	    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/login", "/login-error").permitAll()
                .antMatchers("/**").hasRole("USER")
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/menu.html")
                .failureUrl("/login-error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("nakagawa").password("nakapass").roles("USER");
        auth
        .inMemoryAuthentication()
            .withUser("admin").password("adpass").roles("USER");
        }

}