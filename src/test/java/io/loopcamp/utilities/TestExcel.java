package io.loopcamp.utilities;

public class TestExcel {

    public static void main(String[] args) {
        //ExcelUtils excelUtils = new ExcelUtils("/home/eyadq/Downloads/Sample.xlsx", "Nadir");
        ExcelUtils excelUtils = new ExcelUtils("/home/eyadq/Desktop/stuff/sample.xlsx", "Sheet1");
        System.out.println("excelUtils.getCellData(1, 2) = " + excelUtils.getCellData(1, 1));
    }
}
