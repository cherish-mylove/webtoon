package kr.ac.kopo.model;

public class Photo {
	private Long id;
	private Long webtoonId;
	private Long boardId;
	private String filename;
	private String uuid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWebtoonId() {
		return webtoonId;
	}

	public void setWebtoonId(Long webtoonId) {
		this.webtoonId = webtoonId;
	}

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", webtoonId=" + webtoonId + ", boardId=" + boardId + ", filename=" + filename
				+ ", uuid=" + uuid + "]";
	}

}
