package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;

public class LprodServiceTest extends LogicTestEnv {

	@Resource(name="lprodService")
	private IlprodService lprodService;
	
	/**
	 * 
	* Method : lprodList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : lprod전체 조회 테스트
	 */
	@Test
	public void lprodListTest() {
		/***Given***/

		/***When***/
		List<LprodVo> lprodList = lprodService.lprodList();

		/***Then***/
		assertNotNull(lprodList);
		assertTrue(lprodList.size() >= 10);
		assertEquals(12, lprodList.size());
	}
	
	/**
	 * 
	* Method : getId
	* 작성자 : PC08
	* 변경이력 :
	* @param lprod_id
	* @return
	* Method 설명 : 특정 id조회 테스트
	 */
	@Test
	public void getIdTest() {
		/***Given***/
		String lprod_id ="1";

		/***When***/
		LprodVo lprodVo = lprodService.getId(lprod_id);

		/***Then***/
		assertEquals("컴퓨터제품", lprodVo.getLprod_nm());
	}
	
	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :lprod페이지 리스트 조회 테스트
	 */
	@Test
	public void lprodPagingListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);

		/***When***/
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (Integer) resultMap.get("paginationSize");

		/***Then***/
		assertNotNull(lprodList);
		assertEquals(10, lprodList.size());
	}
	
}
