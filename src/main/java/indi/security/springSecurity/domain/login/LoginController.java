package indi.security.springSecurity.domain.login;

import indi.security.springSecurity.domain.members.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    @GetMapping("/loginForm")
    public String getLogin(@ModelAttribute("memberDto") MemberDto memberDto){
        return "/loginForm";
    }
}
