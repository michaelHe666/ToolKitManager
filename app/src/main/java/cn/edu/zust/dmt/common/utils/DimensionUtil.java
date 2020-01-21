package cn.edu.zust.dmt.common.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.com.zust.dmt.common.tools
 * @description $
 * @time 12/29/2019 19:43
 * copyright(c) all rights reserved by MR.M
 **/
public class DimensionUtil {

    /**
     * @description px to dip/dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * @description dip/dp to px
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * @description px to sp
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * @description sp to px
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * @return get @param text font height
     */
    public static float getFontHeight(Paint paint, String text) {
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect.height();
    }

}
