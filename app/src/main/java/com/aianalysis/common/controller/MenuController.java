package com.aianalysis.common.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aianalysis.common.model.MenuPageResponse;
import com.aianalysis.common.model.MenuVO;
import com.aianalysis.common.service.MbrService;
import com.aianalysis.common.service.MenuService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MenuController {
	@Autowired
	public MbrService mbrService;
	
	@Autowired
	public MenuService ms;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@RequestMapping(value="/api/menuform", method= {RequestMethod.GET, RequestMethod.POST})
	public int MenuForm(@RequestBody MenuVO mv, HttpSession session) {
		String emlAddr = (String) session.getAttribute("email");
		
		return ms.saveMenu(mv,emlAddr);
	}
	
	@RequestMapping(value="/api/menulist", method= {RequestMethod.GET, RequestMethod.POST})
	public int MenuList() {
		return ms.getMenuList().size();
	}
	
	@RequestMapping(value="/api/menupagelist", method= {RequestMethod.GET, RequestMethod.POST})
	public MenuPageResponse MenuPageList(@RequestBody Map<String, Integer> params) {
		return new MenuPageResponse(ms.getMenuPageList(params),ms.getMenuList().size());
	}
	
	
	@RequestMapping(value="/api/menudelete", method= {RequestMethod.GET, RequestMethod.POST})
	public int delete(@RequestBody MenuVO mv) {
		
		return ms.deleteMenu(mv.getNo());
	}
	@RequestMapping(value="/api/menuupdate", method= {RequestMethod.GET, RequestMethod.POST})
	public int update(@RequestBody MenuVO mv,HttpSession session) {
		String emlAddr = (String) session.getAttribute("email");;
		
		return ms.updateMenu(mv,emlAddr);
	}
	
	@RequestMapping(value="/api/getmenu", method= {RequestMethod.GET, RequestMethod.POST})
	public MenuVO getMenu(@RequestBody MenuVO mv) {
		
		return ms.getMenu(mv.getNo());
	}
	
	@GetMapping("/api/menu/header")
	public List<MenuVO> MenuGrdIndex(HttpSession session,HttpServletRequest request) {
		List<MenuVO> list;
		
		if(session.getAttribute("email") != null) {
			int grade = (int) session.getAttribute("grade");
			list = ms.getMenuGrdList(grade);
		}else {
			list = ms.getMenuGrdList(1);
		}
		
		return list;
	}
	

}