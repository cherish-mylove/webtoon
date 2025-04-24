package kr.ac.kopo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.UsersDao;
import kr.ac.kopo.model.Users;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao dao;
	
	@Override
	public List<Users> list() {
		return dao.list();
	}

	@Override
	public void add(Users item) {
		dao.add(item);

	}

	@Override
	public void delete(String id) {
		dao.delete(id);

	}

	@Override
	public Users item(String id) {
		return dao.item(id);
	}

	@Override
	public void update(Users item) {
		dao.update(item);

	}

	@Override
	public Boolean login(Users item) {
		Users users = dao.item(item.getId());
		
		if(users != null) {
			if(item.getPasswd().equals(users.getPasswd())) {
				BeanUtils.copyProperties(users, item);
				item.setPasswd(null);
				
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void signup(Users item) {
		item.setRole(1);
		
		dao.add(item);
	}

	@Override
	public boolean isUnique(String id) {
		if(dao.item(id) == null)
			return true;
		
		return false;
	}

	@Override
	public List<Users> id() {
		return dao.id();
	}
}
