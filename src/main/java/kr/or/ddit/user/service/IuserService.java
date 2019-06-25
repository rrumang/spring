package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserService {
	/**
	 * 
	* Method : userList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	 */
	List<UserVo> userList();
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 유저 등록
	 */
	int insertUser(UserVo userVo);
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 유저 삭제
	 */
	int deleteUser(String userId);
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	 */
	UserVo getUser(String userId);
	
	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 :사용자 전체수 조회
	 */
	public int usersCnt();
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : PC08
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 사용자 정보 수정
	 */
	public int updateUser(UserVo vo);
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	public Map<String, Object> userPagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : userListForPassEncrypt
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 비밀번호 암호화 적용대상 사용자 전체 조회
	 */
	public List<UserVo> userListForPassEncrypt(SqlSession sqlSession);
	
	/**
	 * 
	* Method : updateUserEncryptPass
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 적용
	 */
	public int updateUserEncryptPass(SqlSession sqlSession, UserVo userVo);
}
