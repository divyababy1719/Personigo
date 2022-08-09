package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetIntegerValueFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int row = wb.getSheet("iPhone").getLastRowNum();
		for(int i=1;i<=row;i++)
		{
		 double rowc = wb.getSheet("iPhone").getRow(i).getCell(2).getNumericCellValue();
		 System.out.println(rowc);
		}
		
	}

}
