package edu.miu.scs.report.service;

import java.util.List;

import edu.miu.scs.report.domain.SearchHistory;

public interface HistorySearchService {

	List<SearchHistory> listReport();
	public String exportReport(String format);
}
