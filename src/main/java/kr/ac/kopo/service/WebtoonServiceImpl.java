package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.dao.WebtoonDao;
import kr.ac.kopo.model.Photo;
import kr.ac.kopo.model.Webtoon;
import kr.ac.kopo.pager.Pager;

@Service
public class WebtoonServiceImpl implements WebtoonService {

	@Autowired
	WebtoonDao dao;
	
	@Override
	public List<Webtoon> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}
	
	@Transactional
	@Override
	public void add(Webtoon item) {
		dao.add(item);
		
		if(item.getPhoto() != null)
			for(Photo photo : item.getPhoto()) {
				photo.setWebtoonId(item.getId());	
				dao.addPhoto(photo);
			}
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		dao.deletePhotos(id);
		
		dao.delete(id); 
		
	}

	@Override
	public Webtoon item(Long id) {
		Webtoon webtoon = dao.item(id);
		return webtoon;
	}
	
	@Transactional
	@Override
	public void update(Webtoon item) {
		dao.update(item);

		if(item.getPhoto() != null)
			for(Photo photo : item.getPhoto()) {	
				photo.setWebtoonId(item.getId());	
				dao.addPhoto(photo);
			}
	}

	@Override
	public Photo itemPhoto(Long id) {
		return dao.itemPhoto(id);
	}

	@Override
	public void deletePhoto(Long id) {
		dao.deletePhoto(id);	
		
	}

	@Override
	public Webtoon item(String ustar) {
		return dao.item(ustar);
	}

	@Override
	public void ustar(Long id) {
		dao.ustar(id);
		
	}

	@Override
	public void ustar(Webtoon item) {
		dao.ustar(item);
		
	}

	@Override
	public List<Webtoon> list(Set<Long> keySet) {
		if(keySet.isEmpty())
			return new ArrayList<Webtoon>();
			
		return dao.list(keySet);
	}
	
}
