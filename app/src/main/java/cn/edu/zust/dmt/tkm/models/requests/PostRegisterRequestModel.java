package cn.edu.zust.dmt.tkm.models.requests;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.models.requests
 * @description $
 * @time 1/12/2020 17:59
 * copyright(c) all rights reserved by MR.M
 **/
public class PostRegisterRequestModel {
    private String phonenumber;
    private String password;

    public PostRegisterRequestModel(String phonenumber, String password) {
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}