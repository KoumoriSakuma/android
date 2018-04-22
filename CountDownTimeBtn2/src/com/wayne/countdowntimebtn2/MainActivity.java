package com.wayne.countdowntimebtn2;

import java.util.Timer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/*
 * CountDownTimerʵ�ֵ���ʱ
 */
public class MainActivity extends Activity {

	private Button btn_countdowntime;
	private CountDownTimer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_countdowntime = (Button) findViewById(R.id.btn_countdowntime);

		btn_countdowntime.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				timer.start();
				btn_countdowntime.setClickable(false);
			}
		});

		timer = new CountDownTimer(60000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				btn_countdowntime.setText((millisUntilFinished / 1000)
						+ "�����ط�");
			}

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				//����ʱ��������������btn_countdowntime�ؼ����ı���Ϣ
				btn_countdowntime.setText("��ȡ��֤��");
				btn_countdowntime.setClickable(true);
			}
		};
	}
}
