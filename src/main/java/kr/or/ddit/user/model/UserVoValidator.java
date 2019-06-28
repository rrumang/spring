package kr.or.ddit.user.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserVoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) { // 1.검증당할객체. 2 에러메세지를 담을녀석
		//데이터 검증
		UserVo userVo = (UserVo)target;
		
		//사용자 아이디 길이 4글자 이상
		if(userVo.getUserId().length() <= 3)
			errors.rejectValue("userId", "length");
		
		//사용자 이름이 2글자 이상
		if(userVo.getName().length() <= 2)
			errors.rejectValue("name", "length");// 에러코드는 개발자가 정의하는것 정해진건 아님
		
	}

}
