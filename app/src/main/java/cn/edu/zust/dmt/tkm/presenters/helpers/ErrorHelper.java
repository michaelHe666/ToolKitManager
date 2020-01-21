package cn.edu.zust.dmt.tkm.presenters.helpers;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.helpers
 * @description $
 * @time 1/21/2020 9:37
 * copyright(c) all rights reserved by MR.M
 **/
public class ErrorHelper {

    private final int LOGIN_SUCCESS = 600;

    private static class ErrorHelperHolder {
        private static ErrorHelper INSTANCE = new ErrorHelper();

        //todo:弱引用或者手动清除引用计数的方法
        private static void clearInstance() {
            INSTANCE = null;
        }
    }

    /**
     * @description forbidden create by new
     */
    private ErrorHelper() {
    }

    public static ErrorHelper getInstance() {
        return ErrorHelperHolder.INSTANCE;
    }
}