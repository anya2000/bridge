package com.gil.bridge;

/**
 * Created by IntelliJ IDEA.
 * User: anya.grinberg
 * Date: 16/02/15
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public class Bridge3rdSheet extends BridgeLevelSheet{

    Bridge3rdSheet(BridgeWorkbook workbook, String sheetName) {
        super(workbook, sheetName);
        this.title3 = "מפלסי  מיסעה";
    }

    public void run() {
        fillParamTable(false);
    }
}
