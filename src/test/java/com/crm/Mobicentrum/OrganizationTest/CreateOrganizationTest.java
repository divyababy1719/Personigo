package com.crm.Mobicentrum.OrganizationTest;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Mobicentrum.GenericUtility.BaseClass;
import com.crm.Mobicentrum.GenericUtility.ExcelUtility;
import com.crm.Mobicentrum.GenericUtility.JavaUtility;
import com.crm.Mobicentrum.PomRepository.CreateNewOrganizationPage;
import com.crm.Mobicentrum.PomRepository.HomePage;
import com.crm.Mobicentrum.PomRepository.OrganizationInformationPage;
import com.crm.Mobicentrum.PomRepository.OrganizationsPage;

@Listeners(com.crm.Mobicentrum.GenericUtility.ListenerImplementation.class)

public class CreateOrganizationTest  extends BaseClass{

		@Test(groups = "SmokeTest")
		public void createOrganization() throws Throwable
		{
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();

		HomePage hp=new HomePage(driver);
		OrganizationsPage op=new OrganizationsPage(driver);
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
				
		hp.getOrganizationLink().click();
		op.getCreateOrgImage().click();
		int value = jLib.getRandomNumber();
		String data = eLib.getDataFromExcel("Organization", 1, 1)+value;
		cop.FillOrgNametextBox(data);
		cop.getSaveButton().click();
		String text = oip.getVerifyOrgText().getText();
		//SoftAssert sa=new SoftAssert();
		assertTrue(text.contains(data));
		System.out.println("organization created");
		//Assert.fail();
	}

}


//preserve order


