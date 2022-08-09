package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllRowDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("iPhone");
		int rowc = sheet.getLastRowNum();
		for(int i=0;i<=rowc;i++)
		{
			Row r=sheet.getRow(i);
			String col1 = r.getCell(0).getStringCellValue();
			String col2 = r.getCell(1).getStringCellValue();
			System.out.println(col1+"  "+col2);
			
		}
		
	}

}
