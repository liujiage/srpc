package org.jiage.srpc.server.file;

public class ExportUser {

    private long app_id;
    private long timestamp;
    private String developer_id;
    private String country_code;

    public ExportUser() {
    }

    public ExportUser(long app_id, long timestamp, String developer_id, String country_code) {
        this.app_id = app_id;
        this.timestamp = timestamp;
        this.developer_id = developer_id;
        this.country_code = country_code;
    }

    public long getApp_id() {
        return app_id;
    }

    public void setApp_id(long app_id) {
        this.app_id = app_id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(String developer_id) {
        this.developer_id = developer_id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
