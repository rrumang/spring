package kr.or.ddit.lprod.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.paging.model.PageVo;

@RequestMapping("/lprod")
@Controller
public class LprodController {
	private static final Logger logger = LoggerFactory.getLogger(LprodController.class);
	
	//리소스 어노테이션으로 주입받아놓고,
	@Resource(name="lprodService")
	private IlprodService lprodService;
	
	
	@RequestMapping("/pagingList")
	public String lprodPagingList(PageVo pageVo, Model model) {
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		model.addAttribute("lprodList", lprodList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("pageVo", pageVo);
		
		return "lprod/lprodPagingList";
	}
}
