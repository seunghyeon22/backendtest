package co.kr.metacoding.backendtest.user;

import co.kr.metacoding.backendtest.user.request.RequestSaveDTO;
import co.kr.metacoding.backendtest.user.request.RequsetUpdateDTO;
import co.kr.metacoding.backendtest.user.response.ResponseDetailDTO;
import co.kr.metacoding.backendtest.user.response.ResponseSaveDTO;
import co.kr.metacoding.backendtest.user.response.ResponseUpdateDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseSaveDTO userSave(@Valid @RequestBody RequestSaveDTO requestSaveDTO, BindingResult bindingResult) {
        return userService.save(requestSaveDTO);
    }

    @GetMapping("/users/{id}")
    public ResponseDetailDTO findById(@PathVariable int id) {
        return userService.detail(id);
    }
    //
    @PutMapping("/users/{id}")
    public ResponseUpdateDTO update(@PathVariable int id, @Valid @RequestBody RequsetUpdateDTO requsetUpdateDTO, BindingResult bindingResult) {
        return userService.update(id, requsetUpdateDTO);
    }
}
