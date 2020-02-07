package cn.edu.zust.dmt.tkm.views.widgets.customized;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import cn.edu.zust.dmt.common.utils.LogUtil;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.widgets.customized
 * @description $
 * @time 2/5/2020 15:52
 * copyright(c) all rights reserved by MR.M
 **/
public abstract class BaseAnimateView extends View implements LifecycleObserver {

    private boolean hasViewInitialized = false;
    private boolean hasAnimateStarted = false;
    private int mDuration = 0;
    private ObjectAnimator mObjectAnimator = null;

    public BaseAnimateView(Context context) {
        super(context);
    }

    public BaseAnimateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseAnimateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public BaseAnimateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeMyVariables();
    }

    protected void initializeMyVariables() {
        mDuration = getDuration();
        if (mDuration > 0) {
            mObjectAnimator = ObjectAnimator.ofInt(BaseAnimateView.this, "MyFlag", 0, mDuration)
                    .setDuration(mDuration);
            hasViewInitialized = true;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void startAnimate() {
        if (hasViewInitialized) {
            if (hasAnimateStarted) {
                mObjectAnimator.resume();
            } else {
                mObjectAnimator.start();
                hasAnimateStarted = true;
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void stopAnimate() {
        if (hasViewInitialized) {
            mObjectAnimator.pause();
        }
    }

    /**
     * @param myFlag int flag during animate
     */
    protected abstract void setMyFlag(int myFlag);

    /**
     * @return time for animation with unit ms
     */
    protected abstract int getDuration();
}
