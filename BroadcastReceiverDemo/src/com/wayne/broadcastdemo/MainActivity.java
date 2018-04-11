package com.wayne.broadcastdemo;

import android.app.Activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.wayne.broadcastreceiverdemo.Receiver_1;
import com.wayne.broadcastreceiverdemo.Receiver_2;

public class MainActivity extends Activity {
	private Button btn_static, btn_dynamic;
	private Receiver_1 receiver;
	private Receiver_2 receiver2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// new ������̬ע��Ľ�����
		receiver = new Receiver_1();
		// new ������̬ע��Ľ�����
		receiver2 = new Receiver_2();

		btn_static = (Button) findViewById(R.id.btn_static);
		btn_dynamic = (Button) findViewById(R.id.btn_dynamic);

		btn_static.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("key", "��̬ע��");
				intent.setAction("Action_1");
				// ���͹㲥
				sendBroadcast(intent);

			}
		});

		btn_dynamic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent2 = new Intent();
				intent2.putExtra("key", "��̬ע��");
				intent2.setAction("Action_2");
				sendBroadcast(intent2);
			}
		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// ��ȡһ��������
		IntentFilter filter = new IntentFilter();
		filter.addAction("Action_2");
		// ע��
		registerReceiver(receiver, filter);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		// ���ע��
		unregisterReceiver(receiver);
	}

}
