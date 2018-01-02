package com.benson.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * com.benson.Bean
 * Created by Benson on 2017/12/26-下午4:51.
 */

public class ceshi {
    /**
     * -cityX : 280.8
     * -cityY : 148.5
     * -cityname : 滨州
     * -centername : 滨州
     * -fontColor : FFFFFF
     * -pyName : binzhou
     * -state1 : 0
     * -state2 : 0
     * -stateDetailed : 晴
     * -tem1 : 5
     * -tem2 : -5
     * -temNow : 3
     * -windState : 东北风3-4级转东南风微风级
     * -windDir : 东风
     * -windPower : 2级
     * -humidity : 44%
     * -time : 15:00
     * -url : 101121101
     */

    @SerializedName("-cityX")
    private String cityX;
    @SerializedName("-cityY")
    private String cityY;
    @SerializedName("-cityname")
    private String cityname;
    @SerializedName("-centername")
    private String centername;
    @SerializedName("-fontColor")
    private String fontColor;
    @SerializedName("-pyName")
    private String pyName;
    @SerializedName("-state1")
    private String state1;
    @SerializedName("-state2")
    private String state2;
    @SerializedName("-stateDetailed")
    private String stateDetailed;
    @SerializedName("-tem1")
    private String tem1;
    @SerializedName("-tem2")
    private String tem2;
    @SerializedName("-temNow")
    private String temNow;
    @SerializedName("-windState")
    private String windState;
    @SerializedName("-windDir")
    private String windDir;
    @SerializedName("-windPower")
    private String windPower;
    @SerializedName("-humidity")
    private String humidity;
    @SerializedName("-time")
    private String time;
    @SerializedName("-url")
    private String url;

    public String getCityX() {
        return cityX;
    }

    public void setCityX(String cityX) {
        this.cityX = cityX;
    }

    public String getCityY() {
        return cityY;
    }

    public void setCityY(String cityY) {
        this.cityY = cityY;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCentername() {
        return centername;
    }

    public void setCentername(String centername) {
        this.centername = centername;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getPyName() {
        return pyName;
    }

    public void setPyName(String pyName) {
        this.pyName = pyName;
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public String getStateDetailed() {
        return stateDetailed;
    }

    public void setStateDetailed(String stateDetailed) {
        this.stateDetailed = stateDetailed;
    }

    public String getTem1() {
        return tem1;
    }

    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    public String getTem2() {
        return tem2;
    }

    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }

    public String getTemNow() {
        return temNow;
    }

    public void setTemNow(String temNow) {
        this.temNow = temNow;
    }

    public String getWindState() {
        return windState;
    }

    public void setWindState(String windState) {
        this.windState = windState;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
