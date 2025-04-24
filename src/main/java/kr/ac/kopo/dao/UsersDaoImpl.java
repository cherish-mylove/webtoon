package kr.ac.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Users> list() {
		return sql.selectList("users.list");
	}

	@Override
	public void add(Users item) {
		sql.insert("users.add", item);

	}

	@Override
	public void delete(String id) {
		sql.delete("users.delete", id);

	}

	@Override
	public Users item(String id) {
		return sql.selectOne("users.item", id);
	}

	@Override
	public void update(Users item) {
		sql.update("users.update", item);

	}

	@Override
	public List<Users> id() {
		return sql.selectList("users.id");
	}

}
