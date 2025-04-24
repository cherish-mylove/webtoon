package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.model.Users;
import kr.ac.kopo.model.Webtoon;
import kr.ac.kopo.pager.Pager;
import kr.ac.kopo.service.UsersService;
import kr.ac.kopo.service.WebtoonService;

@Controller
@RequestMapping("/")
public class RootController {
	
	@Autowired
	UsersService service;
	
	@Autowired
	WebtoonService webtoonService;

	@GetMapping("/nav")
	String nav() {
		return "nav";
	}
	
	@GetMapping("/")
	String index(Model model) {
		List<Webtoon> list = webtoonService.list(new Pager());
		
		model.addAttribute("list", list);
		
		return "index";
	}
	
	@GetMapping("/login/{type}/popup")
	String loginPopup(@PathVariable String type) {
		return "login_popup";
	}
	
	@PostMapping("/login/{type}/popup")
	String loginPopup(@PathVariable String type, Users item, HttpSession session) {
		if(service.login(item)) {
			session.setAttribute("users", item);
			
			return "login_popup";
		} else {
			return "redirect:popup";
		}
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

	@PostMapping("/login")
	String login(Users item, HttpSession session) {
		if (service.login(item)) {
			List<Users> users = service.id(); // ���� ����
			
			session.setAttribute("item", users); // ���Ƿ� ����
			session.setAttribute("users", item);
			
			return "redirect:.";
		} else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:.";
	}
	
	@GetMapping("/signup2")
	String signup2() {
		return "signup2";
	}
	
	@PostMapping("/signup")
	String signup(Users item) {
		service.signup(item);
		
		return "redirect:.";
	}
	
	@ResponseBody
	@GetMapping("/id_check/{id}")
	String idCheck(@PathVariable String id) {
		
		if(service.isUnique(id))
			return "OK";
		
		return "FAIL";
	}
	
}
