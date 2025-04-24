package kr.ac.kopo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Photo;
import kr.ac.kopo.model.Webtoon;
import kr.ac.kopo.pager.Pager;

@Repository
public class WebtoonDaoImpl implements WebtoonDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Webtoon> list(Pager pager) {
		return sql.selectList("webtoon.list", pager);
	}

	@Override
	public int total(Pager pager) {
		return sql.selectOne("webtoon.total", pager);
	}
	
	@Override
	public void add(Webtoon item) {
		sql.insert("webtoon.add", item);
		
	}

	@Override
	public void delete(Long id) {
		sql.delete("webtoon.delete", id);
	}

	@Override
	public Webtoon item(Long id) {
		return sql.selectOne("webtoon.item", id);
	}

	@Override
	public void update(Webtoon item) {
		sql.update("webtoon.update", item);
		
	}

	@Override
	public void addPhoto(Photo photo) {
		sql.insert("webtoon.add_photo", photo);
		
	}

	@Override
	public Photo itemPhoto(Long id) {
		return sql.selectOne("webtoon.item_photo", id);
	}

	@Override
	public void deletePhoto(Long id) {
		sql.delete("webtoon.delete_photo", id);
		
	}

	@Override
	public void deletePhotos(Long id) {
		sql.delete("webtoon.delete_photos", id);
		
	}

	@Override
	public Webtoon item(String ustar) {
		return sql.selectOne("webtoon.item", ustar);
	}

	@Override
	public void ustar(Long id) {
		sql.update("webtoon.ustar", id);
		
	}

	@Override
	public void ustar(Webtoon item) {
		sql.update("webtoon.ustar", item);
		
	}

	@Override
	public List<Webtoon> list(Set<Long> keySet) {
		HashMap<String, Set<Long>> map = new HashMap<String, Set<Long>>();
		
		map.put("keySet", keySet);
		
		return sql.selectList("webtoon.list_keyset", map);
	}


}
