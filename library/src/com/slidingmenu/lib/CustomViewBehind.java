package com.slidingmenu.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.slidingmenu.lib.SlidingMenu.CanvasTransformer;

public class CustomViewBehind extends CustomViewAbove {

	private static final String TAG = "CustomViewBehind";

	private CustomViewAbove mViewAbove;
	private CanvasTransformer mTransformer;
	private boolean mChildrenEnabled;

	public CustomViewBehind(Context context) {
		this(context, null);
	}

	public CustomViewBehind(Context context, AttributeSet attrs) {
		super(context, attrs, false);
	}

	public void setCustomViewAbove(CustomViewAbove customViewAbove) {
		mViewAbove = customViewAbove;
		mViewAbove.setTouchModeBehind(mTouchMode);
	}

	public void setTouchMode(int i) {
		mTouchMode = i;
		if (mViewAbove != null)
			mViewAbove.setTouchModeBehind(i);
	}
	
	public void setCanvasTransformer(CanvasTransformer t) {
		mTransformer = t;
	}

	public int getChildLeft(int i) {
		return 0;
	}

	@Override
	public int getCustomWidth() {
		int i = isMenuOpen()? 0 : 1;
		return getChildWidth(i);
	}

	@Override
	public int getChildWidth(int i) {
		if (i <= 0) {
			return getBehindWidth();
		} else {
			return getChildAt(i).getMeasuredWidth();
		}
	}

	public int getBehindWidth() {
		ViewGroup.LayoutParams params = getLayoutParams();
		return params.width;
	}

	@Override
	public void setContent(View v) {
		super.setMenu(v);
	}

	public void setChildrenEnabled(boolean enabled) {
		mChildrenEnabled = enabled;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent e) {
		if (!mChildrenEnabled)
			return !mChildrenEnabled;
		return !mChildrenEnabled;
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		return false;
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		super.dispatchDraw(canvas);

//		float percentOpen = 1 - (getWidth() - mViewAbove.getRealScrollX()) / getWidth();
		
//		if (mTransformer != null)
//			mTransformer.transformCanvas(canvas, (int) (mScrollX / mViewAbove.getScrollScale()), percentOpen);
	}

}
