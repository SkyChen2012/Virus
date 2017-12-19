package com.benson.Tools.Map.Bean;

import java.util.List;

/**
 * com.benson.Map
 * Created by Benson on 2017/12/4-下午4:08.
 */

public class MapBean {
    /**
     * Number : 13456788888
     * Name : 荷叶
     * Remarks : 小何
     * time : 2017-02-21
     * locType : 定位类型
     * locTypeDescription : 对应的定位类型说明
     * latitude : 纬度
     * lontitude : 经度
     * radius : 半径
     * CountryCode : 国家码
     * Country : 国家名称
     * citycode : 城市编码
     * city : 城市
     * District : 区
     * Street : 街道
     * addr : 地址信息
     * UserIndoorState : 用户室内外判断结果
     * Direction : 方向
     * locationdescribe : 位置语义化信息
     * Poi : POI信息
     * TypeGpsLocation : {"speed":"速度 单位：km/h","satellite":"卫星数目","height":"海拔高度 单位：米","gps_status":"gps质量判断","describe":"gps定位成功"}
     * TypeNetWorkLocation : {"height":"海拔高度 单位：米","operationers":"运营商信息","describe":"网络定位成功"}
     * TypeOffLineLocation : {"describe":"离线定位成功，离线定位结果也是有效的"}
     * TypeServerError : {"describe":"服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因"}
     * TypeNetWorkException : {"describe":"网络不同导致定位失败，请检查网络是否通畅"}
     * TypeCriteriaException : {"describe":"无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机"}
     */

    private String Number;
    private String Name;
    private String Remarks;
    private String time;
    private int locType;
    private String locTypeDescription;
    private double latitude;
    private double lontitude;
    private float radius;
    private String CountryCode;
    private String Country;
    private String citycode;
    private String city;
    private String District;
    private String Street;
    private String addr;
    private int UserIndoorState;
    private float Direction;
    private String locationdescribe;
    private List<String> Poi;
    private TypeGpsLocationBean TypeGpsLocation;
    private TypeNetWorkLocationBean TypeNetWorkLocation;
    private TypeOffLineLocationBean TypeOffLineLocation;
    private TypeServerErrorBean TypeServerError;
    private TypeNetWorkExceptionBean TypeNetWorkException;
    private TypeCriteriaExceptionBean TypeCriteriaException;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLocType() {
        return locType;
    }

    public void setLocType(int locType) {
        this.locType = locType;
    }

    public String getLocTypeDescription() {
        return locTypeDescription;
    }

    public void setLocTypeDescription(String locTypeDescription) {
        this.locTypeDescription = locTypeDescription;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLontitude() {
        return lontitude;
    }

    public void setLontitude(double lontitude) {
        this.lontitude = lontitude;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getUserIndoorState() {
        return UserIndoorState;
    }

    public void setUserIndoorState(int UserIndoorState) {
        this.UserIndoorState = UserIndoorState;
    }

    public float getDirection() {
        return Direction;
    }

    public void setDirection(float Direction) {
        this.Direction = Direction;
    }

    public String getLocationdescribe() {
        return locationdescribe;
    }

    public void setLocationdescribe(String locationdescribe) {
        this.locationdescribe = locationdescribe;
    }

    public List<String>  getPoi() {
        return Poi;
    }

    public void setPoi(List<String>  Poi) {
        this.Poi = Poi;
    }

    public TypeGpsLocationBean getTypeGpsLocation() {
        return TypeGpsLocation;
    }

    public void setTypeGpsLocation(TypeGpsLocationBean TypeGpsLocation) {
        this.TypeGpsLocation = TypeGpsLocation;
    }

    public TypeNetWorkLocationBean getTypeNetWorkLocation() {
        return TypeNetWorkLocation;
    }

    public void setTypeNetWorkLocation(TypeNetWorkLocationBean TypeNetWorkLocation) {
        this.TypeNetWorkLocation = TypeNetWorkLocation;
    }

    public TypeOffLineLocationBean getTypeOffLineLocation() {
        return TypeOffLineLocation;
    }

    public void setTypeOffLineLocation(TypeOffLineLocationBean TypeOffLineLocation) {
        this.TypeOffLineLocation = TypeOffLineLocation;
    }

    public TypeServerErrorBean getTypeServerError() {
        return TypeServerError;
    }

    public void setTypeServerError(TypeServerErrorBean TypeServerError) {
        this.TypeServerError = TypeServerError;
    }

    public TypeNetWorkExceptionBean getTypeNetWorkException() {
        return TypeNetWorkException;
    }

    public void setTypeNetWorkException(TypeNetWorkExceptionBean TypeNetWorkException) {
        this.TypeNetWorkException = TypeNetWorkException;
    }

    public TypeCriteriaExceptionBean getTypeCriteriaException() {
        return TypeCriteriaException;
    }

    public void setTypeCriteriaException(TypeCriteriaExceptionBean TypeCriteriaException) {
        this.TypeCriteriaException = TypeCriteriaException;
    }

    public static class TypeGpsLocationBean {
        /**
         * speed : 速度 单位：km/h
         * satellite : 卫星数目
         * height : 海拔高度 单位：米
         * gps_status : gps质量判断
         * describe : gps定位成功
         */

        private float speed;
        private int satellite;
        private String height;
        private String gps_status;
        private String describe;

        public float getSpeed() {
            return speed;
        }

        public void setSpeed(float speed) {
            this.speed = speed;
        }

        public int getSatellite() {
            return satellite;
        }

        public void setSatellite(int satellite) {
            this.satellite = satellite;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getGps_status() {
            return gps_status;
        }

        public void setGps_status(String gps_status) {
            this.gps_status = gps_status;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }

    public static class TypeNetWorkLocationBean {
        /**
         * height : 海拔高度 单位：米
         * operationers : 运营商信息
         * describe : 网络定位成功
         */

        private String height;
        private String operationers;
        private String describe;

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getOperationers() {
            return operationers;
        }

        public void setOperationers(String operationers) {
            this.operationers = operationers;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }

    public static class TypeOffLineLocationBean {
        /**
         * describe : 离线定位成功，离线定位结果也是有效的
         */

        private String describe;

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }

    public static class TypeServerErrorBean {
        /**
         * describe : 服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因
         */

        private String describe;

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }

    public static class TypeNetWorkExceptionBean {
        /**
         * describe : 网络不同导致定位失败，请检查网络是否通畅
         */

        private String describe;

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }

    public static class TypeCriteriaExceptionBean {
        /**
         * describe : 无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机
         */

        private String describe;

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }
}
