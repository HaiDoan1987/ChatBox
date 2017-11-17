package Utility;

/**
 * Created by hai.dq on 11/9/2017.
 */
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtils {


    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static void setExcelFile(String Path, String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e) {

            throw (e);

        }

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

   /* public static String getCellData(int RowNum, int ColNum) throws Exception {

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = Cell.getStringCellValue();

            return CellData;

        } catch (Exception e) {

            return "";

        }*/



    //This method is to write in the Excel cell, Row num and Col num are the parameters
    public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

        try {

            Row = ExcelWSheet.getRow(RowNum);

            Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

            if (Cell == null) {

                Cell = Row.createCell(ColNum);

                Cell.setCellValue(Result);

            } else {

                Cell.setCellValue(Result);

            }

            // Constant variables Test Data path and Test Data file name

            FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

            ExcelWBook.write(fileOut);

            fileOut.flush();

            fileOut.close();

        } catch (Exception e) {

            throw (e);

        }

    }

    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

        String[][] tabArray = null;

        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 1;

            int startCol = 1;

            int ci, cj;

            int totalRows = ExcelWSheet.getLastRowNum();

            // you can write a function as well to get Column count

            int totalCols = ExcelWSheet.getRow(0).getLastCellNum()-1;
            System.out.println("value of totalCols "+totalCols);
            tabArray = new String[totalRows][totalCols];

            ci = 0;

            for (int i = startRow; i <= totalRows; i++, ci++) {

                cj = 0;

                for (int j = startCol; j <= totalCols; j++, cj++) {

                    tabArray[ci][cj] = getCellData(i, j);

                    System.out.println(tabArray[ci][cj]);

                }

            }
        } catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }
        return (tabArray);
    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try{

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = Cell.getStringCellValue();

            return CellData;

        }catch (Exception e){

            return"";

        }
    }


    public static Object[][] getUserSay(String FilePath, String SheetName,String sKeyStart, String sKeyEnd) throws Exception {

        Object[][] tabArray = null;

        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 0;
            int endRow =0;
            String keyStart = sKeyStart;
            String keyEnd = sKeyEnd;

            int cj=0;
            int totalRows = ExcelWSheet.getLastRowNum();
            for (int i = 0; i <= totalRows; i++) {
                if (getCellData(i, 0).equals(keyStart)) {
                    System.out.println("value is " + getCellData(i, 0));
                    startRow = i+1;
                }
                if (getCellData(i, 0).equals(keyEnd)) {
                    System.out.println("value is " + getCellData(i, 0));
                    endRow = i-1;
                    break;
                }
            }
            System.out.println("value is startRow " + startRow);
            System.out.println("value is endRow " + endRow);
            for(int k =startRow;k < endRow;k++ ) {
                if (getCellData(k, 0).isEmpty() == false ) {
                    cj++;
                }
            }
            System.out.println("value of cj "+cj);

            tabArray = new String[cj][1];
           int  cf =0;
            for (int j = startRow; j < endRow; j++) {
                if (getCellData(j, 0).isEmpty() == false) {
                    tabArray[cf][0] = getCellData(j, 0);
                    cf++;
                }
            }
        }


        catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return (tabArray) ;
    }
    public static Object[] getExpectedBotMessage(String FilePath, String SheetName,String sKeyStart, String sKeyEnd,String sKey) throws Exception {

        Object[] tabArray = null;

        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 0;
            int endRow = 0;
            String keyStart = sKeyStart;
            String keyEnd = sKeyEnd;

            int cj = 0;
            int totalRows = ExcelWSheet.getLastRowNum();
            // Search khoảng cách giữa 2 test case
            for (int i = 0; i <= totalRows; i++) {
                if (getCellData(i, 0).equals(keyStart)) {
                    System.out.println("value of " + i+  " is " + getCellData(i, 0));
                    startRow = i;
                }
                if (getCellData(i, 0).equals(keyEnd)) {
                    System.out.println("value of " + i +  " is " + getCellData(i, 0));
                    endRow = i;
                    break;
                }
            }

            // Search vị trí parameter sKey theo khoảng cách giữa 2 test case, and looking for array value[]
            for (int m = startRow; m <= endRow; m++) {
                if (getCellData(m, 1).equals(sKey)) {
                    System.out.println("value of m "+m+" is " + getCellData(m, 1));
                    startRow = m ;
                    cj++;
                }

            }
                endRow = startRow;

                startRow = endRow-cj+1;

                System.out.println("value is startRow " + startRow);

                System.out.println("value is endRow " + endRow);

                System.out.println("value of cj " + cj);

                tabArray = new String[cj];

                int cf = 0;

                for (int j = startRow; j <= endRow; j++) {
                    if (getCellData(j, 1).equals(sKey)) {
                    tabArray[cf] = getCellData(j, 2);
                    cf++;
                    }
                }
        }
        catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return tabArray ;
    }

    public static Object[] getDataBaseKeyword(String FilePath, String SheetName,String sKeyStart, String sKeyEnd,String sKey) throws Exception {

            Object[] tabArray = null;

        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 0;
            int endRow = 0;
            String keyStart = sKeyStart;
            String keyEnd = sKeyEnd;

            int cj = 0;
            int totalRows = ExcelWSheet.getLastRowNum();
            // Search khoảng cách giữa 2 test case
            for (int i = 0; i <= totalRows; i++) {
                if (getCellData(i, 0).equals(keyStart)) {
                    startRow = i;
                }
                if (getCellData(i, 0).equals(keyEnd)) {
                    endRow = i;
                    break;
                }
            }
            String forceKey = null;
            // Search vị trí parameter sKey theo khoảng cách giữa 2 test case, and looking for array value[]
            if(sKey.equals("quick_reply_Id")){
                 forceKey = "quick_reply";
                for (int m = startRow; m <= endRow; m++) {
                    if (getCellData(m, 1).equals(forceKey)) {
                        startRow = m;
                        cj++;
                    }
                }
            }else {
                for (int m = startRow; m <= endRow; m++) {
                    if (getCellData(m, 1).equals(sKey)) {
                        startRow = m;
                        cj++;
                    }
                }
            }
            endRow = startRow;

            startRow = endRow - cj + 1;

           // System.out.println("value is startRow " + startRow);

           // System.out.println("value is endRow " + endRow);

            //System.out.println("value of cj " + cj);
            tabArray = new String[cj];
            int cf = 0;
            if (sKey.equals("quick_reply_Id")) {
                for (int j = startRow; j <= endRow; j++) {
                    if (getCellData(j, 1).equals(forceKey)) {
                        tabArray[cf] = getCellData(j, 3);
                        cf++;
                    }
                }
            } else {
                for (int j = startRow; j <= endRow; j++) {
                    if (getCellData(j, 1).equals(sKey)) {
                        tabArray[cf] = getCellData(j, 2);
                        cf++;
                    }
                }
            }
        }
        catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }
        return tabArray ;
    }


@Test
    public void testtest() throws Exception {
    Object[] expectedFirstTimeQuickButtonId = ExcelUtils.getDataBaseKeyword(Constant.Path_TestData+Constant.File_TestData,
            "Sheet26","Event-Welcome","FAQ-Common-x1","quick_reply_Id");
    for (int i = 0; i < expectedFirstTimeQuickButtonId.length; i++) {
            System.out.println(expectedFirstTimeQuickButtonId[i]);

    }
}
}
