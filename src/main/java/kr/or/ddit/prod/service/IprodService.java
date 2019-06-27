package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;

public interface IprodService {
	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :lprod페이지 리스트 조회
	 */
	public Map<String , Object> prodPagingList(PageVo pageVo);
}
