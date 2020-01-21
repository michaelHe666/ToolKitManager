package cn.edu.zust.dmt.tkm.models;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.dmt.tkm.interfaces.BaseObserverInterface;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.models
 * @description use observer-pattern
 * @time 1/6/2020 17:15
 * copyright(c) all rights reserved by MR.M
 **/
public abstract class BaseModel {

    protected List<BaseObserverInterface> mObserverList = new ArrayList<>();

    public void addObserver(BaseObserverInterface baseObserverInterface) {
        mObserverList.add(baseObserverInterface);
    }

    public void removeObserver(BaseObserverInterface baseObserverInterface) {
        mObserverList.remove(baseObserverInterface);
    }

    public abstract void notifyObservers();
}