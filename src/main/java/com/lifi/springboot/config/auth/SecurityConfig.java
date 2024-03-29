package com.lifi.springboot.config.auth;

import com.lifi.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 설정들을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                // h2-console 화면을 사용하기 위해 해당 옵션들을 disable
                .and()
                    .authorizeRequests() // URL별 권한 관리를 설정하는 옵션의 시작점. antMatchers를 이용하기 위한 전제 조건
                    .antMatchers("/", "/css/**", "/images/**","/js/**", "/h2-console/**", "/profile")
                    // 권한 관리 대상을 지정하는 옵션
                    // URL, HTTP 메소드별 관리가 가능하다.
                    // "/" 등 지정된 URL들은 permitAll() 옵션을 통해 전체 열람 권한을 부여
                    // "/api/v1/**주소를 가진 API는 USER 권한을 가진 사람만 가능
                    .permitAll().antMatchers("/api/v1/**")
                    .hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                    // 설정된 값들 이외 나머지 URL들을 나타낸다.
                    // 여기서는 authenticated()를 추가하여 나머지 URL들은 모두 인증된 사용자들(로그인한 사람들)에게만 허용하게 한다.
                .and()
                    .logout().logoutSuccessUrl("/")
                    //로그 아웃 기능에 대한 여러 설정의 진입점입니다.
                    // 로그 아웃 시 / 주소로 이동
                .and()
                    .oauth2Login()
                    // OAuth 로그인 기능에 대한 여러 설정의 진입점입니다.
                    .userInfoEndpoint()
                    // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당합니다.
                    .userService(customOAuth2UserService);
                    // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록합니다.
                    // 리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있습니다.
    }

}
