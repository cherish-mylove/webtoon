package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Users;

public interface UsersService {

	List<Users> list();

	void add(Users item);

	void delete(String id);

	Users item(String id);

	void update(Users item);

	Boolean login(Users item);

	void signup(Users item);

	boolean isUnique(String id);

	List<Users> id();
	
}
