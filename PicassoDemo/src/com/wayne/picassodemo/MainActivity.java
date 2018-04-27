package com.wayne.picassodemo;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
/**
 * 
 * @author user
 * Picasso��ܵļ�ʵ�ã�δ�漰ͼƬ�Ļ���
 */
public class MainActivity extends Activity {
	private ImageView full_image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		full_image = (ImageView) findViewById(R.id.full_image);
		
		//��ȡ���ݹ�����imageUrl,����image��ʾ������ע������placeholder
		Intent intent = getIntent();
		String imageUrl = intent.getExtras().getString("imageUrl");
		Picasso.with(MainActivity.this).load(imageUrl).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_action_a).into(full_image);
	}
}
