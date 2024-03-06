package indi.security.springSecurity.domain.members.service;

import indi.security.springSecurity.domain.members.dto.MembersUserDetails;
import indi.security.springSecurity.domain.members.model.Role;
import indi.security.springSecurity.domain.members.domain.Members;
import indi.security.springSecurity.domain.members.dto.MemberDto;
import indi.security.springSecurity.domain.members.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService implements UserDetailsService {
    private final MembersRepository membersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Members> byLoginId = membersRepository.findByLoginId(username);
        if (byLoginId.isPresent()){
            log.info("아이디 찾기 성공");
            Members members = byLoginId.get();
            List<GrantedAuthority> authorities = new ArrayList();
            /*return User.builder()
                    .username(members.getLoginId())
                    .password(members.getPassword())
                    .roles(members.getRole().toString())
                    .build();*/
            return new MembersUserDetails(members);
        }
        return null;
    }
    @Transactional
    public void save(MemberDto memberDto){
        Members member = Members.builder()
                .loginId(memberDto.getLoginId())
                .password( passwordEncoder.encode(memberDto.getPassword()))
                .role(Role.USER)
                .build();
        membersRepository.save(member);
    }

}
