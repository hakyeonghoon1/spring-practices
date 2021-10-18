package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("")
	public String main(Model model) {
		
		List<GuestbookVo> list = guestbookRepository.findList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no, String password, GuestbookVo vo ) {
		//System.out.println("no="+no+" : password="+password);
//		GuestbookVo vo = new GuestbookVo();
//		vo.setNo(no);
//		vo.setPassword(password);
		System.out.println(vo);
		guestbookRepository.delete(vo);
		return "redirect:/";
	}
}
