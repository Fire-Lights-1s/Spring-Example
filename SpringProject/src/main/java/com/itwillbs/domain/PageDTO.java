package com.itwillbs.domain;

public class PageDTO {
	private int pageSize;
	private String pageNum;
	private int currentPage;
	private int count;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int pageBlock;
	
	private int startRow;
	private int endRow;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageCount) {
		this.pageBlock = pageCount;
	}
	public PageDTO getStartEndRow(PageDTO pageDTO) {
		int pageSize = pageDTO.getPageSize();
		int currentPage = pageDTO.getCurrentPage();
		int totalPage = (int) Math.ceil(pageDTO.getCount() / (double)pageSize);
		//page.getCount() + (pageSize - (page.getCount() % pageSize)) % pageSize
		
		if(totalPage < currentPage) {
			currentPage = totalPage;
			pageDTO.setCurrentPage(currentPage);
		}
		pageDTO.setTotalPage(totalPage);
		pageDTO.setStartRow((currentPage-1)*pageSize + 1);
		pageDTO.setEndRow(currentPage*pageSize);
		
		return pageDTO;
	}
	public PageDTO getStartEndPage(PageDTO pageDTO) {
		int pageBlock = pageDTO.getPageBlock();
		int currentPage = pageDTO.getCurrentPage();
		int startPage = ((currentPage-1)/pageBlock)*pageBlock +1;
		int endPage = ((currentPage-1)/pageBlock)*pageBlock+pageBlock;
		if(pageDTO.getTotalPage() <startPage ) {
			startPage = pageDTO.getTotalPage();
		}
		if(pageDTO.getTotalPage() <endPage ) {
			endPage = pageDTO.getTotalPage();
		}
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		return pageDTO;
	}
}