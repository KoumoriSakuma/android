package com.demo.customviewclass;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.customviewdemo.R;

public class TitleView extends RelativeLayout {

	private Button left_btn;
	private TextView title_tv;

	public TitleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub

		// ���ز���
		LayoutInflater.from(context).inflate(R.layout.title_bar, this);

		// ��ȡ�ؼ�
		left_btn = (Button) findViewById(R.id.left_btn);
		title_tv = (TextView) findViewById(R.id.title_tv);

	}
	
	//Ϊ��෵�ذ�ť����Զ������¼�
	public void setLeftButtonListener(OnClickListener listener){
		left_btn.setOnClickListener(listener);
	}

	//���ñ���ķ���
	public void setTitleText(String title){
		title_tv.setText(title);
	}
}
