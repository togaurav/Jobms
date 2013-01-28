package com.framework.core.vo;

/**
 * 分页相关信息vo
 * 
 * @author liuzhaobing
 * 
 */
public class Page extends VO {
	// 每页条数
	private Long page_size;
	// 当前页码
	private Long cur_page_num;
	// 总条数
	private Long total_page_num;

	/***************************************************************************************** 
	 * 		在呼入模块设计时，由FE提出更改分页用的三个变量，即：page_size、cur_page_num、total_page_num
	 * 		分别变为：pageSize、curPageNum、totalRecNum，作此变动的目的在于从字面上理解的含义更为清晰。
	 * 		为了适应改变化，同时保持原呼出模块代码的仍然可用，增加下列的setter和getter。
	 * 
	 * 		he_jian 2009-06-09
	 * 
	 */
	public Long getCurPageNum() {
		return cur_page_num;
	}
	
	public void setCurPageNum(Long curPageNum) {
		this.cur_page_num = curPageNum;
	}
	
	public Long getPageSize() {
		return page_size;
	}
	
	public void setPageSize(Long pageSize) {
		this.page_size = pageSize;
	}
	
	public Long getTotalRecNum() {
		return total_page_num;
	}
	
	public void setTotalRecNum(Long totalRecNum) {
		this.total_page_num = totalRecNum;
	}
	
	public Long getPage_size() {
		return page_size;
	}
	/***************************  he_jian 2009-06-09 END  ***********************/
	
	public void setPage_size(Long page_size) {
		this.page_size = page_size;
	}

	public Long getCur_page_num() {
		return cur_page_num;
	}

	public void setCur_page_num(Long cur_page_num) {
		this.cur_page_num = cur_page_num;
	}

	public Long getTotal_page_num() {
		return total_page_num;
	}

	public void setTotal_page_num(Long total_page_num) {
		this.total_page_num = total_page_num;
	}
}
