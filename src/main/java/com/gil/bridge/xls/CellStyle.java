package com.gil.bridge.xls;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

/**
 * Created by IntelliJ IDEA.
 * User: anya.grinberg
 * Date: 13/01/15
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
public class CellStyle {
    private XSSFCellStyle cellStyle;

    public CellStyle(XSSFCellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    public CellStyle setAlignment(short val) {
        cellStyle.setAlignment(val);
        return this;
    }

    public CellStyle setBorderTop(short val) {
        cellStyle.setBorderTop(val);
        return this;
    }

    public CellStyle setBorderLeft(short val) {
        cellStyle.setBorderLeft(val);
        return this;
    }

    public CellStyle setBorderRight(short val) {
        cellStyle.setBorderRight(val);
        return this;
    }

    public CellStyle setBorderBottom(short val) {
        cellStyle.setBorderBottom(val);
        return this;
    }

    public CellStyle setDataFormat(short val) {
        cellStyle.setDataFormat(val);
        return this;
    }

    public CellStyle setFont(Font val){
        cellStyle.setFont(val);
        return this;
    }

    public CellStyle setFillForegroundColor(int r, int g, int b) {
        cellStyle.setFillForegroundColor(new XSSFColor(new byte[]{(byte)r,(byte)g,(byte)b}));
        return this;
    }

    public CellStyle  setFillPattern(short fp){
        cellStyle.setFillPattern(fp);
        return this;
    }
}
