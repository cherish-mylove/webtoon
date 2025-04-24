package kr.ac.kopo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.dao.BoardDao;
import kr.ac.kopo.model.Board;
import kr.ac.kopo.model.Photo;
import kr.ac.kopo.pager.Pager;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;

	@Override
	public List<Board> list(Pager pager) {
		int total = dao.total(pager);

		pager.setTotal(total);

		return dao.list(pager);
	}

	@Transactional
	@Override
	public void add(Board item) {
		dao.add(item);

		if (item.getPhoto() != null)
			for (Photo photo : item.getPhoto()) {
				photo.setBoardId(item.getId());
				dao.addPhoto(photo);
			}
	}

	@Override
	public Board item(Long id) {
		Board board = dao.item(id);
		
		return board;
	}

	@Override
	public void delete(Long id) {
		dao.deletePhotos(id);

		dao.delete(id);

	}

	@Override
	public Photo itemPhoto(Long id) {
		return dao.itemPhoto(id);
	}

	@Override
	public void deletePhoto(Long id) {
		dao.deletePhoto(id);

	}

	@Transactional
	@Override
	public void update(Board item) {
		dao.update(item);

		if (item.getPhoto() != null)
			for (Photo photo : item.getPhoto()) {
				photo.setBoardId(item.getId());
				dao.addPhoto(photo);
			}
	}
	
	@Transactional
	@Override
	public void addRiview(@Valid Board item) {
		dao.addRiview(item);

		if (item.getPhoto() != null)
			for (Photo photo : item.getPhoto()) {
				photo.setBoardId(item.getId());
				dao.addPhoto(photo);
			}

	}

	@Override
	public void rise(Board views) {
		dao.rise(views);
	}

	@Override
	public	List<Board> all() {
		return dao.all();
	}


	
}
