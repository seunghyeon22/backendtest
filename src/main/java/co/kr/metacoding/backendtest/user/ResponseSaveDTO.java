package co.kr.metacoding.backendtest.user;

import lombok.Data;

@Data
public class ResponseSaveDTO {
    private int id;

    public ResponseSaveDTO(User user) {
        this.id = user.getId();
    }
}
