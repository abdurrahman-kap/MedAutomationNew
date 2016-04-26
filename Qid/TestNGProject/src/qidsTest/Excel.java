package qidsTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel {
	//static int rowcount=0;
	public static String readFromExcel(int colNum,int rowNum) throws EncryptedDocumentException, InvalidFormatException, IOException{
	FileInputStream fis=new FileInputStream(Utilities.excelLoc);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(Utilities.sheetName);
	Row row=sh.getRow(rowNum);
	Cell cell=row.getCell(colNum);
	System.out.println(cell);
	cell.setCellType(Cell.CELL_TYPE_STRING); 
	String cellval=cell.getStringCellValue();
	return cellval;
	}
	
	public static int rowcount() throws InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(Utilities.excelLoc);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Utilities.sheetName);
		int  rowCnt=sh.getLastRowNum();
		return rowCnt;
	}
	public static void SetCellData(String Result,  int RowNum, int ColNum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		FileInputStream fis=new FileInputStream(Utilities.excelLoc);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Utilities.sheetName);
		
		Row row=sh.getRow(RowNum);
		if(row==null){
			row=sh.createRow(RowNum);
			
		}
		else{
			row=sh.getRow(RowNum);
			
		}
		Cell cell=row.createCell(ColNum);
		cell.setCellType(cell.CELL_TYPE_STRING);
		if(Result=="Fail"){
		CellStyle style =wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellValue(Result);
		cell.setCellStyle(style);
		}
		else{
			cell.setCellValue(Result);
		}
		
		FileOutputStream fos=new FileOutputStream(Utilities.excelLoc);
		wb.write(fos);
		fos.close();
		
	}

}
