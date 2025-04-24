package kr.ac.kopo.service;


import java.util.List;
import java.util.Set;

import kr.ac.kopo.model.Photo;
import kr.ac.kopo.model.Webtoon;
import kr.ac.kopo.pager.Pager;


public interface WebtoonService {

	void add(Webtoon item);

	void delete(Long id);

	Webtoon item(Long id);

	void update(Webtoon item);

	Photo itemPhoto(Long id);

	void deletePhoto(Long id);

	List<Webtoon> list(Pager pager);

	Webtoon item(String ustar);

	void ustar(Long id);

	void ustar(Webtoon item);

	List<Webtoon> list(Set<Long> keySet);
	
}
