package kr.ac.kopo.dao;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Board;
import kr.ac.kopo.model.Photo;
import kr.ac.kopo.pager.Pager;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Board> list(Pager pager) {
		return sql.selectList("board.list", pager);
	}

	@Override
	public void add(Board item) {
		sql.insert("board.add", item);
	}

	@Override
	public Board item(Long id) {
		return sql.selectOne("board.item", id);
	}

	@Override
	public void addPhoto(Photo photo) {
		sql.insert("board.add_photo", photo);
		
	}

	@Override
	public void delete(Long id) {
		sql.delete("board.delete", id);
		
	}

	@Override
	public void deletePhotos(Long id) {
		sql.delete("board.delete_photos", id);
		
	}

	@Override
	public Photo itemPhoto(Long id) {
		return sql.selectOne("board.item_photo", id);
	}

	@Override
	public void deletePhoto(Long id) {
		sql.delete("board.delete_photo", id);
		
	}

	@Override
	public void update(Board item) {
		sql.update("board.update", item);
		
	}

	@Override
	public int total(Pager pager) {
		return sql.selectOne("board.total", pager);
	}

	@Override
	public void addRiview(@Valid Board item) {
		sql.insert("board.add_Riview", item);
		
	}

	@Override
	public void rise(Board views) {
		sql.update("board.rise", views);
		
	}

	@Override
	public 	List<Board> all() {
		return sql.selectOne("board.all");
	}


	

}
