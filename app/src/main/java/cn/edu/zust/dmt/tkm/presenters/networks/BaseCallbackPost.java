package cn.edu.zust.dmt.tkm.presenters.networks;

import cn.edu.zust.dmt.tkm.interfaces.BaseThreadCallbackInterface;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.networks
 * @description $
 * @time 1/5/2020 12:47
 * copyright(c) all rights reserved by MR.M
 **/
public class BaseCallbackPost {

    private String mPath;
    private String mParams;

    private BaseCallbackHandler myHandler;

    public BaseCallbackPost(BaseThreadCallbackInterface callbackInterface, String path, String params) {
        this.myHandler = new BaseCallbackHandler(callbackInterface);
        this.mPath = path;
        this.mParams = params;
    }

    public void startAction() {
        new PostThread(myHandler, mPath, mParams).start();
    }
}