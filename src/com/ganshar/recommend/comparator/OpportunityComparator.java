package com.ganshar.recommend.comparator;

import java.util.Comparator;

import com.ganshar.job.model.Opportunity;

public class OpportunityComparator implements Comparator<Opportunity> {

	@Override
	public int compare(Opportunity o1, Opportunity o2) {
		return o2.getMatchScore().intValue()-o1.getMatchScore().intValue();
	}

	
}
