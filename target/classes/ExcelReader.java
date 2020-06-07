package resources;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader{
	public static Object[][] dataReader(String sheetName) throws Exception
	{
		//FileInputStream fis=new FileInputStream("C:\\Users\\AnilY\\eclipse-workspace\\FrameworkDemo\\src\\main\\java\\resources\\datasheet.xlsx");
		FileInputStream fis=new FileInputStream("C:/Users/Public/dataexcel.xlsx");

		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int totalSheet=workbook.getNumberOfSheets();
		System.out.println(totalSheet);
		Object [][] obj = null;
		for(int i=0;i<totalSheet;i++)
		{
			if(workbook.getSheetAt(i).getSheetName().equals(sheetName))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				int rowCount=sheet.getLastRowNum();
				int colCount=sheet.getRow(0).getLastCellNum();
				System.out.println(rowCount);
				System.out.println(colCount);
				obj=new Object[rowCount][colCount];
				for(int k=0;k<rowCount;k++)
				{
					for(int j=0;j<colCount;j++)
					{
						obj[k][j]=sheet.getRow(k+1).getCell(j).toString();
						System.out.println(obj[k][j]);

					}
				}
		}
	}
		workbook.close();

		return obj;
		
	
}
}
