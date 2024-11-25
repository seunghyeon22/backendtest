package co.kr.metacoding.backendtest.user.response;

import co.kr.metacoding.backendtest.user.User;
import lombok.Data;

@Data
public class ResponseSaveDTO {
    private int id;

    public ResponseSaveDTO(User user) {
        this.id = user.getId();
    }
}
