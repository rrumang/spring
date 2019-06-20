package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.IboardDao;

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
		return boardDao.sayHello();
	}

	public IboardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(IboardDao boardDao) {
		this.boardDao = boardDao;
	}

	
	
}
