package com.email.scripts;

import org.testng.annotations.Test;

import com.email.pom.iREPEmailReset_User;
import com.email.pom.iREPLoginPage;
import com.lib.ExcelLib;

public class EmailResetScript extends iREPSuperTestNG 
{
	@Test
	public void testPasswordReset() throws Exception 
	{
		iREPLoginPage loginPage = new iREPLoginPage(driver);
		iREPEmailReset_User passwordReset = new iREPEmailReset_User(driver);

		String xlPath = "D:/Selenium/test data/Test Data_AutoDesk.xls";
		String sheetName = "Email Reset through User";
		int rowCount = ExcelLib.getRowCount(xlPath, sheetName);

		for (int i = 1; i <= rowCount; i++) 
		{
			String iREPUname = ExcelLib.getCellValue(xlPath, sheetName ,i, 0);
			String iREPpassword = ExcelLib.getCellValue(xlPath,	sheetName, i, 1);

			String iREPeMAil = ExcelLib.getCellValue(xlPath, sheetName, i,2);

			loginPage.login(iREPUname, iREPpassword);
			passwordReset.reset(iREPeMAil);

			ExcelLib.writeExcel(xlPath, sheetName, i, 3, "Email Updated");
		}
		driver.quit();
	}
}
