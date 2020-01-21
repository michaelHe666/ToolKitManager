package cn.edu.zust.dmt.tkm.models.responds;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.models.responds
 * @description $
 * @time 1/12/2020 20:01
 * copyright(c) all rights reserved by MR.M
 **/
public class PostRegisterRespondModel {
    private String phonenumber;
    private String username;
    private String password;
    private int status;
    private int permission;

    public PostRegisterRespondModel(String phonenumber, String username, String password, int status, int permission) {
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
        this.status = status;
        this.permission = permission;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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