package co.kr.metacoding.backendtest.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RequestSaveDTO {
    @NotBlank(message = "이름을 입력해 주세요.")
    @Pattern(regexp = "^[A-za-z0-9]{6,20}$",
            message = "아이디는 영문 또는 숫자만 가능하며 6자 이상 20자 이내만 가능합니다.")
    private String name;

    public User toEntity() {
        User user = new User(null, name);
        return user;
    }
}
