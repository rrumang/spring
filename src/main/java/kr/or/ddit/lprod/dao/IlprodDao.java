package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

public interface IlprodDao {
	/**
	 * 
	* Method : lprodList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : lprod전체 조회
	 */
	List<LprodVo> lprodList();
	
	/**
	 * 
	* Method : getId
	* 작성자 : PC08
	* 변경이력 :
	* @param lprod_id
	* @return
	* Method 설명 : 특정 id조회
	 */
	LprodVo getId(String lprod_id);
	
	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :lprod페이지 리스트 조회
	 */
	List<LprodVo> lprodPagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : lprodCnt
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체수 조회
	 */
	int lprodCnt();
}
