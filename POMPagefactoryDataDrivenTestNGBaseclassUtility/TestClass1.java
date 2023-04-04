package com.fw.POMPagefactoryDataDrivenTestNGBaseclassUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass1 extends Baseclass
{
	Pom1_Loginwebpage p1;
	Pom2_DashBoard p2;
	
	@BeforeClass
	public void Browseropening() throws EncryptedDocumentException, InterruptedException, IOException
	{
		browserlaunch();
		p1 = new Pom1_Loginwebpage(driver);
		p2 = new Pom2_DashBoard(driver);
	}
	
	@Test
	public void TitleVerify() throws EncryptedDocumentException, IOException 
	{
		p1.titleValidation(driver.getTitle());
	}
	@Test
	public void checkboxVerify() throws EncryptedDocumentException, IOException
	{
		p1.checkBoxValidation();
	}
	@Test
	public void loginVerify() throws EncryptedDocumentException, IOException, InterruptedException
	{
		p1.enterUn();
		Thread.sleep(2000);
		p1.enterPassword();
		Thread.sleep(2000);
		p1.clickSigninBtn();
		Thread.sleep(2000);
	}
	@Test (dependsOnMethods = "loginVerify")		//dashboard
	public void logoVerify() throws IOException
	{
		p2.logoValidation(driver);
	}
	@AfterClass
	public void BrowserClose()
	{
	driver.close();
	}
	}

