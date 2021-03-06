package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.board.dao.IboardDao;

@Transactional
@Service
public class BoardService implements IboardService {
	
	//property or field
	@Resource(name="boardDao")
	private IboardDao boardDao;
	
	public BoardService() {
		
	}
	
	public BoardService(IboardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public String sayHello() {
//		for (long i = 0; i < 2000000000; i++) {
//			i++;
//		}
		return boardDao.sayHello();
	}

	public IboardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(IboardDao boardDao) {
		this.boardDao = boardDao;
	}

	
	
}
