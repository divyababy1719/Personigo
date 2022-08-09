package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis=new FileInputStream("./data/TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
 Cell cell = wb.getSheet("iPhone").getRow(3).getCell(1);
 DataFormatter fr=new DataFormatter();
 String data = fr.formatCellValue(cell);
System.out.println(data);
/*Sheet sh = wb.getSheet("iPhone");
int rowc = sh.getLastRowNum();
for(int i=1;i<rowc;i++)
{
	for(int j=0;j<i;j++)
	{
		String un = wb.getSheet("iPhone").getRow(i).getCell(j).getStringCellValue();
		System.out.println(un);
			}
	
	

}*/
	}
}



