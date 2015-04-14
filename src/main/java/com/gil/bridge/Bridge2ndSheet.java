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
        this.title3 = "מפלסים בציר ושפות כרכובים";
    }

    public void run() {
        fillParamTable(false);
    }
}
