package cn.kgc.pojo;

import java.util.Date;

//我是一个pojo,用来封装数据的
public class news_category {

	private int id;
	private String name;
	private Date creatDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

}
