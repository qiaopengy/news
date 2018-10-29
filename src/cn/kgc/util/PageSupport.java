package cn.kgc.util;

//分页工具类,计算**的总页数：总数量/每页显示几条
public class PageSupport {


	// 总页数
	private int totalPageCount = 1;
	
	// 当前页数
	private int currentPageNo = 1;

	// 新闻的总数量
	private int totalCount = 0;

	// 单页的容量
	private int pageSize = 0;
	

	//获得当前页数
	public int getCurrentPageNo() {
		return currentPageNo;
	}

	//设置当前页数
	public void setCurrentPageNo(int currentPageNo) {
		if (currentPageNo > 0) {
			this.currentPageNo = currentPageNo;
		}
	}
	
	//设置总页数
	public void setTotalPageCountByRS() {
		if (this.totalCount % this.pageSize == 0) {
			this.totalPageCount = this.totalCount / this.pageSize;
		} else {
			this.totalPageCount = this.totalCount / this.pageSize + 1;
		}
	}


	
	// 设置新闻的总数量,同步调用设置总页数方法
	public void setTotalCount(int totalCount) {
		if (totalCount >= 0) {
			this.totalCount = totalCount;
			this.setTotalPageCountByRS();
			// 设置总页数

		}
	}
	
	//获得新闻总数量
	public int getTotalCount() {
		return totalCount;
	}



	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0) {

			this.pageSize = pageSize;
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	// 流程；首先去数据库查询新闻总数量-->设置新闻总数量,同时计算总页数setTotalCount(1000)-->getTotalPageCount()
}
