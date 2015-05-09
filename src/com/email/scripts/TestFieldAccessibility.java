package com.email.scripts;

import org.testng.annotations.Test;

import com.email.pom.FieldAccessibility;
import com.email.pom.iREPLoginPage;
import com.lib.ExcelLib;

/*  Owner			:		Udanka HS 
 * 	Email ID		:		udanka.hs@cognizant.com
 * 	Associate ID	:		266241
 * 	Organization	: 		Cognizant Technology Solutions	
*/
public class TestFieldAccessibility extends iREPSuperTestNG {
	@Test
	public void testPasswordReset() throws Exception {
		iREPLoginPage loginPage = new iREPLoginPage(driver);
		FieldAccessibility FieldAcce = new FieldAccessibility(driver);

		String xlPath = "D:/Selenium/Field Accessibility/Field Accessibility.xls";
		String OutputxlPath = "D:/Selenium/Field Accessibility/Field Accessibility_Output.xls";
		String InputSheetName = "Input";
		String OutputSheetName = "Output";
		
		int rowCount = ExcelLib.getRowCount(xlPath, InputSheetName);

		for (int j = 1; j <= rowCount; j++) {
			String iREPUname = ExcelLib.getCellValue(xlPath, InputSheetName, j, 0);
			String iREPpassword = ExcelLib.getCellValue(xlPath, InputSheetName, j, 1);
			String ObjectType = ExcelLib.getCellValue(xlPath, InputSheetName, j, 2);
			String ChooseView = ExcelLib.getCellValue(xlPath, InputSheetName, j, 3);
			String RecrdType = ExcelLib.getCellValue(xlPath, InputSheetName, j, 4);
			
			System.out.println(rowCount);
			
			loginPage.login(iREPUname, iREPpassword);
			
			int NumbrOfFields = FieldAcce.FieldList(RecrdType, ObjectType, ChooseView, OutputSheetName, OutputxlPath);
			
			String NumbrOfFieldsString = Integer.toString(NumbrOfFields);
			
			ExcelLib.writeExcel(OutputxlPath, InputSheetName, j, 5, NumbrOfFieldsString);
		}
//		driver.quit();
	}
}
