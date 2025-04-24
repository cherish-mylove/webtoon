package kr.ac.kopo.dao;

import java.util.List;

import javax.validation.Valid;

import kr.ac.kopo.model.Board;
import kr.ac.kopo.model.Photo;
import kr.ac.kopo.pager.Pager;

public interface BoardDao {

	List<Board> list(Pager pager);

	void add(Board item);

	Board item(Long id);

	void addPhoto(Photo photo);

	void delete(Long id);

	void deletePhotos(Long id);

	Photo itemPhoto(Long id);

	void deletePhoto(Long id);

	void update(Board item);

	int total(Pager pager);

	void addRiview(@Valid Board item);

	void rise(Board views);

	List<Board> all();

	
	
}
