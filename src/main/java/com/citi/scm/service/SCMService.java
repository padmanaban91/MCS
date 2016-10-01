package com.citi.scm.service;

import java.util.Map;

public interface SCMService {
	
	void startWorkflow(Map<String, Object> inputMap);
	void completeWorkflow(Map<String, Object> inputMap) throws Exception;

}
