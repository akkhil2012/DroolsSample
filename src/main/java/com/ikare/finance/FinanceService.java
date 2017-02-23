package com.ikare.finance;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

	public class FinanceService implements JavaDelegate {
		
		public void execute(DelegateExecution arg) throws Exception {
		// TODO Auto-generated method stub
			Finance finance=new Finance();
			finance.setCountryCode((Long) arg.getVariable("country"));
			finance.setBudget((Long) arg.getVariable("budget"));
			finance.setEmployeeCost((Long) arg.getVariable("employeeCost"));
		
		arg.setVariable("finance", finance);
}
	}
