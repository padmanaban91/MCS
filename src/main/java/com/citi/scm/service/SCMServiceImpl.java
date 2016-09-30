package com.citi.scm.service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SCMServiceImpl implements SCMService{
	
	@Autowired
	RuntimeService runtimeService;
	
	
	public void startWorkflow() {
		// TODO Auto-generated method stub
		
		ProcessInstance gisInstance = runtimeService.startProcessInstanceByKey("GIS-Approval");
		System.out.println("Process Instance Id: " + gisInstance.getProcessInstanceId());
		System.out.println("Process Instance : " + gisInstance.getProcessDefinitionId());
		System.out.println("Process Instance : " + gisInstance.getBusinessKey());
		System.out.println("Process Instance : " + gisInstance.getCaseInstanceId());
		
	}

}
