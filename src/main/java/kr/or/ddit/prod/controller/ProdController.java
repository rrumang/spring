package kr.or.ddit.prod.controller;

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
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.IprodService;

@RequestMapping("/prod")
@Controller
public class ProdController {
	private static final Logger logger = LoggerFactory.getLogger(ProdController.class);
	
	//리소스 어노테이션으로 주입받아놓고,
	@Resource(name="prodService")
	private IprodService prodService;
	
	@Resource(name="lprodService")
	private IlprodService lprodService;
	
	@RequestMapping("/pagingList")
	public String prodPagingList(PageVo pageVo, Model model) {
		Map<String, Object> resultMap = prodService.prodPagingList(pageVo);
		List<ProdVo> prodList = (List<ProdVo>) resultMap.get("prodList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		List<LprodVo> lprodList = lprodService.lprodList();
		
		model.addAttribute("prodList", prodList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("lprodList", lprodList);
		
		logger.debug("prodList : {}", prodList);
		
		return "prod/prodPagingList";
	}
}
