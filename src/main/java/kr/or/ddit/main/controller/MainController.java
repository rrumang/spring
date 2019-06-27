package kr.or.ddit.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.main.model.MainVo;
import kr.or.ddit.user.model.UserVo;

/*
	servlet
	 - extends HttpServlet
	 - servlet-mapping (web.xml, @WebServlet)
	 - service ==> doXXX
	 
	spring
	 - pojo(Plain Old Java Object), @Controller  
	 - @RequestMapping(class, method)
	 - @RequestMapping에 설정한 url  method 호출
*/

@Controller
@SessionAttributes("rangers")
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	//메소드에 적용된 @ModelAttribute
	//@RequestMapping이 붙은 메소드가 실행될때(요청이 처리될때)
	//@ModelAttribute가 적용된 메소드가 리턴하는 값을 Model객체에 자동적으로 넣어준다
	//localhost/main ==> @RequestMapping("/main") : mainView ==> Model(rangers) 
	//localhost/mainMav ==> @RequestMapping("/mainMav") : mainView ==> Model(rangers) 
	
	@ModelAttribute("rangers")
	public List<String> rangers(){
		logger.debug("{}", "rangers()");
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
		
		return rangers;
	}
	
	/**
	 * 
	* Method : mainView
	* 작성자 : PC08
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 :메인페이지 요청(viewName)
	 */
	@RequestMapping("/main")
	public String mainView(Model model, @ModelAttribute("userVo")UserVo userVo) {
		
		logger.debug("mainView");
		logger.debug("model.asMap().get(\"rangers\") : {}", model.asMap().get("rangers"));
		logger.debug("userVo : {}", userVo);
		
//		UserVo userVo = new UserVo();
//		userVo.setName("브라운");
//		model.addAttribute("userVo", userVo);
		
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		
		// prefix + viewName + suffix
		// /WEB-INF/views/main.jsp
		
		//아래 문장은 다음과 동일하다
		//request.setAttribute("mainUerId", "brown");
		//request.setAttribute("mainUesrId", "brown");
		model.addAttribute("mainUserId", "brown");
		
		//viewName
		return "main";
	}
	
	/**
	 * 
	* Method : mainViewMav
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : main페이지 요청 (modelAndView사용)
	 */
	@RequestMapping("/mainMav")
	public ModelAndView mainViewMav(@ModelAttribute("rangers") List<String> rangers) {
		logger.debug("mainView : {}", rangers);
		//viewName을 기반으로 ModelAndView 객체를 생성
		ModelAndView mav = new ModelAndView("main");
		//mav.setViewName("otherMain"); 다른걸로 바꿔줄수도 있음
		
		//위 문장은 아래 두문장과 같다
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("main")
		
		
		//model.addAttribute("mainUserId", "brown");
		mav.addObject("mainUserId", "brown");
		
		//viewName
		return mav;
	}
	
	/**
	 * 
	* Method : pathvariable
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : pathvariable로 부터 사용자 아이디 가져오기(ex: 도서관사업소)
	 */
	//localhost/main/pathvariable/brown
	//localhost/main/pathvariable/sally
	@RequestMapping("/main/pathvariable/{userId}")
	public String pathvariable(@PathVariable("userId") String userId) {
		logger.debug("userId : {}", userId);
		return "main";
	}
	
	/**
	 * 
	* Method : header
	* 작성자 : PC08
	* 변경이력 :
	* @param accept
	* @return
	* Method 설명 : Accept 헤더 정보 가져오기
	 */
	@RequestMapping("/main/header")
	public String header(@RequestHeader(name = "Accept"/*, required = false*/) String accept) {
		logger.debug("Accept : {}", accept);
		return "main";
	}
	
	@RequestMapping("/main/view")
	public String view() {
		return "view";
	}
	
	@RequestMapping("/main/process")
	public String process(HttpServletRequest request, String[] userId, //파라미터 이름과 일치하면 바인딩되어 가져올수 있다
							@RequestParam("userId") List<String> userIdList, //파라미터명이 다르면 리퀘스트파람을 이용하여 가져올수있다
							@RequestParam("name") List<String> name, //List<>타입의 경우 @RequestParam 적용해야 한다
							MainVo mainVo) { //vo안에서도 필드명이 동일하면 가져올 수 있다
		
		String[] userIdArr = request.getParameterValues("userId");
		
		String userIdParameter = request.getParameter("userId");
		logger.debug("userIdParameter : {}", userIdParameter);
		
		logger.debug("request.getParameterValues(\"userId\")");
		for(String u : userIdArr) 
			logger.debug("userId : {}", u);
		
		logger.debug("String[]userId");
		for(String u : userId)
			logger.debug("userId : {}", u);
		
		logger.debug("userIdList");
		for(String u : userIdList)
			logger.debug("userId : {}", u);
		
		logger.debug("mainVo : {}", mainVo);
		
		return "main";
	}
}












