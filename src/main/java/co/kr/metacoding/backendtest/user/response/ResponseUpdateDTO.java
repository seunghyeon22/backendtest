package co.kr.metacoding.backendtest.user.response;

import co.kr.metacoding.backendtest.user.User;
import lombok.Data;

@Data
public class ResponseUpdateDTO {
    private int id;
    private String name;

    public ResponseUpdateDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
