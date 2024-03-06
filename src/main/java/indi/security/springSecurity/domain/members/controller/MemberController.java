package indi.security.springSecurity.domain.members.controller;

import indi.security.springSecurity.domain.members.dto.MemberDto;
import indi.security.springSecurity.domain.members.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/member/add")
    String postMemberAdd(@Valid @ModelAttribute("memberDto") MemberDto memberDto){
        memberService.save(memberDto);
        return "/home";
    }
    @GetMapping("/member/add")
    String getMemberAdd(){
        return "/memberAdd";
    }
    @GetMapping("/userPage")
    String userPage(){
        return "/userPage";
    }
}
