package com.ganshar.recommend.service;

import java.util.List;

import com.ganshar.job.model.Opportunity;

public interface RecommendService {

	public List<Opportunity> recommend(Long userId, List<Opportunity> opps);
	
	public List<Opportunity> recommend(Long userId);
	
	public List<Opportunity> recommend(Long userId,Integer topcount);
	
	public List<Opportunity> filterOpportunitys(Long userId);
}
