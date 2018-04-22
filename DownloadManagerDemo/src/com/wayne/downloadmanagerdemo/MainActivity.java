package com.wayne.downloadmanagerdemo;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

/*
 * ָ������λ�ü��ļ�����
 * ����1��
 * Ŀ¼: android -> data -> com.app -> files -> Download ->dxtj.apk
 * ���ļ�����Ӧ����ר�õģ����ж�غ����ص��ļ�������ж��ȫ����ɾ��
 * request.setDestinationInExternalFilesDir(this,Environment.DIRECTORY_DOWNLOADS,"dxtj.ap);
 * 
 * ����2:
 * Ŀ¼�� ���ص��ļ���ŵ�ַ sdcard -> download -> dxtj.apk
 * ���ж�غ����ص��ļ��ᱣ��
 * ��sdcard�ϴ���һ���ļ���
 * request.setDestinationInExternalPublicDir("/epmyp/","dxtj.apk");
 * 
 * ������:
 * ������ص��ļ�ϣ��������Ӧ�ù���
 * �ر�����Щ��������ϣ����Media Scannerɨ�赽���ļ�(���� �����ļ�)
 * request.setDestinationInExternalPublicDir(Environment.DIRECTORY_MUSIC,"�������.mp3");
 */
public class MainActivity extends Activity implements View.OnClickListener {

	private TextView tv_file_name, tv_progress, tv_download,
			tv_cancle_download, tv_continue_download;
	private ProgressBar pb_update;
	private DownloadManager downloadManager;
	private DownloadManager.Request request;
	private static String downloadUrl = "http://ucdl.25pp.com/fs08/2017/01/20/2/2_87a290b5f041a8b512f0bc51595f839a.apk";
	private Timer timer;
	private TimerTask task;
	private long id;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			Bundle bundle = msg.getData();
			int pro = bundle.getInt("pro");
			String name = bundle.getString("name");
			pb_update.setProgress(pro);
			tv_progress.setText(String.valueOf(pro) + "%");
			tv_file_name.setText(name);
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv_file_name = (TextView) findViewById(R.id.tv_file_name);
		pb_update = (ProgressBar) findViewById(R.id.pb_update);
		tv_progress = (TextView) findViewById(R.id.tv_progress);
		tv_download = (TextView) findViewById(R.id.tv_download);
		tv_cancle_download = (TextView) findViewById(R.id.tv_cancle_download);
		tv_continue_download = (TextView) findViewById(R.id.tv_continue_download);

		//Ϊ���ء�ȡ���������ؼ��󶨼���
		tv_download.setOnClickListener(this);
		tv_cancle_download.setOnClickListener(this);
		tv_continue_download.setOnClickListener(this);

		// ��ö��󣬿�ʼ����
		downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
		request = new DownloadManager.Request(Uri.parse(downloadUrl));
		// ����Notification�ı���
		request.setTitle("����Ͷ��");
		// ָ����WIFI״̬�£�ִ�����ز���
		request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
		// �Ƿ���������״̬�£�ִ�����ز���
		request.setAllowedOverRoaming(false);
		// ���������ļ����ͣ�����Ϊ��׿.apk�ļ�������
		request.setMimeType("application/vnd.android.package-archive");
		// ����Notification����ʾ������
		request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

		// ����Ŀ¼
		Environment.getExternalStoragePublicDirectory(
				Environment.DIRECTORY_DOWNLOADS).mkdir();

		// �����ļ����·��
		request.setDestinationInExternalPublicDir(
				Environment.DIRECTORY_DOWNLOADS, "app-release.apk");
		// ����progressbar��������
		pb_update.setMax(100);

		final DownloadManager.Query query = new DownloadManager.Query();

		// newһ����ʱ������
		timer = new Timer();
		// newһ����ʱ��������
		task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Cursor cursor = downloadManager.query(query.setFilterById(id));
				if (cursor != null && cursor.moveToFirst()) {
					if (cursor.getInt(cursor
							.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
						pb_update.setProgress(100);
						install(Environment
								.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
								+ "/app-release.apk");
						task.cancel();
					}
					// ����Notification����
					String title = cursor.getString(cursor
							.getColumnIndex(DownloadManager.COLUMN_TITLE));
					// �����ص��ļ��ŵ�����Ŀ¼
					String address = cursor.getString(cursor
							.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
					// �Ѿ����ص��ֽ���
					int bytes_downloaded = cursor
							.getInt(cursor
									.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
					// �����������ֽ���
					int bytes_total = cursor
							.getInt(cursor
									.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
					int pro = (bytes_downloaded * 100) / bytes_total;
					Message msg = Message.obtain();
					Bundle bundle = new Bundle();
					bundle.putInt("pro", pro);
					bundle.putString("name", title);
					msg.setData(bundle);
					handler.sendMessage(msg);
				}
				cursor.close();
			}
		};
		timer.schedule(task, 0, 1000);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// ÿ���ص�һ���ļ���Ӧһ��id,ͨ����id���Բ�ѯ����
		switch (v.getId()) {
		case R.id.tv_download:
			id = downloadManager.enqueue(request);
			task.run();
			tv_download.setClickable(false);
			break;
		case R.id.tv_cancle_download:
			downloadManager.remove(id);
			break;
		case R.id.tv_continue_download:
			id = downloadManager.enqueue(request);
			task.run();
			tv_download.setClickable(false);
			break;
		}
		
	}

	private void install(String path) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.parse("file://" + path),
				"application/vnd.android.package-archive");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
}
