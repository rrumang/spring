package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.testenv.LogicTestEnv;

public class prodDaoTest extends LogicTestEnv {
	@Resource(name="prodDao")
	private IprodDao prodDao;
	
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
	public void prodPagingListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);

		/***When***/
		List<ProdVo> prodList = prodDao.prodPagingList(pageVo);

		/***Then***/
		assertNotNull(prodList);
		assertEquals(10, prodList.size());
	}
	
	@Test
	public void prodCntTest() {
		/***Given***/

		/***When***/
		int prodCnt = prodDao.prodCnt();

		/***Then***/
		assertEquals(74, prodCnt);
	}

}
