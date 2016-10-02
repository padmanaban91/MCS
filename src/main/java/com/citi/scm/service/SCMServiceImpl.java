package com.citi.scm.service;

import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SCMServiceImpl implements SCMService{
	
	@Autowired
	RuntimeService runtimeService;
	
	@Autowired TaskService taskService;
	
	@Autowired SessionFactory sessionFactory;
	
	
	public void startWorkflow(Map<String, Object> inputMap) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		ProcessInstance gisInstance = runtimeService.startProcessInstanceByKey("GIS-Approval", inputMap);
		System.out.println("Process Instance Id: " + gisInstance.getProcessInstanceId());
		System.out.println("Process Instance : " + gisInstance.getProcessDefinitionId());
		System.out.println("Process Instance : " + gisInstance.getBusinessKey());
		System.out.println("Process Instance : " + gisInstance.getCaseInstanceId());
	}


	public void completeWorkflow(Map<String, Object> inputMap) throws Exception {
		List<Task> taskList = taskService.createTaskQuery().active()
				.processDefinitionKey("GIS-Approval")
				.processVariableValueEquals("userName", inputMap.get("userName")).list();
		if(taskList != null && !taskList.isEmpty()) {
			Task task = taskList.get(0);
			taskService.complete(task.getId(), inputMap);
		} else {
			throw new Exception();
		}
	}

}
