package cn.edu.zust.dmt.tkm.models;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.models
 * @description $
 * @time 1/3/2020 8:27
 * copyright(c) all rights reserved by MR.M
 **/
public class MyMessageModel {
    private int iconRID;
    private String title;

    public MyMessageModel(int iconRID, String title) {
        this.iconRID = iconRID;
        this.title = title;
    }

    public int getIconRID() {
        return iconRID;
    }

    public void setIconRID(int iconRID) {
        this.iconRID = iconRID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
