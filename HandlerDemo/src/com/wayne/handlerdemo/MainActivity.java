package com.wayne.handlerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_1;
	private Handler handler = new Handler() {
		// �÷������������߳���
		// ���յ�handler���͵���Ϣ����UI���в���
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (msg.what == 0x123) {
				tv_1.setText("�Ǻǡ�����");
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv_1 = (TextView) findViewById(R.id.tv_1);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//�ڴ�ִ�к�ʱ������ִ����Ϻ����handler������Ϣ
				try {
					//˯��5�룬ģ��ִ�к�ʱ����
					Thread.sleep(5000);
					handler.sendEmptyMessage(0x123);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}).start();
	}
}
