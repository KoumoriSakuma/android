package com.wayne.notifytest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NotifyTestActivity2 extends Activity {

	private Button btn_1, btn_2;
	private TextView textView1;
	// ������Ϣ����������
	NotificationManager mNotificationManager = null;
	Intent mIntent = null;
	// ����mPendingIntent����
	PendingIntent mPendingIntent = null;
	// ����Notification����
	Notification mNotification = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ��ʼ��NotificationManager����
		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_2 = (Button) findViewById(R.id.btn_2);

		// �������ʱ��ת������
		mIntent = new Intent(NotifyTestActivity2.this, NotifyTestActivity.class);

		// ���õ��ʱ����ʾ���ݵ���
		mPendingIntent = PendingIntent.getActivity(NotifyTestActivity2.this, 0,
				mIntent, 0);

		// ����Notification����
		mNotification = new Notification();

		btn_1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// ����֪ͨ��״̬����ʾ��ͼ��
				mNotification.icon = R.drawable.ic_launcher;
				// �����ǵ��֪ͨʱ��ʾ������
				mNotification.tickerText = "���µ�֪ͨ��~~~";
				// ֪ͨʱ����������
				mNotification.defaults = Notification.DEFAULT_SOUND;
				// ����֪ͨ��ʾ�Ĳ���
				mNotification.setLatestEventInfo(NotifyTestActivity2.this,
						"btn_1", "btn_1֪ͨ������", mPendingIntent);

				// ִ�����֪ͨ�¼�����ת
				mNotificationManager.notify(0, mNotification);

			}
		});
		

		/**
		 * ���֪ͨ��mNotificationManager.cancel(0)�Ĳ���0��mNotificationManager.notify(0
		 * ,mNotification)��ĵ�һ��������Ҳ����notify��id,�����ϵͳ����Ψһ�ġ�
		 * �������������õģ���ϵͳ��Ӧ���ǵ����֪֮ͨ���֪ͨͼ�����ʧ��
		 * �����Կ�NotifytestActivity�е�onStart()�еĴ�����
		 */
		btn_2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mNotificationManager.cancel(0);
				
			}
		});
	}

}
