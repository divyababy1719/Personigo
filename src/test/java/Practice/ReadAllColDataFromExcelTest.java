package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllColDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("iPhone");
		int rowc = sheet.getLastRowNum();
		DataFormatter formats=new DataFormatter();
		
		 String eresult = "Iphone3";
		 for(int i=0;i<=rowc;i++)
		 {
			 Row row = sheet.getRow(i);
			 String value = formats.formatCellValue(sheet.getRow(1).getCell(i));
			 System.out.println(value);
			 
			String fdata=row.getCell(0).getStringCellValue();
			if(fdata.equals(eresult))
			{
				String sdata = row.getCell(1).getStringCellValue();
				System.out.println(sdata);
				
			}
			 
		 }
		
	}

}
