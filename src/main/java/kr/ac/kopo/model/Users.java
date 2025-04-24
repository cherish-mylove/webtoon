package kr.ac.kopo.model;

import java.util.HashMap;
import java.util.Map;

public class Users {
		
	private Map<Long, Integer> item = new HashMap<Long, Integer>();
	
	private String id;
	private String passwd;
	private String name;
	private String tel;
	private Integer role;

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void delete(Long webtoonId) {
		item.remove(webtoonId);
		
	}
	
}
