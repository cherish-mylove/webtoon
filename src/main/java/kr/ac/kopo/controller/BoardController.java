package kr.ac.kopo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.model.Board;
import kr.ac.kopo.model.Photo;
import kr.ac.kopo.model.Users;
import kr.ac.kopo.pager.Pager;
import kr.ac.kopo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	final String path = "board/";
	final String uploadPath = "d:/project/";
	
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	String list(Model model, Pager pager) { 
		List<Board> list = service.list(pager);
//		List<Board> all = service.all();
		
		System.out.println("게시판 확인" + list);
		
		model.addAttribute("list", list);
//		model.addAttribute("all", all); 이거 값 왜 못 받아오냐? 이해가 안 되네
		
		return path + "list";
	}
	
	@GetMapping("/admin")
	String admin(Model model, Pager pager) {
		List<Board> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "admin";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(@Valid Board item, BindingResult bindingResult, List<MultipartFile> uploadFile, @SessionAttribute Users users) {
		List<Photo> photos = new ArrayList<Photo>();
		
		for(MultipartFile file : uploadFile) {
			if(file != null && !file.isEmpty()) {
				String filename = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
				
				try {
					file.transferTo(new File(uploadPath + uuid + "_" + filename));
					
					Photo photo = new Photo();
					photo.setFilename(filename);
					photo.setUuid(uuid);
					
					photos.add(photo);
									
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		item.setPhoto(photos);
		
		item.setRegId(users.getId());
		
		if(bindingResult.hasErrors())
			return path + "valid/add";
		
		System.out.println("item 확인" + item);
		service.add(item);
		
		return "redirect:admin";
	}
	
	
	@GetMapping("/view/{id}")
	String view(@PathVariable Long id, Board views, Model model) {
		Board item = service.item(id);
		
		service.rise(views);
		
		model.addAttribute("item", views);
		model.addAttribute("item", item);
		
		return path + "view";
	}
	
	@GetMapping("/delete/{id}")
	String delete(@PathVariable Long id) {
		Board item = service.item(id);

		service.delete(id);

		for (Photo photo : item.getPhoto()) {
			File file = new File(uploadPath + photo.getUuid() + "_" + photo.getFilename());
			file.delete();
		}

		return "redirect:../list";
	}
	
	@ResponseBody
	@GetMapping("/delete/photo/{id}")
	String deletePhoto(@PathVariable Long id) {
		Photo item = service.itemPhoto(id);

		service.deletePhoto(id);

		File file = new File(uploadPath + item.getUuid() + "_" + item.getFilename());
		file.delete();

		return id.toString();
	}
	
	@GetMapping("/update/{id}")
	String update(@PathVariable Long id, Model model) {
		Board item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{id}")
	String update(@PathVariable Long id,  Board item, List<MultipartFile> uploadFile, @SessionAttribute Users users) {
		List<Photo> photos = new ArrayList<Photo>();
		for (MultipartFile file : uploadFile) {
			if (file != null && !file.isEmpty()) {
				String filename = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();

				try {
					file.transferTo(new File(uploadPath + uuid + "_" + filename));

					Photo photo = new Photo();
					photo.setFilename(filename);
					photo.setUuid(uuid);

					photos.add(photo);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		item.setPhoto(photos);

		item.setId(id);
		item.setUpdateId(users.getId());

		System.out.println("item 변경" + item);
		service.update(item);

		return "redirect:../admin";
	}
	
	@GetMapping("/add/{webtoonId}")
	String add(@PathVariable Long webtoonId) {
		
		return path + "add";
	}
	
	@PostMapping("/add/{webtoonId}")
	String add(@Valid Board item, BindingResult bindingResult, @PathVariable Long webtoonId, List<MultipartFile> uploadFile, @SessionAttribute Users users, Model model) {
		List<Photo> photos = new ArrayList<Photo>();
		
		for(MultipartFile file : uploadFile) {
			if(file != null && !file.isEmpty()) {
				String filename = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
				
				try {
					file.transferTo(new File(uploadPath + uuid + "_" + filename));
					
					Photo photo = new Photo();
					photo.setFilename(filename);
					photo.setUuid(uuid);

					photos.add(photo);
									
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		item.setPhoto(photos);
		
		item.setRegId(users.getId());
		
		model.addAttribute("valid/add", item);
		
		if(bindingResult.hasErrors())
			return path + "valid/add";
		
		System.out.println("item 확인" + item);
		service.addRiview(item);
		
		return "redirect:../admin";
	}
	
}
