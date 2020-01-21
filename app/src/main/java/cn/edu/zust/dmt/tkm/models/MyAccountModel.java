package cn.edu.zust.dmt.tkm.models;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.models
 * @description $
 * @time 1/6/2020 16:57
 * copyright(c) all rights reserved by MR.M
 **/
public class MyAccountModel{
    private String phoneNumber;
    private String username;
    private String password;
    private int status;
    private int permission;

    public MyAccountModel(String phoneNumber, String username, String password, int status, int permission) {
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.status = status;
        this.permission = permission;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}