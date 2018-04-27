package com.wayne.okhttpdemo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * @author user okHttp_get����ʹ�÷���
 */
/*
 * ע�⣺ 1.jdk�汾 2.android api Ҫ�� 3.okHttp.jar�����okio.jarʹ��
 */
public class MainActivity extends Activity {

	private Button button1 = null;
	private static final String URL = "https://publicobject.com/helloworld.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							// ִ����������
							request(URL);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
	}

	/*
	 * ��������
	 */
	private void request(String url) throws IOException {
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		Response response = okHttpClient.newCall(request).execute();

		if (response.isSuccessful()) {
			// ����ɹ�����ӡ����
			String result = response.body().string();
			System.out.println(result);
		}
	}
}
