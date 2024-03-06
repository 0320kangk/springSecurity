package indi.security.springSecurity.global;

import indi.security.springSecurity.domain.members.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class WebSecurityConfig  {

    //정적 리소스 검증 x
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
    // password 암호화
    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())

                .authorizeHttpRequests( request -> request.requestMatchers("/","/member/add", "/loginForm")
                        .permitAll()
                        .requestMatchers("/userPage" )
                        .hasRole(Role.USER.name())//앞에 ROLE_ 이 붙음
                )
               .formLogin( formLogin -> {
                    formLogin.loginPage("/loginForm")
                            .usernameParameter("loginId")
                            .passwordParameter("password")
                            .loginProcessingUrl("/login")
                            .successHandler(((request, response, authentication) -> {
                                log.info("로그인 완료되었습니다.");
                                response.sendRedirect("/");
                            }))
                            .failureHandler(((request, response, exception) -> {
                                log.info("로그인 실패 로그 : {}",exception.getMessage());
                            }));
                });
        http.logout( logout ->{
            logout.logoutUrl("/logout")
                    .logoutSuccessHandler( ((request, response, authentication) -> {
                        log.info("로그아웃 성공");
                        response.sendRedirect("/");
                    }));
        });
        return http.build();
    }

}
