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
        //מפלסי  מיסעה
        this.title3 = "\u05de\u05e4\u05dc\u05e1\u05d9  \u05de\u05d9\u05e1\u05e2\u05d4";
    }

    public void run() {
        putParamTable(false);
    }
}
