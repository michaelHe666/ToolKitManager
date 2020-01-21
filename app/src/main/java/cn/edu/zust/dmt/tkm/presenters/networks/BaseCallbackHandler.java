package cn.edu.zust.dmt.tkm.presenters.networks;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import cn.edu.zust.dmt.tkm.interfaces.BaseThreadCallbackInterface;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.networks
 * @description $
 * @time 1/13/2020 13:32
 * copyright(c) all rights reserved by MR.M
 **/
public class BaseCallbackHandler extends Handler {
    private WeakReference<BaseThreadCallbackInterface> callbackInterfaceWeakReference; // 持有外部类的弱引用

    public BaseCallbackHandler(BaseThreadCallbackInterface callbackInterface) {
        callbackInterfaceWeakReference = new WeakReference<>(callbackInterface);
    }

    @Override
    public void handleMessage(Message msg) {
        if (msg.what == PostThread.POST_THREAD_FINISH) {
            BaseThreadCallbackInterface callbackInterface = callbackInterfaceWeakReference.get();
            if (callbackInterface != null) {
                callbackInterface.getThreadCallback(msg.obj);
            }
        }
    }
}