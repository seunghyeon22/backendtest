package co.kr.metacoding.backendtest.user;

import co.kr.metacoding.backendtest.user.request.RequestSaveDTO;
import co.kr.metacoding.backendtest.user.request.RequsetUpdateDTO;
import co.kr.metacoding.backendtest.user.response.ResponseDetailDTO;
import co.kr.metacoding.backendtest.user.response.ResponseSaveDTO;
import co.kr.metacoding.backendtest.user.response.ResponseUpdateDTO;
import co.kr.metacoding.backendtest.util.ex.CustomException404;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //
    @Transactional
    public ResponseSaveDTO save(RequestSaveDTO requestSaveDTO){
        ResponseSaveDTO saveDto = new ResponseSaveDTO(userRepository.save(requestSaveDTO.toEntity()));
        return saveDto;
    }

    public ResponseDetailDTO detail(int id){
        return new ResponseDetailDTO(userRepository.findById(id).orElseThrow(()->new CustomException404("해당 ID가 없습니다.")));
    }

    @Transactional
    public ResponseUpdateDTO update(int id, RequsetUpdateDTO requsetUpdateDTO){
        User user = userRepository.findById(id).orElseThrow(()->new CustomException404("해당 ID가 없습니다."));
        ResponseUpdateDTO updateDTO = new ResponseUpdateDTO(user.update(requsetUpdateDTO.getName()));
        return updateDTO;
    }
}
