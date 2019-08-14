package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BasePackage.DriverClass;

public class ExcelReader extends DriverClass{
	

	/**
	 * Read data from Excel sheet 
	 */
	  
		HSSFWorkbook workbook;
		HSSFSheet sheet;
		XSSFCellStyle cell;
		public String cellValue ;
	

		//Read the data from excel sheet
		/**
		 * 
		 * @param sheetNo
		 * @param row
		 * @param column
		 * @return
		 * @throws IOException
		 */
		public String readFromExcel (int sheetNo, int row, int column) throws IOException{
			 // Import excel sheet.
			try {
				
			 String TestData_PepperCloud = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData_PepperCloud.xls";
			System.out.println(TestData_PepperCloud);
			 // Load the file.
			 FileInputStream finput = new FileInputStream(TestData_PepperCloud);
			 
			 
			 // Load he workbook.
			workbook = new HSSFWorkbook(finput);
			
			 
		     // Load the sheet in which data is stored.
			 sheet= workbook.getSheetAt(sheetNo);
			 
			 for(int i=1; i<=sheet.getLastRowNum(); i++)
			 {
				 // Import data for Email.
				 HSSFCell Cell = sheet.getRow(row).getCell(column); 
				 try {
					 cellValue = Cell.getStringCellValue().trim().toString();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					cellValue =  ((int)Cell.getNumericCellValue())+"".trim();
					//cellValue =  String.valueOf((int)Cell.getNumericCellValue()).trim();
					e.printStackTrace();
				} 
			 }
			 

		}
			catch (Exception e){
				System.out.println("Error found while reading from excel sheet"); 
			}
			return cellValue;
	}
		
		
		public List<List<HSSFCell>> getSheetData(int sheetNumber) {
			String filename = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData_PepperCloud.xls";
			List<List<HSSFCell>> sheetData = new ArrayList<List<HSSFCell>>();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(filename);
				HSSFWorkbook workbook = new HSSFWorkbook(fis);
				HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
				Iterator rows = sheet.rowIterator();
				while (rows.hasNext()) {
					HSSFRow row = (HSSFRow) rows.next();
					Iterator<Cell> cells = (row.cellIterator());
					List<HSSFCell> data = new ArrayList<HSSFCell>();
					while (cells.hasNext()) {
						HSSFCell cell = (HSSFCell) cells.next();
						if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
					    }
						data.add(cell);
					}
					sheetData.add(data);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return sheetData;
		}
		
		public void writeToExcel(int SheetNo,int row,int column, String value) throws IOException{
			String filename = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData_PepperCloud.xls";
			FileInputStream file = new FileInputStream (new File(filename));
					HSSFWorkbook workbook = new HSSFWorkbook(file);
					HSSFSheet sheet = workbook.getSheetAt(SheetNo);
					//'Read data from excel'
					//String Data_fromCell=sheet.getRow(row).getCell(column).getStringCellValue();
					//'Write data to excel'
					sheet.getRow(row).createCell(column).setCellValue(value);
					file.close();
					FileOutputStream outFile =new FileOutputStream(new File(filename));
					workbook.write(outFile);
					outFile.close();
		}
	
	}
				 
			
		
