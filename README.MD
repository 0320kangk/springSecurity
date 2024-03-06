# Spring Security를 이용한 로그인 구현

+ 프로젝트 환경
  + springframework.boot: version '3.2.3'
  + java 17
  + Gradle
  + Dependencies
    + Spring-boot-starter-Web
    + Spring-boot-starter-Data-JPA
    + Spring-boot-starter-Sequrity
    + Spring-boot-starter-thymeleaf
    + thymeleaf-extras-springsecurity6
    + Lombok

+ 프로젝트 구조
  + ```
    ├─java
    │  └─indi
    │      └─security
    │          └─springSecurity
    │              │  SpringSecurityApplication.java
    │              │
    │              ├─domain
    │              │  ├─home
    │              │  │      HomeController.java
    │              │  │
    │              │  ├─login
    │              │  │      LoginController.java
    │              │  │
    │              │  └─members
    │              │      ├─controller
    │              │      │      MemberController.java
    │              │      │
    │              │      ├─domain
    │              │      │      Members.java
    │              │      │
    │              │      ├─dto
    │              │      │      MemberDto.java
    │              │      │      MembersUserDetails.java
    │              │      │
    │              │      ├─model
    │              │      │      Role.java
    │              │      │
    │              │      ├─repository
    │              │      │      MembersRepository.java
    │              │      │
    │              │      └─service
    │              │              MemberService.java
    │              │
    │              └─global
    │                      WebSecurityConfig.java
    │
    └─resources
    │  application-oauth.yml
    │  application.properties
    │  application.yml
    │
    ├─static
    │  └─css
    │      bootstrap.min.css
    │
    └─templates
          home.html
          loginForm.html
          memberAdd.html
          userPage.html
    ```