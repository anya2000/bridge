package com.gil.bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anya.grinberg
 * Date: 08/01/15
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class BridgeParameters {
    private String roadName;
    private String name;
    private Double _R;
    public static String R = "C3";
    private Double _PCVx;
    public static String PCVx = "C4";
    private Double _PCVelev;
    public static String PCVelev = "C5";
    private Double _PIVx;
    public static String PIVx = "C6";
    private Double _PIVelev;
    public static String PIVelev= "C7";
    private Double _PTVx;
    public static String PTVx = "C8";
    private Double _PTVelev;
    public static String PTVelev= "C9";
    private Double _asfalt;
    public static String asfalt= "C10";
    private Double _alfa;
    public static String alfa= "G11";

    public static String i2= "G8";

    private List<DRoadParams> dRoadParams = new ArrayList();

    static class DRoadParams{
        private double dRoad;
        private String remark;

        DRoadParams(double dRoad, String remark) {
            this.dRoad = dRoad;
            this.remark = remark;
        }

        public double getdRoad() {
            return dRoad;
        }

        public void setdRoad(double dRoad) {
            this.dRoad = dRoad;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }


    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getBridgeName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getR() {
        return _R;
    }

    public void setR(Double r) {
        _R = r;
    }

    public Double getPCVx() {
        return _PCVx;
    }

    public void setPCVx(Double PCVx) {
        this._PCVx = PCVx;
    }

    public Double getPCVelev() {
        return _PCVelev;
    }

    public void setPCVelev(Double _PCVelev) {
        this._PCVelev = _PCVelev;
    }

    public Double getPIVx() {
        return _PIVx;
    }

    public void setPIVx(Double _PIVx) {
        this._PIVx = _PIVx;
    }

    public Double getPIVelev() {
        return _PIVelev;
    }

    public void setPIVelev(Double _PIVelev) {
        this._PIVelev = _PIVelev;
    }

    public Double getPTVx() {
        return _PTVx;
    }

    public void setPTVx(Double _PTVx) {
        this._PTVx = _PTVx;
    }

    public Double getPTVelev() {
        return _PTVelev;
    }

    public void setPTVelev(Double _PTVelev) {
        this._PTVelev = _PTVelev;
    }

    public Double getAsfalt() {
        return _asfalt;
    }

    public void setAsfalt(Double asfalt) {
        this._asfalt = asfalt;
    }

    public Double getAlfa() {
        return _alfa;
    }

    public void setAlfa(Double alfa) {
        this._alfa = alfa;
    }

    public List<DRoadParams> getdRoadParams() {
        return dRoadParams;
    }

    public void setdRoadParams(List<DRoadParams> dRoadParams) {
        this.dRoadParams = dRoadParams;
    }
}
