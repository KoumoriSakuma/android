package com.wayne.okhttptest;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
/*
 *�첽��ͬ������1>�첽:����UI�߳���ִ��  2>ͬ��:��UI�߳���ִ��
 */
/*
 * okHttp:�첽GET����ʽʹ�ò���
 * 
 *1>����newһ��OkHttpClient����
 *2>���ȹ���һ��Request����,�����������и�url,��Ȼ����ͨ��Request.Builder���ø����������:header��method��
 *3>Ȼ��ͨ��request����ȥ����õ�һ��Call����,�����ڽ���������װ�������񣬼�Ȼ������,�ͻ���execute()��cancel()�ȷ���
 *4>���ϣ�����첽�ķ�ʽȥִ���������Ե��õ���call.enqueue,��call������ȶ��У�Ȼ��ȴ�����ִ�����,�����Callback�м��ɵõ����
 */

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
		tv_text = (TextView)findViewById(R.id.tv_text);
	}

	public void setListener() {
		// TODO Auto-generated method stub
		tv_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//1.�첽GETʹ�÷���
				
				//����okHttpClient����
				OkHttpClient mOkHttpClient = new OkHttpClient();
				//����һ��Request
				final Request request = new Request.Builder().url("https://www.baidu.com").build();
				//new call
				Call call = mOkHttpClient.newCall(request);
				//����������-���첽�ķ�ʽȥִ������
				call.enqueue(new Callback() {
					
					//��onResponseִ�е��̲߳�����UI�߳�
					@Override
					public void onResponse(Call arg0, Response arg1) throws IOException {
						// TODO Auto-generated method stub
//						1.1����http get���󣬻�ȡһ����ҳ������ -��÷��ص��ַ���
//						String htmlStr = arg1.body().string();
//						System.out.println("songweiqi>>>>>>>>>"+htmlStr);
						
//						1.2����http get���󣬻�ȡһ����ҳ������ -��÷��صĶ������ֽ�����
//						byte[] htmlByte = arg1.body().bytes();
//						System.out.println("songweiqi2>>>>>>>>"+htmlByte);
						
//						1.3����http get���󣬻�ȡһ����ҳ������ -��÷��ص�inputStream,�˴���ʶ��һ��,�ô�֧�ִ��ļ�����,��inputStream���ǿ�ͨ��IO��ʽд�ļ�
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
				
			//2. ͬ��GETʹ�÷���
			
		    //		public void getDatasync(){
		    //			  new Thread(new Runnable() {
			//			@Override
			//			public void run() {
			//			try {
			//			OkHttpClient client = new OkHttpClient();//����OkHttpClient����
			//			Request request = new Request.Builder()
            //           .url("http://www.baidu.com")//����ӿڡ������Ҫ����ƴ�ӵ��ӿں��档
            //            .build();//����Request ����
			//			Response response = null;
			//			response = client.newCall(request).execute();//�õ�Response ����
			//			if (response.isSuccessful()) {
			//			Log.d("kwwl","response.code()=="+response.code());
			//			Log.d("kwwl","response.message()=="+response.message());
			//			Log.d("kwwl","res=="+response.body().string());
						//��ʱ�Ĵ���ִ�������̣߳��޸�UI�Ĳ�����ʹ��handler��ת��UI�̡߳�
			//			}
			//		} catch (Exception e) {
			//		e.printStackTrace();
			//	}
			//}
		//}).start();
		//}
		
		}
	   });
	}
}
