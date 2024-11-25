package co.kr.metacoding.backendtest.util;

import co.kr.metacoding.backendtest.util.ex.CustomException400;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.naming.Binding;

@Aspect
@Component
public class ValidationAdvice {

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void validate(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for(Object arg : args) {
            if(arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if(bindingResult.hasErrors()) {
                    String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
                    throw new CustomException400(errorMessage);
                }
            }
        }
    }
}
