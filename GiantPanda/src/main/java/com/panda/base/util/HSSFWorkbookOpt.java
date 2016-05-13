package com.panda.base.util;

import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class HSSFWorkbookOpt{
	static HSSFWorkbook exportHead(Object[][] twodimenHead,List<int[]> headCombine,Object[][] twodimenBody,List<int[]> bodyCombine){
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();// excel表
		sheet.setDefaultColumnWidth(20);
		HSSFCellStyle cellStyleHead = workbook.createCellStyle();// 表头单元格样式
		cellStyleHead.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyleHead.setWrapText(true);//单元格包围文本
		cellStyleHead.setFillPattern(HSSFCellStyle.FINE_DOTS);
		cellStyleHead.setFillForegroundColor(new HSSFColor.YELLOW().getIndex());//excel表头颜色，前景色和背景色要同事设置
		cellStyleHead.setFillBackgroundColor(new HSSFColor.YELLOW().getIndex());
		cellStyleHead.setBorderBottom((short) 1);//excel表头边框
		cellStyleHead.setBorderTop((short) 1);
		cellStyleHead.setBorderLeft((short) 1);
		cellStyleHead.setBorderRight((short) 1);
		HSSFCellStyle cellStyleBody = workbook.createCellStyle();// 表数据单元格样式
		cellStyleBody.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		cellStyleBody.setWrapText(true);
		cellStyleBody.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyleBody.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		int endIndex=addTwodimen(sheet,twodimenHead,0,cellStyleHead,headCombine);
		addTwodimen(sheet,twodimenBody,endIndex,cellStyleBody,bodyCombine);
		return workbook;
	}
	
	static  int addTwodimen(HSSFSheet sheet, Object[][] twodimen,
			int startIndex, HSSFCellStyle cellStyle,List<int[]> combine) {
		Row row = null;
		Cell cell = null;
		Object value = null;
		int endIndex = 0;//结束行
		for(int i=0;i<twodimen[0].length;i++)
		{
			row = sheet.createRow(i+startIndex);
			
			for(int j=0;j<twodimen.length;j++){
					cell = row.createCell(j);
					cell.setCellStyle(cellStyle);
					value = twodimen[j][i];
					if(null==value){
						continue;
					}
					//这里把数字型的都按Number保存，避免单元格出现左上角箭头
					if (value instanceof Integer) {
						cell.setCellType(0);// 0:Number 1:String ...
						cell.setCellValue((int) value);
					} else if (value instanceof Double || value instanceof Float) {
						cell.setCellType(0);// 0:Number 1:String ...
						cell.setCellValue((double) value);
					} else if (value instanceof BigDecimal) {
						cell.setCellType(0);// 0:Number 1:String ...
						cell.setCellValue(((BigDecimal) value).doubleValue());
					}
					else{
						cell.setCellValue((String)value);
					}
					//sheet.autoSizeColumn(j);
				}
			endIndex++;
		}
		if(null!=combine&& combine.size()>0)
		for(int i=0;i<combine.size();i++){
			int [] com=combine.get(i);
			sheet.addMergedRegion(new CellRangeAddress(startIndex+com[0],startIndex+com[1],com[2], com[3]));//hang lie
		}
		
		return endIndex;
	}
	
	
	
	
	
}
