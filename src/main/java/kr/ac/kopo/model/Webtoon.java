package kr.ac.kopo.model;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Webtoon {

	@Min(value = 1, message = "�쎒�댆踰덊샇�뒗 0蹂대떎 �겙 �닔濡� �븯�떆�삤")
	private Long id;

	@NotEmpty(message = "怨듬갚 遺덇�")
	private String title;

	@NotEmpty(message = "怨듬갚 遺덇�")
	private String plot;

	@NotEmpty(message = "怨듬갚 遺덇�")
	private String author;

	private List<Photo> photo;

	private String star;

	private String ustar;

	private String src;

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

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getUstar() {
		return ustar;
	}

	public void setUstar(String ustar) {
		this.ustar = ustar;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String toString() {
		return "Webtoon [id=" + id + ", title=" + title + ", plot=" + plot + ", author=" + author + ", photo=" + photo
				+ ", star=" + star + ", ustar=" + ustar + "]";
	}

}
