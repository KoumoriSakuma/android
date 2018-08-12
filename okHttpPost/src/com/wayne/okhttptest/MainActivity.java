package com.wayne.okhttptest;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

*
 *�첽��ͬ������1>�첽:����UI�߳���ִ��  2>ͬ��:��UI�߳���ִ��
 */
/*

/*
 * okHttp:�첽POST����ʽ����
 * 1>get�����post����ûʲô̫������
 * 2>post��RequestBody�Ǳ��빹����
 */
public class MainActivity extends Activity {
	private TextView tv_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findId();

		setListener();
	}

	public void findId() {
		// TODO Auto-generated method stub
		tv_text = (TextView) findViewById(R.id.tv_text);
	}

	public void setListener() {
		// TODO Auto-generated method stub
		tv_text.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Form����ʽ
				OkHttpClient mOkHttpClient = new OkHttpClient();
				RequestBody body = new FormBody.Builder().add("username", "xiaoyi").build();
				Request request = new Request.Builder().post(body).url("https://www.baidu.com").build();
				mOkHttpClient.newCall(request).enqueue(new Callback() {
					
					@Override
					public void onResponse(Call arg0, Response arg1) throws IOException {
						// TODO Auto-generated method stub
						
//						1.1����http Post���󣬻�ȡһ����ҳ������ -��÷��ص��ַ���
//						String htmlStr = arg1.body().string();
//						System.out.println("songweiqi>>>>>>>>>"+htmlStr);
						
//						1.2����http Post���󣬻�ȡһ����ҳ������ -��÷��صĶ������ֽ�����
//						byte[] htmlByte = arg1.body().bytes();
//						System.out.println("songweiqi2>>>>>>>>"+htmlByte);
						
//						1.3����http post���󣬻�ȡһ����ҳ������ -��÷��ص�inputStream,�˴���ʶ��һ��,�ô�֧�ִ��ļ�����,��inputStream���ǿ�ͨ��IO��ʽд�ļ�
//						InputStream inputStr = arg1.body().byteStream();
//						System.out.println("songweiqi3>>>>>>>>>"+inputStr);
						
//						2.�����ؼ�,����ʹ��handler
						final String res = arg1.body().string();
						runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								tv_text.setText(res);
								
							}
						});
					}
					
					@Override
					public void onFailure(Call arg0, IOException arg1) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
	}
}
