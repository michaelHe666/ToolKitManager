package cn.edu.zust.dmt.tkm.presenters.helpers;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.helpers
 * @description provide methods recording page relationship
 * @time 1/15/2020 7:40
 * copyright(c) all rights reserved by MR.M
 **/
public class PageHelper {

    /**
     * @description forbidden create class by new
     */
    private PageHelper(){}

    private static class PageHelperHolder {
        private static PageHelper INSTANCE = new PageHelper();
    }

    /**
     * @return singleton-pattern instance
     */
    public static PageHelper getInstance() {
        return PageHelperHolder.INSTANCE;
    }

//    public static void startPage
}