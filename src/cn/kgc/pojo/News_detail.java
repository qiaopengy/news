package cn.kgc.pojo;

import java.util.Date;

//新闻详情JavaBean:仅封装数据,根据所对应的数据库的表.
//一般有一个表就有一个JavaBean，每个JavaBean有几个属性取决于对应的表有多少列
//只包括属性、及getter和setter方法
public class News_detail {
	private int id;
	private int categoryId;
	private String title;
	private String summary;
	private String content;
	private String picPath;
	private String author;
	private Date createDate;
	private Date moddifyDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModdifyDate() {
		return moddifyDate;
	}
	public void setModdifyDate(Date moddifyDate) {
		this.moddifyDate = moddifyDate;
	}
}
