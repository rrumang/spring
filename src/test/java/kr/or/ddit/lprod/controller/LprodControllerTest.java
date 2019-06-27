package kr.or.ddit.lprod.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.UserVo;

public class LprodControllerTest extends ControllerTestEnv {

	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회
	 * @throws Exception 
	 */
	@Test
	public void lprodPagingListTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/lprod/pagingList")
											.param("page", "2")
											.param("pageSize", "10"))
									 .andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<LprodVo> lprodList = (List<LprodVo>) mav.getModelMap().get("lprodList");
		int paginationSize = (Integer) mav.getModelMap().get("paginationSize");
		PageVo pageVo = (PageVo) mav.getModelMap().get("pageVo");
		
		/***Then***/
		//viewName
		assertEquals("lprod/lprodPagingList", viewName);
		assertEquals(2, lprodList.size());
		assertEquals(2, pageVo.getPage());
		assertEquals(10, pageVo.getPageSize());
		
	}
	
	/**
	 * 
	* Method : userPagingListWithoutParameterTest
	* 작성자 : PC08
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 페이징 리스트 테스트(page, pageSize 파라미터 없이 호출)
	 */
	@Test
	public void userPagingListWithoutParameterTest() throws Exception {
		/***Given***/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/lprod/pagingList"))
									 .andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<LprodVo> userList = (List<LprodVo>) mav.getModelMap().get("lprodList");
		int paginationSize = (Integer) mav.getModelMap().get("paginationSize");
		PageVo pageVo = (PageVo) mav.getModelMap().get("pageVo");
		
		/***Then***/
		//viewName
		//속성 userList, paginationSize,pageVo
		assertEquals("lprod/lprodPagingList", viewName);
		assertEquals(10, userList.size());
		assertEquals(2, paginationSize);
		
		//PageVo equals, hashCode 메소드를 구현해서 객체간 값 비교
		assertEquals(new PageVo(1, 10), pageVo);
		
//		assertEquals(1, pageVo.getPage());
//		assertEquals(10, pageVo.getPageSize());
		
	}

}
