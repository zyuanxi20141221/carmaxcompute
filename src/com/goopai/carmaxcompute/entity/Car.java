package com.goopai.carmaxcompute.entity;

import java.util.Date;

public class Car {

	private long id;
	private String title;
	private String publishtime;
	private String source;
	private String category;
	private String author;
	private String content;
	private Date createtime;
	private String keywords;

	public Car(long id, String _title, String _pubtime, String _source, String _category, String _author, String _content, Date _createtime, String _keywords) {
		this.id = id;
		this.title = _title;
		this.publishtime = _pubtime;
		this.source = _source;
		this.category = _category;
		this.author = _author;
		this.content = _content;
		this.createtime = _createtime;
		this.keywords = _keywords;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
