package com.ganshar.match.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ganshar.match.service.UserCompetencyService;
import com.ganshar.match.web.vo.CompetencyChartVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompetencyAction extends ActionSupport  {
	private final static Logger log = LogManager
			.getLogger(CompetencyAction.class);
	
	protected UserCompetencyService userCompetencyService;
	
	List<CompetencyChartVO> chartData;

	public String generateUserCompetencyChart() throws Exception {
		try {
			ActionContext ctx=ActionContext.getContext();
			Long userId=(Long)ctx.getSession().get("userid");
			
			chartData=this.userCompetencyService.findUserCompetencyChartVOList(userId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String showUserCompetencyChart() throws Exception {
		return SUCCESS;
	}	

	public List<CompetencyChartVO> getChartData() {
		return chartData;
	}
	public void setChartData(List<CompetencyChartVO> chartData) {
		this.chartData = chartData;
	}
	public UserCompetencyService getUserCompetencyService() {
		return userCompetencyService;
	}
	public void setUserCompetencyService(UserCompetencyService userCompetencyService) {
		this.userCompetencyService = userCompetencyService;
	}

}
