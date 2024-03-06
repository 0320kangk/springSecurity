package indi.security.springSecurity.domain.members.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;
}
