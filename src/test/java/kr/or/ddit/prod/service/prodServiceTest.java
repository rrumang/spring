package kr.or.ddit.prod.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.testenv.LogicTestEnv;

public class prodServiceTest extends LogicTestEnv {
	
	@Resource(name="prodService")
	private IprodService prodService;
	
	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :prod페이지 리스트 조회 테스트
	 */
	@Test
	public void lprodPagingListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);

		/***When***/
		Map<String, Object> resultMap = prodService.prodPagingList(pageVo);
		List<ProdVo> prodList = (List<ProdVo>) resultMap.get("prodList");
		int paginationSize = (Integer) resultMap.get("paginationSize");

		/***Then***/
		assertNotNull(prodList);
		assertEquals(10, prodList.size());
	}

}
