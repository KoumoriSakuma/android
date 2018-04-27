package com.wayne.webviewinterjsdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
/**
 * 
 * @author user
 *androidԭ����JS
 */
public class MainActivity extends Activity {

	private WebView webView1;
	private Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView1 = (WebView) findViewById(R.id.webView1);
		WebSettings webSettings = webView1.getSettings();
		// ������JS������Ȩ��
		webSettings.setJavaScriptEnabled(true);
		// ��������JS����
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

		// ������JS����
		// ��ʽ�涨Ϊ:file:///android_asset/�ļ���.html
		webView1.loadUrl("file:///android_asset/js.html");
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// ͨ��Handler������Ϣ
				webView1.post(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						// ע����õ�JS������Ҫ��Ӧ��
						// ����javascript��callJS()
						webView1.loadUrl("javascript:callJs()");
					}
				});
			}
		});

		// ���������˵���������ý����������Ҫ֧��js�Ի���
		// WebViewֻ�����壬���ݵ���Ⱦ��Ҫʹ��webviewChromClient��ȥʵ��
		// ͨ������WebChromeClient������javascript�ĶԻ���
		// ������Ӧjs��Alert()����
		webView1.setWebChromeClient(new WebChromeClient() {

			@Override
			public boolean onJsAlert(WebView view, String url, String message,
					final JsResult result) {
				// TODO Auto-generated method stub
				AlertDialog.Builder b = new AlertDialog.Builder(
						MainActivity.this);
				b.setTitle("Alert");
				b.setMessage(message);
				b.setPositiveButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								result.confirm();
							}
						});

				b.setCancelable(false);
				b.create().show();

				return true;
			}

		});
	}
}
