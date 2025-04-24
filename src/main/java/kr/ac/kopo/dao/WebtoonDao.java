package kr.ac.kopo.dao;

import java.util.List;
import java.util.Set;

import kr.ac.kopo.model.Photo;
import kr.ac.kopo.model.Webtoon;
import kr.ac.kopo.pager.Pager;

public interface WebtoonDao {


	void add(Webtoon item);

	void delete(Long id);

	Webtoon item(Long id);

	void update(Webtoon item);

	void addPhoto(Photo photo);

	Photo itemPhoto(Long id);

	void deletePhoto(Long id);

	void deletePhotos(Long id);

	List<Webtoon> list(Pager pager);

	Webtoon item(String ustar);

	void ustar(Long id);

	void ustar(Webtoon item);

	List<Webtoon> list(Set<Long> keySet);

	int total(Pager pager);

}
