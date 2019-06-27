package kr.or.ddit.lprod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

@Repository
public class LprodDao implements IlprodDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 
	* Method : lprodList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : lprod전체 조회
	 */
	@Override
	public List<LprodVo> lprodList() {
		return sqlSession.selectList("lprod.lprodList");
	}
	
	/**
	 * 
	* Method : getId
	* 작성자 : PC08
	* 변경이력 :
	* @param lprod_id
	* @return
	* Method 설명 : 특정 id조회
	 */
	@Override
	public LprodVo getId(String lprod_id) {
		return sqlSession.selectOne("lprod.getId", lprod_id);
	}

	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :lprod페이지 리스트 조회
	 */
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		return sqlSession.selectList("lprod.lprodPagingList", pageVo);
	}
	
	/**
	 * 
	* Method : lprodCnt
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체수 조회
	 */
	@Override
	public int lprodCnt() {
		return sqlSession.selectOne("lprod.lprodCnt");
	}
	
}
