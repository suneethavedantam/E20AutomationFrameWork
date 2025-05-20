package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
* This class consists of generic method related to file operations
* @author Suneetha vedantam
*
*/
public class FileUtility {
	/**
	 * this method will read data from property  file and return the value
	 * to caller
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	
	public String readDataFromPropertyfile(String key) throws IOException

	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;	
	}
	
	/**
	 * This method will read data from excel file and return the value caller
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelfile(String sheetname,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw = sh.getRow(rowNo);
		Cell cl=rw.getCell(cellNo);
		String value=cl.getStringCellValue();
		return value;
	}
	
}
