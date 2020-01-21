package cn.edu.zust.dmt.tkm.models;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.models
 * @description $
 * @time 1/5/2020 20:02
 * copyright(c) all rights reserved by MR.M
 **/
public class MyToolKitModel {
    private String name;
    private String deadline;
    private int position;
    private int risk;

    public MyToolKitModel(String name, String deadline, int position, int risk) {
        this.name = name;
        this.deadline = deadline;
        this.position = position;
        this.risk = risk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }
}
