package com.crm.Mobicentrum.CampaignTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerEg implements IRetryAnalyzer

{

	public boolean retry(ITestResult result) {
		int icount=0;
		int fcount=3;
		if(icount<fcount)
		{
			icount++;
			return true;
		}
		return false;
	}
}
