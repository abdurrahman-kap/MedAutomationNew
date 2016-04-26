package health.med;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasXPath;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;

public class MedTest {
private Map<String,String> cookies;
	
	@BeforeClass
	public void beforeClass(){
		
		RestAssured.baseURI = "http://qwjasweb02.kaplaninc.com";
		
		
		String path = "/loginV8.aspx";
		String loginpost = "<login userName='abrahman' password='abrahman' kecuserName='abrahman' kecpassword='Nusrat1234!@#' rememberLogin='no' instance='' productName='USMLEStep1Qbank2010' assetName='main' />";
		cookies =  given()
						.headers("Accept", "application/xml")
						.contentType("text/xml")
						.body(loginpost)
				.when()
					.post(path)
					.cookies();
		
	}
	
	
	@Test(dataProvider = "dp1")
	public void myTest(String qId, String reviewedOn){
		
		System.out.print("QID:" + qId);
		System.out.print("   |   ");
		System.out.print("ReviewedOn:" + reviewedOn);
		System.out.println();
		
		if(qId != null){
			String path = "/apps/delivery/contentitemv2.aspx?format=xml&name=" + qId;
			given()
				.headers("Accept", "application/xml")
				.cookies(cookies)
			.when()
				.get(path)
			.then()
				//.log().all()
				.body(hasXPath("/question/explanation/para[5]/emphasis"), containsString(reviewedOn))
			;
		}
		/**/
		
	}
	
	@DataProvider(name="dp1")
	public Object[][] readTestData(){
		
		String [][] data = null;
		
		String fileName = System.getProperty("user.dir") +  System.getProperty("file.separator") +
				          "src" +  System.getProperty("file.separator")  + "test" +  System.getProperty("file.separator") +
				          "resources" +  System.getProperty("file.separator") + "testData" +  System.getProperty("file.separator") +
				          "Health Content QA Automation Script Data.xlsx";
		
		File file = new File(fileName);
		if(file.exists()){
			
			try {
				 FileInputStream fis = new FileInputStream(file);
			     XSSFWorkbook wb = new XSSFWorkbook(fis);
			     XSSFSheet ws = wb.getSheet("USMLEStep1Qbank2010");

			        int rowNum = ws.getLastRowNum();
			        int colNum = ws.getRow(0).getLastCellNum();
			        
			        data = new String [rowNum] [2];
		
			        String qId = null;
					String reviewedOn = null;
					
				for (int i = 1; i < rowNum; i++) {
					XSSFRow row = ws.getRow(i);
					if (row != null) {
						XSSFCell cell1 = row.getCell(0);
						if(cell1 != null){
							qId = cell1.toString();
						}

						XSSFCell cell2 = row.getCell(1);
						if(cell2 != null && DateUtil.isCellDateFormatted(cell2)){
							//DataFormatter formatter = new DataFormatter(Locale.US);
							//reviewedOn = formatter.formatCellValue(cell2).toString();
							
							SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yy");
							reviewedOn = dtFormat.format(cell2.getDateCellValue()).toString();
							
						}

						data[i - 1][0] = qId;
						data[i - 1][1] = reviewedOn;
						
					}
				}

					
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
				
		}
		return data;
	}
	
}
