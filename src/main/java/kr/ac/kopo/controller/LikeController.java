package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.model.Like;
import kr.ac.kopo.model.Users;
import kr.ac.kopo.model.Webtoon;
import kr.ac.kopo.service.WebtoonService;

@Controller
@RequestMapping("/like")
public class LikeController {
	
	@Autowired
	WebtoonService service;
	
	@GetMapping
	String like(@SessionAttribute(required=false) Like like, Model model) {		
		if(like == null)
			like = new Like(); 
			
		List<Webtoon> list = service.list(like.getLike().keySet() );
		
		model.addAttribute("list", list);
		
		return "like";
	}
	
	@ResponseBody
	@GetMapping("/{webtoonId}/{amount}")
	Like add(@PathVariable Long webtoonId, @PathVariable int amount, @SessionAttribute Users users, 
			 @SessionAttribute(required=false) Like like, HttpSession session) {
		if(like == null) {
			like = new Like();
				System.out.println(webtoonId);
			 session.setAttribute("like", like);
		}
		
		like.setLike(webtoonId, amount);
		
		return like;
	}
	
	@ResponseBody
	@DeleteMapping("/{webtoonId}")
	void delete(@PathVariable Long productId, @SessionAttribute Like like) {
		like.delete(productId);
	}
}
