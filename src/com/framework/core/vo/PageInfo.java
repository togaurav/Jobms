/**
 * 
 */
package com.framework.core.vo;

/**
 * @author zengyunfeng
 * @version 1.0.0
 *
 */
public class PageInfo {
	
	private int beginPage;
	private int endPage;
	private int totalPage;
	
	/**
	 * 根据总个数，当前页，页大小生成分页显示列表的起始页和结束页
	 * @param totalSize 记录总个数
	 * @param curPage 当前页，可能存在最大页或者最小页的情况，此时可以利用返回值获得真实的当前页
	 * @param pageSize 每页大小
	 * @return 返回当前页,对于当前页大于最大页或者最小页，则返回边界值
	 */
	public int processPageList(long totalSize, int curPage, int pageSize){
		// 如果页面大小小于1，则每页显示20个。
		if (pageSize < 1) {
			pageSize = 20;
		}

		// 总共的页数：如果总个数<=0，则页数为1。
		totalPage = (int) (totalSize > 0 ? (totalSize - 1)
				/ pageSize + 1 : 1);
		// 如果当前页小于0，则当前页为0;否则如果当前页大于总页数，则当前页为最后一页
		if (curPage < 0) {
			curPage = 0;
		} else if (curPage >= totalPage) {
			curPage = totalPage - 1;
		}
		// 显示页码为内部页码+1
//		curPage++;

		beginPage = 0;
		endPage = 0;
		if (totalPage <= 10) {	//最多显示10个页码
			beginPage = 0;
			endPage = totalPage-1;
		} else {
			beginPage = curPage - 5; // 开始页为当前页往前数5个。
			if (beginPage < 0) {
				// 从第一页开始的连续10页
				beginPage = 0;
				endPage = beginPage + 9;
			} else {
				endPage = curPage + 4; // 结束页为当前页往后数4个。
				if (endPage >= totalPage) {
					// 从最后一页往前的连续10页。
					endPage = totalPage-1;
					beginPage = endPage - 9;
				}
			}
		}
		
		return curPage;

	}

	/**
	 * @return the beginPage
	 */
	public int getBeginPage() {
		return beginPage;
	}

	/**
	 * @param beginPage the beginPage to set
	 */
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	/**
	 * @return the endPage
	 */
	public int getEndPage() {
		return endPage;
	}

	/**
	 * @param endPage the endPage to set
	 */
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	

}
