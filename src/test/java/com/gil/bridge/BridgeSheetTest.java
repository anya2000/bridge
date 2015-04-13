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
public class BridgeSheetTest {

    public void testResolveFormula() {
        assertEquals(BridgeSheet.resolveFormula("PTVx-PCVx"), "C8-C4");
        assertEquals(BridgeSheet.resolveFormula("(PIVelev-PCVelev)/(PIVx-PCVx)"), "(C7-C5)/(C6-C4)");


    }
}
