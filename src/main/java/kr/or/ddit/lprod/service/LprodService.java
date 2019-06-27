package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

@Service
public class LprodService implements IlprodService {
	
	@Resource(name="lprodDao")
	private IlprodDao lprodDao;

	@Override
	public List<LprodVo> lprodList() {
		return lprodDao.lprodList();
	}

	@Override
	public LprodVo getId(String lprod_id) {
		return lprodDao.getId(lprod_id);
	}

	@Override
	public Map<String , Object> lprodPagingList(PageVo pageVo) {
		Map<String , Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lprodList", lprodDao.lprodPagingList(pageVo));
		int lprodCnt = lprodDao.lprodCnt();
		
		int paginationSize = (int) Math.ceil((double)lprodCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		return resultMap;
	}


}
