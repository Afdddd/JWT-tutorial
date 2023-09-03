package me.afdddd.jwtbasic.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    public void configure(WebSecurity web){
        web
                .ignoring()
                .antMatchers( // h2-console 하위 와 파비콘에 대한 모든 요청을 무시.
                        "/h2-console/**"
                        ,"/favicon.ico"
                );

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // HttpServletRequest 를 사용하는 요청에 대한 접근제한을 설정
                .antMatchers("/api/hello").permitAll() // /api/hello 에 대한 요청은 인증없이 접근을 허용
                .anyRequest().authenticated(); // 나머지 요청들은 모두 인증

    }



}
