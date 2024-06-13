package roomescape.service.login.dto;

import jakarta.validation.constraints.NotBlank;
import roomescape.domain.member.Member;
import roomescape.domain.member.MemberEmail;
import roomescape.domain.member.MemberName;
import roomescape.domain.member.MemberPassword;
import roomescape.domain.member.MemberRole;
import roomescape.exception.common.InvalidRequestBodyException;

public class SignupRequest {
    @NotBlank(message = "이메일을 입력해주세요.")
    private final String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private final String password;

    @NotBlank(message = "이름을 입력해주세요.")
    private final String name;

    public SignupRequest(String email, String password, String name) {
        validate(email, password, name);
        this.email = email;
        this.password = password;
        this.name = name;
    }

    private void validate(String email, String password, String name) {
        if (email == null || email.isBlank() ||
                password == null || password.isBlank() ||
                name == null || name.isBlank()) {
            throw new InvalidRequestBodyException();
        }
    }

    public Member toMember(MemberRole role) {
        return new Member(
                new MemberName(name),
                new MemberEmail(email),
                new MemberPassword(password),
                role
        );
    }

    public MemberEmail toMemberEmail() {
        return new MemberEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
