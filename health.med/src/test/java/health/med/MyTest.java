package health.med;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class MyTest {
	
	private Map<String,String> cook;
	
	@BeforeClass
	public void beforeClass(){
	
		String url = "http://qwjasweb02.kaplaninc.com/loginV8.aspx";
		String loginpost = "<login userName='smuppidi' password='smuppidi' kecuserName='abrahman' kecpassword='Nusrat1234!' rememberLogin='no' instance='' productName='USMLEStep1Qbank2010' assetName='main' />";
		cook =  given()
						.headers("Accept", "application/xml")
						.contentType("text/xml")
						.body(loginpost)
				.when()
					.post(url)
					.cookies();
	}
	
	@Test(dataProvider = "dp1")
	public void myTest(String qId, String reviewedOn){
		
		System.out.print("QID:" + qId);
		System.out.print("   |   ");
		System.out.print("ReviewedOn:" + reviewedOn);
		System.out.println();
		
		given()
			.headers("Accept", "application/xml")
			.cookies(cook)
		.when()
			.get("http://qwjasweb02.kaplaninc.com/apps/delivery/contentitemv2.aspx?format=xml&name=OL2087")
		.then()
			.log().all()
			.body(hasXPath("/question/explanation/para[2]/emphasis"), containsString(reviewedOn))
		;
		
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
						if(cell2 != null){
							reviewedOn = cell2.toString();
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
	
	
	@Test
	public void test6(){
		
		given()
			.headers("Accept", "application/xml")
			.cookies(cook)
		.when()
			.get("http://qwjasweb02.kaplaninc.com/apps/delivery/contentitemv2.aspx?format=xml&name=SQ1026m")
		.then()
			.log().all()
			.body(hasXPath("/question/explanation/para[2]/emphasis"), containsString("Updated on 12/01/14"))
		;

}
	@Test
	public void test5(){
		
		given()
			.headers("Accept", "application/xml")
			.cookies(cook)
		.when()
			.get("http://qwjasweb02.kaplaninc.com/apps/delivery/contentitemv2.aspx?format=xml&name=SQ1026m")
		.then()
			.log().all()
			.body(hasXPath("/question/explanation/para[2]/emphasis"), containsString("Updated on 11/26/14"))
		;

}
	@Test
	public void test4(){
		
		given()
			.headers("Accept", "application/xml")
			.cookies(cook)
		.when()
			.get("http://qwjasweb02.kaplaninc.com/apps/delivery/contentitemv2.aspx?format=xml&name=OL1511")
		.then()
			.log().all()
			.body(hasXPath("/question/explanation/para[2]/emphasis"), containsString("Updated on 12/03/14"))
		;

}
	
	@Test
	public void test3(){
		
		given()
			.headers("Accept", "application/xml")
			.cookies(cook)
		.when()
			.get("http://qwjasweb02.kaplaninc.com/apps/delivery/contentitemv2.aspx?format=xml&name=OL1912m")
		.then()
			.log().all()
			.body(hasXPath("/question/explanation/para[2]/emphasis"), containsString("Updated on 12/01/14"))
		;
	
	}
	
	@Test
	public void test2(){
		
		given()
			.headers("Accept", "application/xml")
			.cookies(cook)
		.when()
			.get("http://qwjasweb02.kaplaninc.com/apps/delivery/contentitemv2.aspx?format=xml&name=OL966")
		.then()
			.log().all()
			.body(hasXPath("/question/explanation/para[6]/emphasis"), containsString("Reviewed on 08/13/14"))
		;

	}
	
	@Test
	public void test1(){
		
		given()
			.headers("Accept", "application/xml")
			.cookies(cook)
		.when()
			.get("http://qwjasweb02.kaplaninc.com/apps/delivery/contentitemv2.aspx?format=xml&name=OL203m")
		.then()
			.log().all()
			.body(hasXPath("/question/explanation/para[2]/emphasis"), containsString("Updated on 12/01/14"))
		;

	}
	
}
