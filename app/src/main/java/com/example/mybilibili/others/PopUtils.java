package com.example.mybilibili.others;

import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

public class PopUtils {
    private View v;
    private PopupWindow popupWindow;

    private int[] location;
    private int popupWidth;
    private int popupHeight;

    /**
     * @param v       事件View
     * @param inflate 弹框item
     */
    public PopUtils(View v, View inflate) {
        this.v = v;

        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        inflate.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popupWidth = inflate.getMeasuredWidth();
        popupHeight = inflate.getMeasuredHeight();
        location = new int[2];
        v.getLocationOnScreen(location);
    }

    /**
     * PopupWindow出现在事件View上方
     */
    public void showPop() {
        popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - popupWidth / 2, location[1] - popupHeight);
    }

    /**
     * 偏移y轴
     *
     * @param offsetY Y轴偏移（正数上移，负数下移）
     */
    public void showPopY(int offsetY) {
        popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - popupWidth / 2, location[1] - popupHeight - offsetY);
    }

    /**
     * 偏移x轴
     *
     * @param offsetX X轴偏移（正数左移，负数右移）
     */
    public void showPopX(int offsetX) {
        popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - popupWidth / 2 - offsetX, location[1] - popupHeight);
    }

    /**
     * 偏移x轴和y轴
     *
     * @param offsetX X轴偏移（正数左移，负数右移）
     * @param offsetY Y轴偏移（正数上移，负数下移）
     */
    public void showPopXY(int offsetX, int offsetY) {
        popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - popupWidth / 2 - offsetX, location[1] - popupHeight - offsetY);
    }

    /**
     * 关闭PopupWindow
     */
    public void dismissPop() {
        if (null != popupWindow) {
            popupWindow.dismiss();
        }
    }

}
