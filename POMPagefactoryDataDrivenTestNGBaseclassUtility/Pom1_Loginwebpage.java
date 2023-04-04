package com.fw.POMPagefactoryDataDrivenTestNGBaseclassUtility;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Pom1_Loginwebpage 
{
	@FindBy (xpath="//input[@id='RememberMe']") private WebElement chkBox;
	@FindBy (xpath="//input[@id='Email']") private WebElement un;
	@FindBy (xpath="//input[@id='Password']") private WebElement pwd;
	@FindBy (xpath="//button[@type='submit']") private WebElement signinButton;

	
	public Pom1_Loginwebpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void titleValidation(String actTitle) throws EncryptedDocumentException, IOException
	{
		String expTitle=Utility.excelStringData("Sheet1", 2, 1);
		System.out.println(expTitle);
		Assert.assertEquals(expTitle, actTitle, "Expected and actual texts are different");
	}
	public void checkBoxValidation() throws EncryptedDocumentException, IOException
	{
		boolean expChkResult = Utility.execlBooleanData("Sheet1", 2, 2);
		boolean actChkResult = chkBox.isSelected();
		Assert.assertEquals(expChkResult, actChkResult);
	}
	
	public void enterUn() throws EncryptedDocumentException, IOException
	{
		un.clear();
		un.sendKeys(Utility.excelStringData("Sheet1", 2, 3));
	}
	public void enterPassword() throws EncryptedDocumentException, IOException
	{
		pwd.clear();
		pwd.sendKeys(Utility.excelStringData("Sheet1", 2, 4));  
	}
	public void clickSigninBtn()
	{
		signinButton.click();
	}
		
}
