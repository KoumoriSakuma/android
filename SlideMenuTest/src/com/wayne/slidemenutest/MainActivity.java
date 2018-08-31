package com.wayne.slidemenutest;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//new��SlidingMenu����
		SlidingMenu menu = new SlidingMenu(this);
		//���ò໬�ķ���-���
		menu.setMode(SlidingMenu.LEFT);
		//���ô�����Ļ�ķ�ʽ-ȫ��
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		//���û�����ʣ��Ŀ��
		menu.setBehindOffset(1100);
		//���ý��뽥��Ч����ֵ
		menu.setFadeDegree(0.35f);
		//��-��SlidingMenu�󶨵�Activity
		menu.attachToActivity(this, SlidingMenu.LEFT);
		//Ϊ��໬�˵����ò���
		menu.setMenu(R.layout.left_function_fragment);
	}
}
