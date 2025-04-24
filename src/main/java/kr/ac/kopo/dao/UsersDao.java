package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.model.Users;

public interface UsersDao {

	List<Users> list();

	void add(Users item);

	void delete(String id);

	Users item(String string);

	void update(Users item);

	List<Users> id();

}
