package cn.edu.zust.dmt.tkm.presenters.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.zust.dmt.tkm.R;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.helpers
 * @description $
 * @time 12/31/2019 14:34
 * copyright(c) all rights reserved by MR.M
 **/
public class ToastHelper {

    /**
     * @description forbidden create class by new
     */
    private ToastHelper() {}

    private static class ToastHelperHolder {
        private static ToastHelper INSTANCE = new ToastHelper();
    }

    /**
     * @return singleton-pattern instance
     */
    public static ToastHelper getInstance() {
        return ToastHelperHolder.INSTANCE;
    }

    public void showAppStyleShortToast(String messageString, Context context) {
        Toast toast = new Toast(context);
        View mView = LayoutInflater.from(context).inflate(R.layout.helper_toast, null);
        ((TextView) mView.findViewById(R.id.universe_toast_content)).setText(messageString);
        toast.setView(mView);
        toast.show();
    }

    public void showAppStyleShortToast(int stringRId, Context context) {
        Toast toast = new Toast(context);
        View mView = LayoutInflater.from(context).inflate(R.layout.helper_toast, null);
        ((TextView) mView.findViewById(R.id.universe_toast_content))
                .setText(context.getResources().getString(stringRId));
        toast.setView(mView);
        toast.show();
    }
}
