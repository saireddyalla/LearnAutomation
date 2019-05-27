package ReadExcelData;

import lib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args) throws Exception {
		ExcelDataConfig excel=new ExcelDataConfig("C:\\ExcelData\\TestData.xlsx");
		System.out.println(excel.getData(0, 0, 0));
	}

}
