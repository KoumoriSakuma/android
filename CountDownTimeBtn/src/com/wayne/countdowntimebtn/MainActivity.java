package com.wayne.countdowntimebtn;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/*
 * Timer��TimerTaskʵ�ֵ���ʱЧ��
 */
public class MainActivity extends Activity {

	private Button btn_countdowntime;
	// ��ʱ��
	private long totalTime;
	// ʣ��ʱ��
	private long remainingTime;
	// ��ʱ��
	private Timer timer;
	// ��ʱ������
	private TimerTask task;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (remainingTime <= 0) {
				timer.cancel();
				task.cancel();
				//����ʱ��������������btn_countdowntime�ؼ����ı���Ϣ
				btn_countdowntime.setText("��ȡ��֤��");
				btn_countdowntime.setClickable(true);
				return;
			}
			btn_countdowntime.setText((remainingTime / 1000) + "�������·���");
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_countdowntime = (Button) findViewById(R.id.btn_countdowntime);

		btn_countdowntime.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				remainingTime = 10000;
				timer = new Timer();
				// �ɵ�����ȡ��task��->�̳�TimerTask��->��дrun() ==>�·�ע�ʹ���
				task = new TimerTask() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						remainingTime = remainingTime - 1000;
						// ������Ϣ֪ͨ���̸߳���UI
						handler.sendEmptyMessage(0x789);
					}
				};
				// ִ�ж�ʱ����
				timer.schedule(task, 0, 1000);
				btn_countdowntime.setClickable(true);
			
			}
		});
	}
	
/*
	class Task extends TimerTask {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			remainingTime = remainingTime - 1000;
			// ������Ϣ֪ͨ���̸߳���UI
			handler.sendEmptyMessage(0x789);
		}

	}*/
}
