package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
	 Cell cell = wb.getSheet("iPhone").getRow(1).createCell(2);
	 
	 
	 cell.setCellValue("sold");
	 DataFormatter fr=new DataFormatter();
	 String data = fr.formatCellValue(cell);
	 System.out.println(data);
		FileOutputStream fo=new FileOutputStream("./data/TestData.xlsx");
		wb.write(fo);
		wb.close();
	}

}
