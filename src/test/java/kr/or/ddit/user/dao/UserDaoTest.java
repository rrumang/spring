package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;


public class UserDaoTest extends LogicTestEnv {
	
	@Resource(name="userDao")
	private IuserDao userDao;
	
	/**
	 * 
	* Method : test
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회 테스트
	 */
	@Test
	public void userListTest() {
		/***Given***/
		/***When***/
		List<UserVo> userList = userDao.userList();

		/***Then***/
		assertNotNull(userList);
		assertTrue(userList.size() >= 100);
		assertEquals(112, userList.size());
	}
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 */
	@Test
	public void insertUserTest() throws ParseException{
		/***Given***/
		//사용자정보를 담고있는 vo객체 준비
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = new UserVo("대덕쓰111", "userTest",  "중앙쓰", "userTest1234", "영민쓰", "204호", "34940", sdf.parse("2019-05-31"));

		/***When***/
		//userDao.insertUser()
		int insertCnt = userDao.insertUser(userVo);

		/***Then***/
		//insertCnt(1)
		assertEquals(1, insertCnt);
		
		//data삭제
		//useDao.deleteUser(userId);
		userDao.deleteUser(userVo.getUserId());
	}
	
	/**
	 * 
	* Method : getUserTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 :사용자 정보조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId ="brown";

		/***When***/
		UserVo userVo = userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getName());
		assertEquals("곰", userVo.getAlias());
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
	@Test
	public void updateUserTest() throws ParseException {
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = new UserVo("대덕쓰", "brown",  "중앙쓰", "userTest1234", "영민쓰", "204호", "34940", sdf.parse("2019-05-31"));

		/***When***/
		int updateCnt = userDao.updateUser(userVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 :사용자 전체수 조회
	 */
	@Test
	public void usersCntTest() {
		/***Given***/
		/***When***/
		int userCnt = userDao.usersCnt();

		/***Then***/
		assertEquals(112, userCnt);
	}
	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Test
	public void userPagingListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		List<UserVo> userList = userDao.userPagingList(pageVo);

		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
	}
	
	
	
	

}
