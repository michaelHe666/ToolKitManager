package cn.edu.zust.dmt.tkm.presenters.tools;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cn.edu.zust.dmt.tkm.views.activities.BaseActivity;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.tools
 * @description manage baseActivities by stack
 * No instance of this class can be get unless reflect
 * No instance is excepted by design
 * @time 1/1/2020 16:13
 * copyright(c) all rights reserved by MR.M
 **/
public class BaseActivityStackManager {

    private static Stack<BaseActivity> mBaseActivityStack;

    private static final ReentrantReadWriteLock STACK_LOCK = new ReentrantReadWriteLock();

    private BaseActivityStackManager(){}

    /**
     * @return initialize stack
     */
    private static synchronized Stack<BaseActivity> getStack() {
        STACK_LOCK.writeLock().lock();
        if (mBaseActivityStack == null) {
            mBaseActivityStack = new Stack<>();
        }
        STACK_LOCK.writeLock().unlock();
        return mBaseActivityStack;
    }

    /**
     * @param baseActivity add baseActivity to stack
     */
    public static void addBaseActivity(BaseActivity baseActivity) {
        STACK_LOCK.writeLock().lock();
        getStack().add(baseActivity);
        STACK_LOCK.writeLock().unlock();
    }

    /**
     * @param baseActivity finish baseActivity from stack
     */
    public static void finishBaseActivity(BaseActivity baseActivity) {
        STACK_LOCK.writeLock().lock();
        getStack().remove(baseActivity);
        STACK_LOCK.writeLock().unlock();
        baseActivity.finish();
    }

    /**
     * @description remove all activities and exit
     */
    public static void exitSystem() {
        STACK_LOCK.writeLock().lock();
        for (int i = 0, size = getStack().size(); i < size; i++) {
            if (null != getStack().get(i)) {
                getStack().get(i).finish();
            }
        }
        getStack().clear();
        STACK_LOCK.writeLock().unlock();

        //todo:there is a problem with system exit
        //release process by pid
        //android.os.Process.killProcess(Process);
        //System.exit(0);
    }
}