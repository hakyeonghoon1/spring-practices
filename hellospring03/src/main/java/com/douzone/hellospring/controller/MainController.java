package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@ResponseBody
	@RequestMapping({"","/main","/main/a/b/c/d"})	//복수 매핑 가능
	public String main() {
		return "MainController.main()";
	}
	
	@ResponseBody
	@RequestMapping("/main/delete")	//복수 매핑 가능
	public String delete() {
		return "MainController.delete()";
	}
}
