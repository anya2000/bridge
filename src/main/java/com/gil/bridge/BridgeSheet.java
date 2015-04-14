package com.gil.bridge;


import com.gil.bridge.xls.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * User: anya.grinberg
 * Date: 11/01/15
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
public abstract class BridgeSheet {

    protected BridgeWorkbook workbook;
    protected BridgeParameters bridgeParams;
    protected String sheetName;
    protected XSSFSheet sheet;
    protected String firstSheetName;

    BridgeSheet(BridgeWorkbook workbook, String sheetName){
        this.workbook = workbook;
        bridgeParams = workbook.getBridgeParams();
        this.sheetName = sheetName;
        sheet = workbook.createSheet(sheetName);
        firstSheetName = workbook.getFirstSheet().getSheetName();
    }

    abstract public void run() ;

    protected XSSFCell getCell(int rowNo, int colNo) {
        XSSFRow row = sheet.getRow(rowNo - 1);
        if (row == null) {
            row = sheet.createRow(rowNo - 1);
        }
        XSSFCell cell = row.getCell(colNo - 1);
        if (cell == null) {
            cell = row.createCell(colNo - 1);
        }
        return cell;
    }

    protected XSSFCell getCell(String cellCoordinates) {
        int colNo = cellCoordinates.charAt(0) - 'A' + 1;
        int rowNo = Integer.parseInt(cellCoordinates.substring(1));

        XSSFRow row = sheet.getRow(rowNo - 1);
        if (row == null) {
            row = sheet.createRow(rowNo - 1);
        }
        XSSFCell cell = row.getCell(colNo - 1);
        if (cell == null) {
            cell = row.createCell(colNo - 1);
        }
        return cell;
    }

    protected XSSFCell setCellValue(int rowNo, int colNo, Object value, XSSFCellStyle style) {
        XSSFCell cell = getCell(rowNo, colNo);
        if (value instanceof String) {
            if (((String) value).startsWith("=")) {
                cell.setCellFormula(value.toString().substring(1));
            } else {
                cell.setCellValue(value.toString());
            }
        }
        if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }
        cell.setCellStyle(style);
        return cell;
    }

    protected XSSFCell setCellValue(String cellCoordinates, Object value, XSSFCellStyle style) {
        int colNo = cellCoordinates.charAt(0) - 'A' + 1;
        int rowNo = Integer.parseInt(cellCoordinates.substring(1));
        return setCellValue(rowNo, colNo, value, style);
    }


    protected CellStyle setCellValue(String cellCoordinates, Object value) {
        XSSFCell cell = getCell(cellCoordinates);
        if (value instanceof String) {
            if (((String) value).startsWith("=")) {
                cell.setCellFormula(value.toString().substring(1));
            } else {
                cell.setCellValue(value.toString());
            }
        }
        if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        }
        XSSFCellStyle cellStyle = workbook.getEmptyStyle();
        cell.setCellStyle(cellStyle);
        return new CellStyle(cellStyle);
    }


    protected XSSFCellStyle getCellStyle(int rowNo, int colNo) {
        XSSFCell cell = getCell(rowNo, colNo);
        XSSFCellStyle cellStyle = cell.getCellStyle();
        if (cellStyle == null) {
            cellStyle = workbook.getEmptyStyle();
            cell.setCellStyle(cellStyle);
        }
        return cellStyle;
    }

    protected XSSFCellStyle getCellStyle(String cellCoordinates) {
        int colNo = cellCoordinates.charAt(0) - 'A' + 1;
        int rowNo = Integer.parseInt(cellCoordinates.substring(1));
        XSSFCell cell = getCell(rowNo, colNo);
        XSSFCellStyle cellStyle = cell.getCellStyle();
        if (cellStyle == null) {
            cellStyle = workbook.getEmptyStyle();
            cell.setCellStyle(cellStyle);
        }
        return cellStyle;
    }

    protected static String resolveFormula(String formula) {
        try {
            Field[] fields = BridgeParameters.class.getFields();
            for (Field field : fields) {
                String val = field.get(null).toString();
                formula = formula.replaceAll(field.getName(), val);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return formula;
    }
}
