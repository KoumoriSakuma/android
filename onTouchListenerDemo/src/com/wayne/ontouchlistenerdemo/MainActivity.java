package com.wayne.ontouchlistenerdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;
/*
 * ���ַ���ʵ�����Ƽ�����
 * 1>class implements OnTouchListener interface -> override onTouch()
 * 2>view.setOnTouchListener() -> override onTouch()
 */

/*
 * ���Ƽ��������ࣺ
 * 1>override onTouchEvent() -> ʵ��ȫ�ֵ����Ƽ���
 * 2>implements onTouchListener interface -> override onTouch()-> ���ĳһ�ؼ������Ƽ���
 */

public class MainActivity extends Activity {

	private Button btn_time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn_time = (Button) findViewById(R.id.btn_time);

		btn_time.setOnTouchListener(new OnTouchListener() {

			/*
			 * (non-Javadoc)
			 * @see android.view.View.OnTouchListener#onTouch(android.view.View, android.view.MotionEvent)
			 * onTouch()����˵����
			 * v:��ʾҪ�����Ķ���
			 * event:��ʾ������״̬
			 */
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					
					System.out.println("��ָ����");
				}
				if (event.getAction() == MotionEvent.ACTION_MOVE) {
					
					System.out.println("��ָ�ƶ�");
				}
				if (event.getAction() == MotionEvent.ACTION_UP) {
					
					System.out.println("��ָ�ɿ�");
				}
				return true;
			}
		});
	}

}
