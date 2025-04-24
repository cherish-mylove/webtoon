package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.model.Users;
import kr.ac.kopo.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	final String path = "users/";

	@Autowired
	UsersService service;

	@GetMapping("/list")
	String list(Model model) {
		List<Users> list = service.list();

		model.addAttribute("list", list);

		return path + "list";
	}

	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Users item) {
		service.add(item);
		
		return "redirect:list";
	}

	
	
	@GetMapping("/delete/{id}")
	String delete(@PathVariable String id) {
		service.delete(id);

		return "redirect:../list";
	}

	@GetMapping("/update/{id}")
	String update(@PathVariable String id, Model model) {
		Users item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{id}")
	String update(@PathVariable String id, Users item) {
		item.setId(id);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@ResponseBody
	@DeleteMapping("/{webtoonId}")
	void delete(@PathVariable Long webtoonId, @SessionAttribute Users users) {
		System.out.println(webtoonId);
		users.delete(webtoonId);
	}
}
