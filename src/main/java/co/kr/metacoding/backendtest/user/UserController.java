package co.kr.metacoding.backendtest.user;

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
}
