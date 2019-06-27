package kr.or.ddit.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.util.PartUtil;

@RequestMapping("/user")
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
	@RequestMapping("/list")
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
	@RequestMapping("/PagingList")
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
	
	/**
	 * 
	* Method : user
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @param model
	* @return
	* Method 설명 : 사용자 상세 조회
	 */
	@RequestMapping("/user")
	public String user(String userId, Model model) {
		
		model.addAttribute("userVo", userService.getUser(userId));
		
		return "user/user";
	}
	
	/**
	 * 
	* Method : userForm
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 등록 화면
	 */
	@RequestMapping(path = "/form", method = RequestMethod.GET)
	public String userForm() {
		return "user/userForm";
	}
	
	/**
	 * 
	* Method : userForm
	* 작성자 : PC08
	* 변경이력 :
	* @param userVo
	* @param userId
	* @param profile
	* @param model
	* @return
	* Method 설명 : 사용자 등록
	 */
	@RequestMapping(path = "/form", method = RequestMethod.POST)
	public String userForm(UserVo userVo,String userId,MultipartFile profile, Model model) {
		
		logger.debug("userForm profile");
		String viewName="";
		
		UserVo dbUser = userService.getUser(userId);
		
		if(dbUser == null) {
			if(profile.getSize() > 0) {
				String filename = profile.getOriginalFilename();
				String ext = PartUtil.getExt(filename);
				
				String uploadPath = PartUtil.getUploadPath();
				String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				userVo.setPath(filePath);
				userVo.setFilename(filename);
				
				try {
					profile.transferTo(new File(filePath));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			//비밀번호 암호화
			userVo.setPass(KISA_SHA256.encrypt(userVo.getPass()));
			int insertCnt = userService.insertUser(userVo);
			
			if(insertCnt == 1)
				viewName = "redirect:/user/PagingList";
		}
		else {
			model.addAttribute("msg", "이미 존재하는 사용자입니다");
			viewName=userForm();
			return viewName;
		}
		return viewName;
	}
	
	/**
	 * 
	* Method : profile
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @param response
	* @param request
	* @throws IOException
	* Method 설명 : 사용자 사진 응답 생성
	 */
	@RequestMapping("/profile")
	public void profile(String userId, HttpServletResponse response, HttpServletRequest request) throws IOException {
			
			// 사용자 정보(path)를 조회
			UserVo userVo = userService.getUser(userId);

			// path정보로 file을 읽어서
			ServletOutputStream sos = response.getOutputStream();
			FileInputStream fis = null;
			String filePath = null;

			if (userVo.getPath() != null)
				filePath = userVo.getPath();
			// 사용자가 업로드한 파일이 존재하지 않을 경우 : no_image.gif
			else
				filePath = request.getServletContext().getRealPath("/img/no_image.gif");
			// webapp/img/no_image.gif

			File file = new File(filePath);
			fis = new FileInputStream(file);
			byte[] buffer = new byte[512];
			// response객체에 스트림으로 써준다.
			while (fis.read(buffer, 0, 512) != -1) {
				sos.write(buffer);
			}

			fis.close();
			sos.close();

	}
	
	/**
	 * 
	* Method : userModify
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @param model
	* @return
	* Method 설명 : 사용자 수정 화면 요청
	 */
	@RequestMapping(path = "/modify", method = RequestMethod.GET )
	public String userModify(String userId, Model model) {
		model.addAttribute("userVo", userService.getUser(userId));
		
		return "user/userModify";
	}
	
	//사용자 정보 수정
	@RequestMapping(path = "/modify", method = RequestMethod.POST)
	public String userModify(UserVo userVo, MultipartFile profile, HttpSession session, Model model) {
		//추후 ajax 요청으로 분리
		//userVo.setPass(KISA_SHA256.encrypt(userVo.getPass())); 
		
		if(profile.getSize() > 0) {
			String filename = profile.getOriginalFilename();
			String ext = PartUtil.getExt(filename);
			
			String uploadPath = PartUtil.getUploadPath();
			String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
			
			userVo.setPath(filePath);
			userVo.setFilename(filename);
			
			try {
				profile.transferTo(new File(filePath));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		logger.debug("userVo : {}", userVo);
		
		int updateCnt = userService.updateUser(userVo);
		
		if(updateCnt == 1) {
			session.setAttribute("msg", "등록되었습니다");
			return "redirect:/user/user?userId=" + userVo.getUserId();
		}
		else 
			return userModify(userVo.getUserId(), model);
	}
		
}








