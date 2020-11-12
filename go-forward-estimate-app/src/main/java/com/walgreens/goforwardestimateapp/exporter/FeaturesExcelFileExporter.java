package com.walgreens.goforwardestimateapp.exporter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.walgreens.goforwardestimateapp.models.FeaturesComponent;
import com.walgreens.goforwardestimateapp.models.Items;
import com.walgreens.goforwardestimateapp.models.ProjectDetails;
import com.walgreens.goforwardestimateapp.models.QAComponent;
import com.walgreens.goforwardestimateapp.vo.Features;
import com.walgreens.goforwardestimateapp.vo.ItemsVO;
import com.walgreens.goforwardestimateapp.vo.ProjectDetailsVO;

public class FeaturesExcelFileExporter {

	public static ByteArrayInputStream exportFeaturesToExcel(ProjectDetails projectDetails) throws DecoderException {
		try (Workbook workbook = new XSSFWorkbook()) {

			List<FeaturesComponent> feature = projectDetails.getProjectFeaturesComponents();

			// System.out.println("******************Inside
			// Downloader*********************"+projectDetails.toString());
			// System.out.println(feature.toString());
			List<Items> itemsVo = new ArrayList<Items>();
			List<QAComponent> qaComponent = new ArrayList<QAComponent>();
			// System.out.println("\n"+itemsVo.toString());
			for (int x = 0; x < feature.size(); x++) {
				itemsVo.addAll(feature.get(x).getDevComponents());
			}
			for (FeaturesComponent features : feature) {
				qaComponent.addAll(features.getQaComponents());
			}

			Sheet sheet = workbook.createSheet("Features List");
			
            // set the row colors
			String[] colors = { "99bbff", "ffa64d" ,"ffd1b3", "ccebff"};
			byte[] rgbB = Hex.decodeHex(colors[0]);
			XSSFColor color = new XSSFColor(rgbB, null);
			byte[] rgbB1 = Hex.decodeHex(colors[1]);
			XSSFColor colorTest = new XSSFColor(rgbB1, null);
			byte[] rgbB2 = Hex.decodeHex(colors[3]);
			XSSFColor colordev = new XSSFColor(rgbB2, null);
			byte[] rgbB3 = Hex.decodeHex(colors[2]);
			XSSFColor colorqa = new XSSFColor(rgbB3, null);

			
			//set the row font
			XSSFFont font = (XSSFFont) workbook.createFont();
			font.setBold(true);
            
			
			//create rows
			
			Row row = sheet.createRow(1);
			row.setHeight((short) 500);
            
			
			
			//style the rows
			XSSFCellStyle headerCellStyle = (XSSFCellStyle) workbook.createCellStyle();
			headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
			headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			headerCellStyle.setFillForegroundColor(color);
			headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerCellStyle.setBorderBottom(BorderStyle.MEDIUM);
			headerCellStyle.setBorderLeft(BorderStyle.MEDIUM);
			headerCellStyle.setBorderRight(BorderStyle.MEDIUM);
			headerCellStyle.setBorderTop(BorderStyle.MEDIUM);
			headerCellStyle.setFont(font);

			XSSFCellStyle headerCellTesting = (XSSFCellStyle) workbook.createCellStyle();
			headerCellTesting.setAlignment(HorizontalAlignment.CENTER);
			headerCellTesting.setVerticalAlignment(VerticalAlignment.CENTER);
			headerCellTesting.setFillForegroundColor(colorTest);
			headerCellTesting.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerCellTesting.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerCellTesting.setBorderBottom(BorderStyle.MEDIUM);
			headerCellTesting.setBorderLeft(BorderStyle.MEDIUM);
			headerCellTesting.setBorderRight(BorderStyle.MEDIUM);
			headerCellTesting.setBorderTop(BorderStyle.MEDIUM);
			headerCellTesting.setFont(font);
			
			XSSFCellStyle devStyle= (XSSFCellStyle) workbook.createCellStyle();
			devStyle.setAlignment(HorizontalAlignment.CENTER);
			devStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			devStyle.setFillForegroundColor(colordev);
			devStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			devStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			devStyle.setBorderBottom(BorderStyle.MEDIUM);
			devStyle.setBorderLeft(BorderStyle.MEDIUM);
			devStyle.setBorderRight(BorderStyle.MEDIUM);
			devStyle.setBorderTop(BorderStyle.MEDIUM);
			devStyle.setFont(font);
			
			XSSFCellStyle qaStyle= (XSSFCellStyle) workbook.createCellStyle();
			qaStyle.setAlignment(HorizontalAlignment.CENTER);
			qaStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			qaStyle.setFillForegroundColor(colorqa);
			qaStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			qaStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			qaStyle.setBorderBottom(BorderStyle.MEDIUM);
			qaStyle.setBorderLeft(BorderStyle.MEDIUM);
			qaStyle.setBorderRight(BorderStyle.MEDIUM);
			qaStyle.setBorderTop(BorderStyle.MEDIUM);
			qaStyle.setFont(font);
			
			Row row1 = sheet.createRow(0);

			Cell cell1 = row1.createCell(1);
			cell1.setCellValue("Development Parameters");
			cell1.setCellStyle(devStyle);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 6));
			Cell cell2 = row1.createCell(7);
			cell2.setCellStyle(qaStyle);
			cell2.setCellValue("Testing Parameters");
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 10));
			
			
			

            // set coloumn headings
			Cell cell = row.createCell(0);
			cell.setCellValue("Feature Name");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(1);
			cell.setCellValue("Item Name");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(2);
			cell.setCellValue("Item Type");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(3);
			cell.setCellValue("Technology");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(4);
			cell.setCellValue("New/Modify");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(5);
			cell.setCellValue("Component Complexity");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(6);
			cell.setCellValue("Degree of change");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(7);
			cell.setCellValue("Test Data Complexity");
			cell.setCellStyle(headerCellTesting);

			cell = row.createCell(8);
			cell.setCellValue("Validation Complexity");
			cell.setCellStyle(headerCellTesting);

			cell = row.createCell(9);
			cell.setCellValue("Requirement Complexity");
			cell.setCellStyle(headerCellTesting);

			cell = row.createCell(10);
			cell.setCellValue("Validation Point#");
			cell.setCellStyle(headerCellTesting);

			cell = row.createCell(11);
			cell.setCellValue("Estimation type");
			cell.setCellStyle(headerCellStyle);
			
			// enter data

			for (int i = 0; i < itemsVo.size(); i++) {
				Row dataRow = sheet.createRow(i + 2);

				// dataRow.createCell(0).setCellValue(projectDetails.getProjectName());

				dataRow.createCell(1).setCellValue(itemsVo.get(i).getItemName());
				dataRow.createCell(2).setCellValue(itemsVo.get(i).getItemType());
				dataRow.createCell(3).setCellValue(itemsVo.get(i).getTechnologyForItem());
				dataRow.createCell(4).setCellValue(itemsVo.get(i).getNewOrModify());
				dataRow.createCell(5).setCellValue(itemsVo.get(i).getComponentComplexityForItem());
				dataRow.createCell(6).setCellValue(itemsVo.get(i).getDegreeOfChangesForItem());
			}
			for (int x = 0; x < feature.size(); x++) {
				Row dataRow = sheet.getRow(x + 2);

				dataRow.createCell(0).setCellValue(feature.get(x).getFeatureName());
			}
			for (int z = 0; z < qaComponent.size(); z++) {
				Row dataRow = sheet.getRow(z + 2);
				dataRow.createCell(7).setCellValue(qaComponent.get(z).getTestDataComplexity());
				dataRow.createCell(8).setCellValue(qaComponent.get(z).getValidationComponent());
				dataRow.createCell(9).setCellValue(qaComponent.get(z).getRequirementComplexity());
				dataRow.createCell(10).setCellValue(qaComponent.get(z).getValidationPoints());
			}

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);
			sheet.autoSizeColumn(7);
			sheet.autoSizeColumn(8);
			sheet.autoSizeColumn(9);
			sheet.autoSizeColumn(10);
			sheet.autoSizeColumn(11);

			ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
			workbook.write(outputstream);

			return new ByteArrayInputStream(outputstream.toByteArray());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
