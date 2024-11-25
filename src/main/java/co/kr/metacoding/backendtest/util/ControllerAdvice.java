package co.kr.metacoding.backendtest.util;


import co.kr.metacoding.backendtest.util.ex.CustomException400;
import co.kr.metacoding.backendtest.util.ex.CustomException404;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(CustomException400.class)
    public ResponseEntity<ReasonDTO> exception400(CustomException400 ex) {
        return new ResponseEntity<>(new ReasonDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomException404.class)
    public ResponseEntity<ReasonDTO> exception404(CustomException404 ex) {
        return new ResponseEntity<>(new ReasonDTO(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
