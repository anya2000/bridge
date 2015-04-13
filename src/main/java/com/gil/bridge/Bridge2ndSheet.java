package com.gil.bridge;

/**
 * Created by IntelliJ IDEA.
 * User: anya.grinberg
 * Date: 16/02/15
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public class Bridge2ndSheet  extends BridgeLevelSheet{

    Bridge2ndSheet(BridgeWorkbook workbook, String sheetName) {
        super(workbook, sheetName);
        //מפלסים בציר ובשפות כרכובים
        this.title3 = "\u05de\u05e4\u05dc\u05e1\u05d9\u05dd \u05d1\u05e6\u05d9\u05e8 \u05d5\u05d1\u05e9\u05e4\u05d5\u05ea \u05db\u05e8\u05db\u05d5\u05d1\u05d9\u05dd";
    }

    public void run() {
        putParamTable(false);
    }
}
