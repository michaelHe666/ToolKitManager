package cn.edu.zust.dmt.tkm.presenters.networks;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;

import cn.edu.zust.dmt.tkm.presenters.helpers.HttpHelper;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.networks
 * @description $
 * @time 1/13/2020 13:36
 * copyright(c) all rights reserved by MR.M
 **/
public class PostThread extends Thread {
    static final int POST_THREAD_FINISH = 666;

    private WeakReference<Handler> handlerWeakReference;
    private String mPath;
    private String mParams;

    public PostThread(Handler handler, String path, String params) {
        handlerWeakReference = new WeakReference<>(handler);
        this.mPath = path;
        this.mParams = params;
    }

    @Override
    public void run() {
        Log.i("ppx1", "PostReturnStringThread start!");

        Object loginRespond = HttpHelper.postReturnString(mPath, mParams);

        Log.i("ppx1", "PostReturnStringThread end!");

        Message message = Message.obtain();
        message.what = POST_THREAD_FINISH;
        message.obj = loginRespond;

        Handler handler = handlerWeakReference.get();
        if (handler != null) {
            handler.sendMessage(message);
        }
    }
}
