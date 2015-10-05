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

	
	//�����������˵�ͬʱ��ʧʱ��������ʱ��ʧ
	public static void startAnimationOut(RelativeLayout level3, int i) {
		
		//Ĭ��Բ��Ϊ���Ͻǣ�
		//ˮƽ����Ϊ0��
		//˳ʱ����ת��������
		RotateAnimation rotate = new RotateAnimation( 0, 180, level3.getWidth()/2, level3.getHeight());
		rotate.setDuration(500);
		rotate.setStartOffset(i);
		rotate.setFillAfter(true);//����ִ����󱣳�����״̬
		level3.startAnimation(rotate);
		
	}

	public static void startAnimationIn(RelativeLayout level2, int i) {
		RotateAnimation rotate = new RotateAnimation( 180, 360, level2.getWidth()/2, level2.getHeight());
		rotate.setDuration(500);
		rotate.setStartOffset(i);
		rotate.setFillAfter(true);//����ִ����󱣳�����״̬
		level2.startAnimation(rotate);
		
	}
}
