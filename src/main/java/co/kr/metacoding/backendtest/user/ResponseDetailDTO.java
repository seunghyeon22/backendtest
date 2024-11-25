package co.kr.metacoding.backendtest.user;

import lombok.Data;

@Data
public class ResponseDetailDTO {
    private int id;
    private String name;

    public ResponseDetailDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

}
