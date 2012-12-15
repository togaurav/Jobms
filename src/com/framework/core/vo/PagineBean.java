/**
 * 
 */
package com.framework.core.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询结果对象������
 * 
 * @author Mazhy.Keng
 * 
 */
public class PagineBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8265919959641598206L;

	/**
	 * 当前页码
	 */
	private Long cur_page_num;
	/**
	 * 上一页
	 */
	private Long prePage;
	/**
	 * 下一页
	 */
	private Long nextPage;
	/**
	 * 总页数
	 */
	private Long totalPages;
	/**
	 * 是否首页
	 */
	private Boolean isFirstPage;
	/**
	 * 是否页末
	 */
	private Boolean isLastPage;
	/**
	 * 每页显示行数
	 */
	private Long page_size;
	/**
	 * 本页开始序号
	 */
	private Long startSerial;
	/**
	 * 当页数据列表
	 */
	private List<Object> dataList;

	/**
	 * 总记录数，TODO
	 */
	private Long total_page_num;

	/**
	 * default constructor
	 */
	public PagineBean() {

	}

	public Long getCur_page_num() {
		return cur_page_num;
	}

	public void setCur_page_num(Long cur_page_num) {
		this.cur_page_num = cur_page_num;
	}

	public Long getPage_size() {
		return page_size;
	}

	public void setPage_size(Long page_size) {
		this.page_size = page_size;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Boolean getIsFirstPage() {
		return isFirstPage;
	}

	public void setIsFirstPage(Boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public Boolean getIsLastPage() {
		return isLastPage;
	}

	public void setIsLastPage(Boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	public Long getPrePage() {
		return prePage;
	}

	public void setPrePage(Long prePage) {
		this.prePage = prePage;
	}

	public Long getNextPage() {
		return nextPage;
	}

	public void setNextPage(Long nextPage) {
		this.nextPage = nextPage;
	}

	public Long getStartSerial() {
		return startSerial;
	}

	public void setStartSerial(Long startSerial) {
		this.startSerial = startSerial;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public Long getTotal_page_num() {
		return total_page_num;
	}

	/**
	 * 设置总记录数
	 * 
	 * @param total_record_num
	 */
	public void setTotal_page_num(Long total_record_num) {
		this.total_page_num = total_record_num;
	}

}
