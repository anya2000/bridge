package com.gil.bridge;


import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;

import static org.apache.poi.ss.usermodel.CellStyle.*;

/**
 * Created by IntelliJ IDEA.
 * User: anya.grinberg
 * Date: 08/01/15
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Bridge1stSheet extends BridgeLevelSheet {
    private int tableStartRow = 14;

    Bridge1stSheet(BridgeWorkbook workbook, String sheetName) {
        super(workbook, sheetName);
        this.title3 = "נתוני כביש וחישוב בסיס";
    }

    public void run() {
        fillParamTable(true);

        fillTableHeader();

        fillTable();

        addChart();
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

    private void fillTable() {
        int dRoadRow = tableStartRow;
        int i = 1; //number of line
        for (BridgeParameters.DRoadParams dRoadParam : bridgeParams.getdRoadParams()) {

            // d(road)
            String dRoadCell = "A" + dRoadRow;
            setCellValue(dRoadCell, dRoadParam.getdRoad())
                    .setFont(workbook.getParamFont()).setAlignment(ALIGN_CENTER)
                    .setDataFormat(workbook.getDataFormat("#0.00"))
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // SPAN
            String span = "";
            if (i < bridgeParams.getdRoadParams().size()) {
                span = "=" + "C" + (dRoadRow + 1) + "-" + "C" + dRoadRow;
            }
            setCellValue("B" + dRoadRow, span)
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            //d(bridge)
            Object dBridgeValue = bridgeParams.getdBridge();
            if (i != 1) {
                dBridgeValue = "=" + "D" + dRoadRow + "-" + "D" + (dRoadRow - 1) + "+C" + (dRoadRow - 1);
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
            if (dRoadParam.getdRoad() <= bridgeParams.getPIVx()) {
                zFormula = "PCVelev+E8*D" + dRoadRow;
            } else {
                zFormula = "PTVelev+G8*(C11-D" + dRoadRow + ")";   // PTVelev +  i2*(L- dRoad)

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
                    .setDataFormat(workbook.getDataFormat("#0.000"))
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            // Zconc
            setCellValue("H" + dRoadRow, "=" + "G" + dRoadRow + "-F" + dRoadRow)
                    .setFont(workbook.getBodyFont()).setAlignment(ALIGN_CENTER)
                    .setDataFormat(workbook.getDataFormat("#0.000"))
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            //remark
            setCellValue("I" + dRoadRow, dRoadParam.getRemark() + i)
                    .setFont(workbook.getHeader2Font()).setAlignment(ALIGN_CENTER)
                    .setBorderBottom(BORDER_THIN)
                    .setBorderRight(BORDER_THIN);

            dRoadRow++;
            i++;
        }
    }

    private void addChart() {
        //http://thinktibits.blogspot.co.il/2014/07/apache-poi-xlsx-line-chart-java-example.html
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);
        XSSFChart lineChart = drawing.createChart(anchor);

        LineChartData data = lineChart.getChartDataFactory().createLineChartData();

        ChartAxis xAxis = lineChart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis yAxis = lineChart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        yAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        int xCol = getColNumber("I");
        int yCol = getColNumber("H");
        int numOfPiers = bridgeParams.getdRoadParams().size();
        ChartDataSource<String> xAxeData = DataSources.fromStringCellRange(sheet,
                new CellRangeAddress(tableStartRow - 1, tableStartRow + numOfPiers - 2, xCol, xCol));

        ChartDataSource<Number> yAxeData = DataSources.fromNumericCellRange(sheet,
                new CellRangeAddress(tableStartRow - 1, tableStartRow + numOfPiers - 2, yCol, yCol));

        data.addSeries(xAxeData, yAxeData);
        lineChart.plot(data, new ChartAxis[]{xAxis, yAxis});
    }

}
