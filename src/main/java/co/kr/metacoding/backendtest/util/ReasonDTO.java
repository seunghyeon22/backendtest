package co.kr.metacoding.backendtest.util;

import lombok.AllArgsConstructor;
import lombok.Data;

// API를 호출할 때, 잘못된 요청이 들어오면 잘못된 요청에 대한 응답 DTO
@Data
@AllArgsConstructor
public class ReasonDTO {
    private String reason;
}
