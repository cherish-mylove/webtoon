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

import kr.ac.kopo.model.Photo;
import kr.ac.kopo.model.Users;
import kr.ac.kopo.model.Webtoon;
import kr.ac.kopo.pager.Pager;
import kr.ac.kopo.service.WebtoonService;

@Controller
@RequestMapping("/webtoon")
public class WebtoonController {
	final String path = "webtoon/";
	final String uploadPath = "d:/project/";

	@Autowired
	WebtoonService service;

	@GetMapping("/list")
	String list(Model model, Pager pager) {
		List<Webtoon> list = service.list(pager);
		
		System.out.println("웹툰목록" + list);
		model.addAttribute("list", list);
		
		return path + "list";
	}

	@GetMapping("/admin")
	String admin(Model model, Pager pager) {
		List<Webtoon> list = service.list(pager);

		model.addAttribute("list", list);

		return path + "admin";
	}

	@GetMapping("/delete/{id}")
	String delete(@PathVariable Long id) {
		Webtoon item = service.item(id);

		service.delete(id);

		for (Photo photo : item.getPhoto()) {
			File file = new File(uploadPath + photo.getUuid() + "_" + photo.getFilename());
			file.delete();
		}

		return "redirect:../admin";
	}

	@GetMapping("/add")
	String add() {
		return path + "add";
	}

	@PostMapping("/add")
	String add(@Valid Webtoon item, BindingResult bindingResult, List<MultipartFile> uploadFile, @SessionAttribute(required = false) Users users) {
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

		if(bindingResult.hasErrors())
			return path + "valid/add";
		
		service.add(item);

		return "redirect:admin";
	}

	@GetMapping("/update/{id}")
	String update(@PathVariable Long id, Model model) {
		Webtoon item = service.item(id);

		model.addAttribute("item", item);

		return path + "update";
	}

	@PostMapping("/update/{id}")
	String update(@PathVariable Long id, Webtoon item, List<MultipartFile> uploadFile, @SessionAttribute(required = false) Users users) {
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

		System.out.println("item �솗�씤" + item);
		service.update(item);

		return "redirect:../admin";
	}

	@GetMapping("/view/{id}")
	String view(@PathVariable Long id, Model model) {
		Webtoon item = service.item(id);

		model.addAttribute("item", item);

		return path + "view";
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
	
	@GetMapping("/ustar/{id}")
	String ustar(@PathVariable Long id) {
		
		return path + "ustar"; 
	}


	@PostMapping("/ustar/{id}")
	String ustar(@PathVariable Long id, Webtoon item) {
		
		service.ustar(item);
		
		return "redirect:../list";
	}
	
}
