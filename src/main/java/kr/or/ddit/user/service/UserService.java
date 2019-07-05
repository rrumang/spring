package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.model.UserVo;

@Transactional
@Service
public class UserService implements IuserService {

	@Resource(name="userDao")
	private IuserDao userDao;
	
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 리스트 조회
	 */
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}

	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 유저 등록
	 */
	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 유저 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	 */
	@Override
	public UserVo getUser(String userId) {
		return userDao.getUser(userId);
	}

	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 :사용자 전체수 조회
	 */
	@Override
	public int usersCnt() {
		return userDao.usersCnt();
	}

	/**
	 * 
	* Method : updateUser
	* 작성자 : PC08
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 사용자 정보 수정
	 */
	@Override
	public int updateUser(UserVo vo) {
		return userDao.updateUser(vo);
	}

	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userDao.userPagingList(pageVo));
		int usersCnt = userDao.usersCnt();
		
		int paginationSize = (int) Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		return resultMap;
	}

	/**
	 * 
	* Method : userListForPassEncrypt
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 비밀번호 암호화 적용대상 사용자 전체 조회
	 */
	@Override
	public List<UserVo> userListForPassEncrypt(SqlSession sqlSession) {
		return userDao.userListForPassEncrypt(sqlSession);
	}

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
	@Override
	public int updateUserEncryptPass(SqlSession sqlSession, UserVo userVo) {
		return userDao.updateUserEncryptPass(sqlSession, userVo);
	}

}
