package kr.or.ddit.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IboardService;

//spring bean임을 알려주는 설정
@Configuration
public class ApplicationIocConfig {
	
	//<bean id="boardDao" class="kr.or.ddit.board.dao.BoardDao"/>
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}
	
	/*<bean id="boardService" class="kr.or.ddit.board.service.BoardService">
	<!-- boardService의 field, property  -->
	<!--setter injection  -->
	<property name="boardDao" ref="boardDao"></property>
	</bean>*/
	@Bean
	public BoardService boardService() {
		BoardService boardService = new BoardService();
		//boardService.setName("brown");
		boardService.setBoardDao(boardDao());
		return boardService;
	}
	
}
