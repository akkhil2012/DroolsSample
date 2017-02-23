package org.activiti.designer.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.io.FileInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

public class ProcessTestMyProcess {

	private String filename = "C:/iKare/FinanceFlow/deployment/FinanceProcess.bar";

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	@Test
	public void startProcess() throws Exception {
		RepositoryService repositoryService = activitiRule
				.getRepositoryService();
		ZipInputStream inputStream = null;
		Deployment deployment = null;
		try{
			inputStream = new ZipInputStream(new FileInputStream(
				filename));
		}
		catch(Exception e){
			System.out.println(" exception ---"+ e);
		}
		System.out.println(" step 1:" + inputStream);
		
	//	System.out.println(" Activit rile is :" + activitiRule.getRuntimeService().startProcessInstanceByKey("myProcess"));
		 
		//DeploymentBuilder builder = repositoryService.createDeployment();
	try{
		 deployment = repositoryService
			    .createDeployment()
			    .name("FinanceProcess").addZipInputStream(inputStream)
		.deploy();
	}catch(Exception e){
		System.out.println(" exception ---"+ e);
	}

		 // assertEquals("FinanceProcess.bar", deployment[0].getName());
		  assertNotNull(deployment.getDeploymentTime());
		  
		
	
		
				/*String deploymentID = builder.name("FinanceProcess.bar").addZipInputStream(inputStream)
				.deploy().getId();*/
		//System.out.println(" step 2:" + deployment);
		  RuntimeService runtimeService = null;
		  try{
		 runtimeService = activitiRule.getRuntimeService();
		  }catch(Exception e){
			  System.out.println(" exception is " + e);
		  }
		 // System.out.println(" Activiti runtimeService  is---------- :" + runtimeService);
		Map<String, Object> variableMap = new HashMap<String, Object>();

		
	//	System.out.println(" Activiti runtimeService  is :" + runtimeService);
		variableMap.put("country", 0001L);
		variableMap.put("employeeCost", 2400L);
		variableMap.put("budget", 100L);
		//System.out.println(" step 3:");
		if(null==runtimeService){
			System.out.println(" runtimeService is null");
		}
		
	//	runtimeService.
		//runtimeService.activateProcessInstanceById("FinanceProcess");
		
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("myProcess", variableMap);
		 System.out.println(" deployment name is :" + deployment);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	}
		
		}
