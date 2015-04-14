package com.gil.bridge;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: anya.grinberg
 * Date: 13/01/15
 * Time: 12:13
 * To change this template use File | Settings | File Templates.
 */
@Test(groups = {"ignore"})
public class BridgeWorkbookTest {

    public void testRun() {
        BridgeParameters bridgeParams = new BridgeParameters();
        bridgeParams.setRoadName("כביש 71-הפרדות מפלסיות");
        bridgeParams.setName("גשר חקלאי OP7" );
        bridgeParams.setR(400D);
        bridgeParams.setPCVx(118.85);
        bridgeParams.setPCVelev(-66.666);
        bridgeParams.setPIVx(158.85);
        bridgeParams.setPIVelev(-62.680);
        bridgeParams.setPTVx(198.85);
        bridgeParams.setPTVelev(-66.691);
        bridgeParams.setAsfalt(0.1);
        bridgeParams.setAlfa(41.199);

        bridgeParams.getdRoadParams().add(new BridgeParameters.DRoadParams(119.85, "ABUT"));
        bridgeParams.getdRoadParams().add(new BridgeParameters.DRoadParams(139.85, "PIER"));
        bridgeParams.getdRoadParams().add(new BridgeParameters.DRoadParams(169.85, "PIER"));
        bridgeParams.getdRoadParams().add(new BridgeParameters.DRoadParams(189.85, "ABUT"));

        bridgeParams.setDestFile("result/bridge1.xlsx");
        new BridgeWorkbook(bridgeParams).run();
    }
}
