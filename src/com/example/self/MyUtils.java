package com.example.self;

import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class MyUtils {

	public static void startAnimationOut(RelativeLayout level3) {
	
		startAnimationOut(level3,0);
		
	}

	public static void startAnimationIn(RelativeLayout level3) {
		startAnimationIn(level3,0);
		
	}

	
	//二级，三级菜单同时消失时，三级延时消失
	public static void startAnimationOut(RelativeLayout level3, int i) {
		
		//默认圆心为左上角，
		//水平向右为0度
		//顺时针旋转读书增加
		RotateAnimation rotate = new RotateAnimation( 0, 180, level3.getWidth()/2, level3.getHeight());
		rotate.setDuration(500);
		rotate.setStartOffset(i);
		rotate.setFillAfter(true);//动画执行完后保持最后的状态
		level3.startAnimation(rotate);
		
	}

	public static void startAnimationIn(RelativeLayout level2, int i) {
		RotateAnimation rotate = new RotateAnimation( 180, 360, level2.getWidth()/2, level2.getHeight());
		rotate.setDuration(500);
		rotate.setStartOffset(i);
		rotate.setFillAfter(true);//动画执行完后保持最后的状态
		level2.startAnimation(rotate);
		
	}
}
