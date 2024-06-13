package roomescape.service.login.dto;

import jakarta.validation.constraints.NotBlank;
import roomescape.domain.member.MemberEmail;
import roomescape.domain.member.MemberPassword;

public class LoginRequest {
    @NotBlank(message = "이메일을 입력해주세요.")
    private final String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private final String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public MemberEmail toMemberEmail() {
        return new MemberEmail(email);
    }

    public MemberPassword toMemberPassword() {
        return new MemberPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
