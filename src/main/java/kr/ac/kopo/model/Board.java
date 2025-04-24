package kr.ac.kopo.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Board {
	private Long id;

	@NotEmpty(message = "공백 없음")
	private String title;

	@NotEmpty(message = "공백 없음")
	private String text;

	private String regId;
	private Date regDate;
	private String updateId;
	private Date updateDate;
	private Long webtoonId;

	private List<Photo> photo;

	private Long views;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getWebtoonId() {
		return webtoonId;
	}

	public void setWebtoonId(Long webtoonId) {
		this.webtoonId = webtoonId;
	}

	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", text=" + text + ", regId=" + regId + ", regDate=" + regDate
				+ ", updateId=" + updateId + ", updateDate=" + updateDate + ", webtoonId=" + webtoonId + ", photo="
				+ photo + ", views=" + views + "]";
	}

}
