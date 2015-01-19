package com.email.scripts;

import org.testng.annotations.Test;

import com.email.pom.iREPEmailReset_Admin;
import com.email.pom.iREPLoginPage;
import com.lib.ExcelLib;

public class EmailResetScript extends iREPSuperTestNG 
{
	@Test
	public void testPasswordReset() throws Exception 
	{
		iREPLoginPage loginPage = new iREPLoginPage(driver);
		iREPEmailReset_Admin passwordReset = new iREPEmailReset_Admin(driver);

		String xlPath = "D:/Selenium/test data/Test Data_AutoDesk.xls";
		String sheetName = "Email Reset through User";

		String iREPUname = ExcelLib.getCellValue(xlPath, sheetName, 1, 0);
		String iREPpassword = ExcelLib.getCellValue(xlPath, sheetName, 1, 1);

		int rowCount = ExcelLib.getRowCount(xlPath, sheetName);

		loginPage.login(iREPUname, iREPpassword);

		for (int i = 1; i <= rowCount; i++) 
		{
			System.out.println(rowCount);
			String profileUsername = ExcelLib.getCellValue(xlPath, sheetName,i, 2);
			String emaiID = ExcelLib.getCellValue(xlPath, sheetName, i, 3);
			
			if (passwordReset.reset(profileUsername, emaiID))
			{
			ExcelLib.writeExcel(xlPath, sheetName, i, 4, "Email Updated");
			}
			else
			{
				ExcelLib.writeExcel(xlPath, sheetName, i, 4, "Not updated");
			}
		}
		driver.quit();
	}
}
