package kr.or.ddit.user.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//리소스 어노테이션으로 주입받아놓고,
	@Resource(name="userService")
	private IuserService userService;
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC08
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : 사용자 전체리스트
	 */
	//doget메서드를 대신할 메서드
	@RequestMapping("/userList")
	public String userList(Model model) {
		model.addAttribute("userList", userService.userList());
		
		return "user/userList";
	}
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 페이징 리스트
	 */
	@RequestMapping("/userPagingList")
//	public String userPagingList(@RequestParam(name="page",defaultValue = "1") int page,
//								 @RequestParam(name="pageSize", defaultValue = "10") int pageSize,
//								 Model model) {
//		
//		PageVo pageVo = new PageVo(page, pageSize);
	
	public String userPagingList(PageVo pageVo, Model model) {
		
		logger.debug("pageVo : {}", pageVo);
		
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		model.addAttribute("userList", userList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("pageVo", pageVo);
		
		return "user/userPagingList";
	}
	
	
}
