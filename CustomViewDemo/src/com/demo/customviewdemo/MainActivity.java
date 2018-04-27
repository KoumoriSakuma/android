package com.demo.customviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.demo.customviewclass.TitleView;
/**
 * 
 * @author user
 *�Զ���ؼ�ʵ�ַ���һ����Ͽؼ�
 *��Ͽؼ�����һЩС�Ŀؼ���������γ�һ���µĿؼ�����ЩС�Ŀؼ�����ϵͳ�Դ��Ŀؼ�������ܶ�Ӧ�����ձ�ʹ�õı������ؼ�
 */
public class MainActivity extends Activity{
	
	private TitleView title_bar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		title_bar = (TitleView) findViewById(R.id.title_bar);
		title_bar.setLeftButtonListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "����˷��ذ�ť", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}

	
}
