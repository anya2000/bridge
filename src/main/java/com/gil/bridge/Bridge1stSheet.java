package com.gil.bridge;


import static org.apache.poi.ss.usermodel.CellStyle.*;

/**
 * Created by IntelliJ IDEA.
 * User: anya.grinberg
 * Date: 08/01/15
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Bridge1stSheet extends BridgeLevelSheet {

    Bridge1stSheet(BridgeWorkbook workbook, String sheetName) {
        super(workbook, sheetName);
        this.title3 = "נתוני כביש וחישוב בסיס";
    }

    public void run() {
        fillParamTable(true);

        fillTableHeader();

        int dRoadRow = 14;
        int i = 1; //number of line
        for (BridgeParameters.DRoadParams dRoadParam : bridgeParams.getdRoadParams()){

            // d(road)
            String dRoadCell = "A" + dRoadRow;
            setCellValue(dRoadCell, dRoadParam.getdRoad())
                    .setFont(workbook.getParamFont()).setAlignment(ALIGN_CENTER)
                    .setDataFormat(workbook.getDataFormat("#0.00"))
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // SPAN
            String span = "";
            if (i < bridgeParams.getdRoadParams().size()){
               span = "=" + "C" + (dRoadRow + 1) + "-" + "C" + dRoadRow;
            }
            setCellValue("B" + dRoadRow, span)
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            //d(bridge)
            Object dBridgeValue = bridgeParams.getdBridge();
            if (i != 1){
                dBridgeValue = "=" + "D" + dRoadRow + "-" + "D" + (dRoadRow - 1) + "+C" + (dRoadRow-1);
            }
            setCellValue("C" + dRoadRow, dBridgeValue)
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // X
            setCellValue("D" + dRoadRow, "=" + resolveFormula(dRoadCell + "-PCVx"))
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // z
            String zFormula;
            if (dRoadParam.getdRoad() <= bridgeParams.getPIVx()){
                  zFormula =  "PCVelev+E8*D" + dRoadRow;
            } else {
                zFormula =  "PTVelev+G8*(C11-D" + dRoadRow + ")";   // PTVelev +  i2*(L- dRoad)

            }
            setCellValue("E" + dRoadRow, "=" + resolveFormula(zFormula))
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setDataFormat(workbook.getDataFormat("#0.000"))
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // ∆z
            setCellValue("F" + dRoadRow, "=" + ("D" + dRoadRow + "^2*E11/(C11/2)^2"))
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setDataFormat(workbook.getDataFormat("#0.0000"))
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // Zroad
            setCellValue("G" + dRoadRow, "=" + "E" + dRoadRow + "-F" + dRoadRow)
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setDataFormat(workbook.getDataFormat("#0.0000"))
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // Zconc
            setCellValue("H" + dRoadRow, "=" + "G" + dRoadRow + "-F" + dRoadRow)
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setDataFormat(workbook.getDataFormat("#0.0000"))
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            //remark
            setCellValue("I" + dRoadRow, dRoadParam.getRemark() + i)
                    .setFont(workbook.getHeader2Font()).setAlignment(ALIGN_CENTER)
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            dRoadRow++; i++;
        }
    }

    private void fillTableHeader() {
        setCellValue("A13", "d(road)")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM)
                .setBorderBottom(BORDER_MEDIUM);

        setCellValue("B13", "SPAN")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM)
                .setBorderBottom(BORDER_MEDIUM);

        setCellValue("C13", "d(bridge)")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM)
                .setBorderBottom(BORDER_MEDIUM);

        setCellValue("D13", "X")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM)
                .setBorderBottom(BORDER_MEDIUM);

        setCellValue("E13", "z")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM)
                .setBorderBottom(BORDER_MEDIUM);

        setCellValue("F13", "∆z")
                .setFont(workbook.getGreekFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM)
                .setBorderBottom(BORDER_MEDIUM);

        setCellValue("G13", "Zroad")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM)
                .setBorderBottom(BORDER_MEDIUM);

        setCellValue("H13", "Zconc")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM)
                .setBorderBottom(BORDER_MEDIUM);

        setCellValue("I13", "remark")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM)
                .setBorderBottom(BORDER_MEDIUM);
    }


}
