package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;

public interface IprodDao {
	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :lprod페이지 리스트 조회
	 */
	public List<ProdVo> prodPagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : lprodCnt
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체수 조회
	 */
	public int prodCnt();
}
