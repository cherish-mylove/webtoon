package kr.ac.kopo.model;

import java.util.HashMap;
import java.util.Map;

public class Like {
	private Map<Long, Integer> like = new HashMap<Long, Integer>();
	
	public void setLike(Long webtoonId, Integer amount) {
		if(like.containsKey(webtoonId))
			like.put(webtoonId, like.get(webtoonId) + amount);
		else
			like.put(webtoonId, amount);			
	}
	
	public Map<Long, Integer> getLike() {
		return like;
	}

	public void delete(Long webtoonId) {
		like.remove(webtoonId);
	}
}