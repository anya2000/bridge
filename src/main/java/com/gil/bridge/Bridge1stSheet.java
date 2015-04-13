package com.gil.bridge;


import static org.apache.poi.ss.usermodel.CellStyle.*;

import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;

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
          //נתוני כביש וחישוב בסיס;
        this.title3 = "\u05e0\u05ea\u05d5\u05e0\u05d9 \u05db\u05d1\u05d9\u05e9 \u05d5\u05d7\u05d9\u05e9\u05d5\u05d1 \u05d1\u05e1\u05d9\u05e1";
    }

    public void run() {
        putParamTable(true);

        setCellValue("A13", "d(road)")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM);

        setCellValue("B13", "SPAN")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM);

        setCellValue("C13", "d(bridge)")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM);

        setCellValue("D13", "X")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM);

        setCellValue("E13", "z")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM);

        setCellValue("F13", "∆z")
                .setFont(workbook.getGreekFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM);

        setCellValue("G13", "Zroad")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM);

        setCellValue("H13", "Zconc")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM);

        setCellValue("I13", "remark")
                .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                .setBorderTop(BORDER_MEDIUM)
                .setBorderRight(BORDER_MEDIUM);

        int dRoadRow = 14;
        int i = 1;
        for (BridgeParameters.DRoadParams dRoadParam : bridgeParams.getdRoadParams()){
            String dRoadCell = "A" + dRoadRow;
            setCellValue(dRoadCell, dRoadParam.getdRoad())
                    .setFont(workbook.getParamFont()).setAlignment(ALIGN_CENTER)
                    .setDataFormat(workbook.getDataFormat("#0.00"))
                    .setBorderTop(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // X
            setCellValue("D" + dRoadRow, "=" + resolveFormula(dRoadCell + "-PCVx"))
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setBorderTop(BORDER_THIN)
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
                    .setBorderTop(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // ∆z
            setCellValue("F" + dRoadRow, "=" + ("D" + dRoadRow + "^2*E11/(C11/2)^2"))
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setDataFormat(workbook.getDataFormat("#0.0000"))
                    .setBorderTop(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            setCellValue("I" + dRoadRow, dRoadParam.getRemark() + i)
                    .setFont(workbook.getHeader2Font()).setAlignment(ALIGN_CENTER)
                    .setBorderTop(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            dRoadRow++; i++;
        }
        setCellValue("A" + dRoadRow, "")
                .setBorderTop(BORDER_THIN);
        setCellValue("B" + dRoadRow, "")
                .setBorderTop(BORDER_THIN);
        setCellValue("C" + dRoadRow, "")
                .setBorderTop(BORDER_THIN);
        setCellValue("D" + dRoadRow, "")
                .setBorderTop(BORDER_THIN);
        setCellValue("E" + dRoadRow, "")
                .setBorderTop(BORDER_THIN);
        setCellValue("F" + dRoadRow, "")
                .setBorderTop(BORDER_THIN);
        setCellValue("G" + dRoadRow, "")
                .setBorderTop(BORDER_THIN);
        setCellValue("H" + dRoadRow, "")
                .setBorderTop(BORDER_THIN);
        setCellValue("I" + dRoadRow, "")
                .setBorderTop(BORDER_THIN);

    }


}
