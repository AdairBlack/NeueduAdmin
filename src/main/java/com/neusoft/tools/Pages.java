package com.neusoft.tools;

public class Pages {
	//每页记录数
	public static int recordsPerPage = 5;
	//显示页数
	public static int pagesShow = 5;
	//当前页
	private int page = 1;
	//记录数
	private int count = 0;
	//总页数
	private int maxPage = 0;
	//起始页
	private int startPage = 1;
	//最终页
	private int endPage = pagesShow;
	//搜索开始页
	private int beginPage = 0;
	
	
	public int getBeginPage(){
		beginPage = (page - 1) * recordsPerPage;
		return beginPage;
	}
	

	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
		if(page<1){
			this.page=1;
		}
		if(page>this.maxPage){
			this.page=this.maxPage;
		}
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage() {
		
		if(this.count%this.recordsPerPage == 0){
			this.maxPage = this.count/this.recordsPerPage;
		}else{
			this.maxPage = this.count/this.recordsPerPage + 1;
		}
	}

	

	public int getStartPage() {
		return startPage;
	}


	public void setStart_EndPage() {
		
		if(this.maxPage<this.pagesShow){
			this.startPage=1;
			this.endPage=this.maxPage;
		}else{
			if(page <= this.pagesShow/2+1){
				this.startPage=1;
				this.endPage=this.pagesShow;
			}else if(page < this.maxPage-this.pagesShow/2){
				this.startPage=page-this.pagesShow/2;
				this.endPage=page+this.pagesShow/2;
			}else{
				this.startPage=this.maxPage-this.pagesShow+1;
				this.endPage=this.maxPage;
			}
		}
	}


	public int getEndPage() {
		return endPage;
	}
	
	

	public static int getRecordsPerPage() {
		return recordsPerPage;
	}


	public static int getPagesShow() {
		return pagesShow;
	}


	/**
	 * 
	 * @param page
	 * @param count
	 */
	public Pages(int page,int count){
	//	this.page=page;
		this.count=count;
		this.setMaxPage();
		this.setPage(page);
		
		this.setStart_EndPage();
		this.display();
	}
	public void display(){
		System.out.println("....display......");
		System.out.println("page="+this.getPage());
		System.out.println("count="+this.getCount());
		System.out.println("MaxPage="+this.getMaxPage());
		System.out.println("StartPage="+this.getStartPage());
		System.out.println("endPage="+this.getEndPage());
	}
}
