package cn.kgc.service.impl;

import java.util.List;

import cn.kgc.pojo.News_detail;
import cn.kgc.service.NewsService;

public class Test {
	public static void main(String[] args) {

		//测试一下分页
		NewsService newsService = new NewsServiceImpl();
		
		//System.out.println(newsService.getTotalCount());
		
	List<News_detail> list = newsService.getPageNewsList(1, 3);
		for (News_detail news_detail : list) {
			System.out.println(news_detail.getId()+"-"+news_detail.getTitle());
		}
	
		
	}
}
