package cn.edu.zust.dmt.common.utils;

import android.util.Log;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.common.tools
 * @description $
 * @time 1/12/2020 19:40
 * copyright(c) all rights reserved by MR.M
 **/
public class LogUtil {

    private static final String PPX_TAG = "ppxLog";

    private LogUtil(){}

    public synchronized static void showVerboseLog(String msg) {
        Log.v(PPX_TAG, getMsgFormat(msg));
    }

    public synchronized static void showVerboseLog(String tag, String msg) {
        Log.v(tag, getMsgFormat(msg));
    }

    public synchronized static void showDebugLog(String msg) {
        Log.d(PPX_TAG, getMsgFormat(msg));
    }

    public synchronized static void showDebugLog(String tag, String msg) {
        Log.d(tag, getMsgFormat(msg));
    }

    public synchronized static void showInfoLog(String msg) {
        Log.i(PPX_TAG, getMsgFormat(msg));
    }

    public synchronized static void showInfoLog(String tag, String msg) {
        Log.i(tag, getMsgFormat(msg));
    }

    public synchronized static void showWarningLog(String msg) {
        Log.w(PPX_TAG, getMsgFormat(msg));
    }

    public synchronized static void showWarningLog(String tag, String msg) {
        Log.w(tag, getMsgFormat(msg));
    }

    public synchronized static void showErrorLog(String msg) {
        Log.e(PPX_TAG, getMsgFormat(msg));
    }

    public synchronized static void showErrorLog(String tag, String msg) {
        Log.e(tag, getMsgFormat(msg));
    }

    private static String getFunctionName() {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        if (stackTraceElementArray != null) {
            for (StackTraceElement stackTraceElement : stackTraceElementArray) {
                if (stackTraceElement.isNativeMethod()) {
                    continue;
                }
                if (stackTraceElement.getClassName().equals(Thread.class.getName())) {
                    continue;
                }
                if (stackTraceElement.getClassName().equals(LogUtil.class.getName())) {
                    continue;
                }
                return "[ Thread:" + Thread.currentThread().getName() + ", at " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()
                        + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")" + " ]";
            }
        }
        return null;
    }

    private static String getMsgFormat(String msg) {
        return msg + " ;" + getFunctionName();
    }
}