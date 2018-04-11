package com.wayne.displaymetricsdemo;

import android.app.Activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.wayne.viewtools.ViewTool;

public class MainActivity extends Activity {
	private TextView tv_1;
	private Button btn_1;
	// ��ȡ�ֻ���Ļ�ֱ��ʵ���
	private DisplayMetrics dm;
	private ViewTool viewtool;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ���activity��Ļ��������-����inflateLayout�����к�����������float width,float height
		setContentView(ViewTool.inflateLayoutPixels(MainActivity.this,
				R.layout.activity_main, 1280, 1000));
		// ���fragment��Ļ��������-����inflateFragmentPixels�����к�����������float width,float height
		// View rootView = ViewTool.inflateFragmentPixels(getActivity(),R.layout.fragment_creditagreement,container,1280, 800);

		tv_1 = (TextView) findViewById(R.id.tv_1);
		btn_1 = (Button) findViewById(R.id.btn_1);

		btn_1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dm = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(dm);
				// ����ֻ��Ŀ�͸߶����ص�λΪpx
				String str = "�ֻ���Ļ�ֱ���Ϊ:" + dm.widthPixels + "*"
						+ dm.heightPixels;
				tv_1.setText(str);
			}
		});
	}
}
