package com.wayne.picassodemo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.wayne.picassoadapter.ImageAdapter;
/**
 * 
 * @author user
 *ͨ��GridImageActivity����ʾ����ͼƬ
 */
public class GridImageActivity extends Activity {

	private ImageAdapter adapter;
	private GridView gridView;

	// �����洢������Ҫ�õ���18��ͼƬ��url��ַ
	private ArrayList<String> urls = new ArrayList<>();

	private final String baseUrl = "http://www.jycoder.com/json/Image/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview);

		gridView = (GridView) findViewById(R.id.grid_view);

		// ͼƬurl��ַ
		for (int i = 0; i <= 18; i++) {
			urls.add(baseUrl + i + ".jpg");
		}

		adapter = new ImageAdapter(GridImageActivity.this, urls);
		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {
			//Ϊÿ��������ӵ����¼���������������ת��ͼƬչʾҳ��MainActivity
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(GridImageActivity.this,
						MainActivity.class);
				// ��Ҫ��������ͼƬ�ص�Url��ַ��MainActivity
				intent.putExtra("imageUrl", urls.get(arg2));
				startActivity(intent);
			}

		});
	}

}
