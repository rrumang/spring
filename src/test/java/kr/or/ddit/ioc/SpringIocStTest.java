package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-st.xml")
public class SpringIocStTest {
	
	@Resource(name="boardService")
	private IboardService boardService;
	
	@Resource(name="bDao")
	private IboardDao boardDao;

	@Test
	public void test() {
		/***Given***/

		/***When***/
		
		/***Then***/
		assertEquals(boardDao, boardService.getBoardDao());
	}

}
