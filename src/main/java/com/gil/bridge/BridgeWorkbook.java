package com.gil.bridge;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontCharset;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anya.grinberg
 * Date: 11/01/15
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
public class BridgeWorkbook {
    private XSSFWorkbook wb;
    private BridgeParameters bridgeParams;

    private String mainFont = "David";
    private String greekFont = "Arial Narrow";


    public void run() {

        //3.;  //מפלסי מיסעת בטון
        //https://www.branah.com/unicode-converter
        List<BridgeSheet> sheets = new ArrayList();
        sheets.add(new Bridge1stSheet(this, "\u05de\u05e4\u05dc\u05e1\u05d9\u05dd \u05d1\u05e6\u05d9\u05e8 \u05db\u05d1\u05d9\u05e9"));   //מפלסים בציר כביש
        sheets.add(new Bridge2ndSheet(this," \u05de\u05e4\u05dc\u05e1\u05d9 \u05d0\u05e1\u05e4\u05dc\u05d8 \u05d5\u05d1\u05d8\u05d5\u05df"));   //מפלסי אספלט ובטון
        sheets.add(new Bridge3rdSheet(this, "\u05de\u05e4\u05dc\u05e1\u05d9 \u05de\u05d9\u05e1\u05e2\u05ea \u05d1\u05d8\u05d5\u05df"));   //מפלסי מיסעת בטון

        for (BridgeSheet sheet : sheets){
            sheet.run();
        }
        writeToFile(wb);

    }


    BridgeWorkbook(BridgeParameters bridgeParams) {
        wb = new XSSFWorkbook();
        this.bridgeParams = bridgeParams;
    }

    public BridgeParameters getBridgeParams() {
        return bridgeParams;
    }
    public  XSSFFont getBodyFont(){
        XSSFFont font = wb.createFont();
        font.setFontName(mainFont);
        font.setFontHeightInPoints((short) 12);
        font.setCharSet(FontCharset.HEBREW);
        font.setFamily(FontFamily.SCRIPT);
        return font;
    }
    public XSSFFont getGreekFont() {
        XSSFFont font = wb.createFont();
        font.setFontName(greekFont);
        font.setFontHeightInPoints((short) 12);

        return font;
    }
    public XSSFFont getHeader1Font() {
        XSSFFont font = getBodyFont();
        font.setFontHeightInPoints((short) 14);
        return font;
    }

    public XSSFFont getHeader2Font() {
        XSSFFont font = getBodyFont();
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        return font;
    }

    public XSSFFont getParamFont() {
        XSSFFont font = getBodyFont();
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setColor(new XSSFColor(new java.awt.Color(0, 0, 255)));

        return font;
    }

    public XSSFCellStyle getHeader1Style() {
        XSSFCellStyle header1Style = wb.createCellStyle();
        XSSFFont font = getBodyFont();
        font.setFontHeightInPoints((short) 14);
        header1Style.setFont(font);
        return header1Style;
    }

    public XSSFCellStyle getHeader2Style() {
        XSSFCellStyle header2Style = wb.createCellStyle();
        XSSFFont font = getBodyFont();
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        header2Style.setFont(font);
        return header2Style;
    }

    public XSSFCellStyle getBodyStyle() {
        XSSFCellStyle bodyStyle = wb.createCellStyle();
        bodyStyle.setFont(getBodyFont());

        return bodyStyle;
    }

    public XSSFCellStyle getParamStyle() {
        XSSFCellStyle paramStyle = wb.createCellStyle();
        XSSFFont font = getBodyFont();
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setColor(new XSSFColor(new java.awt.Color(0, 0, 255)));
        paramStyle.setFont(font);

        return paramStyle;
    }

    public XSSFCellStyle getEmptyStyle() {
        return wb.createCellStyle();
    }

    public XSSFCellStyle getGreekStyle() {
        XSSFCellStyle greekStyle = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontName(greekFont);
        font.setFontHeightInPoints((short) 12);
        greekStyle.setFont(font);

        return greekStyle;
    }

    public short getDataFormat(String format) {
        XSSFDataFormat f = wb.createDataFormat();
        return f.getFormat(format);
    }


    XSSFSheet createSheet(String sheetName) {
        return wb.createSheet(sheetName);
    }

    XSSFSheet getFirstSheet() {
        return wb.getSheetAt(0);
    }

    public void writeToFile(XSSFWorkbook wb) {
        try {
            String fileName = "c:/src/bridge/a.xlsx";
            OutputStream fos = new BufferedOutputStream(new FileOutputStream(fileName));
            wb.write(fos);
            IOUtils.closeQuietly(fos);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


}
