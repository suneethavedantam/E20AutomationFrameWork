package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of reusable methods related to java
 * @author suneetha vadantam
 * 
 */
public class JavaUtility {
	
	/**
	 * This method will capture current system date and return to the caller
	 * @return 
	 */
	public String getSystemDate()
	{
		Date d= new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String dateInFormat = f.format(d);
		return dateInFormat;
	}
}
