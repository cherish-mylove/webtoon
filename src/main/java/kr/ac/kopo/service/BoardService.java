package kr.ac.kopo.service;

import java.util.List;

import javax.validation.Valid;

import kr.ac.kopo.model.Board;
import kr.ac.kopo.model.Photo;
import kr.ac.kopo.pager.Pager;

public interface BoardService {
	
	List<Board> list(Pager pager);

	void add(Board item);

	Board item(Long id);

	void delete(Long id);

	Photo itemPhoto(Long id);

	void deletePhoto(Long id);

	void update(Board item);

	void addRiview(@Valid Board item);

	void rise(Board views);

	List<Board> all();

	

	
	
}
