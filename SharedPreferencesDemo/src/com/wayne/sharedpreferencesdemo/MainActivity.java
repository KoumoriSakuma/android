package com.wayne.sharedpreferencesdemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * 
 * @author user
 *����AVD(��root)�ҵ�dataĿ¼��data�ļ����¶�Ӧ��Ӧ�ó���������ҵ�savedata.xml�ļ�
 *�����root�鿴
 */
public class MainActivity extends Activity {

	private Button saveData, getSaveData, clearData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		saveData = (Button) findViewById(R.id.saveData);
		getSaveData = (Button) findViewById(R.id.getSaveData);
		clearData = (Button) findViewById(R.id.clearData);
		
		saveData.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//������Ϊsavedata���ļ��������ֵ�ԣ���������
				SharedPreferences.Editor editor = getSharedPreferences("savedata", MODE_PRIVATE).edit();
				editor.putString("name", "I am a boy");
				//����commit
				editor.commit();
			}
		});
		
		getSaveData.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//ȡ��savedata�ļ��еļ�ֵ�ԣ�����ʾ����
				SharedPreferences preferences = getSharedPreferences("savedata", MODE_PRIVATE);
				String name = preferences.getString("name", "");
				Toast.makeText(getApplication(), name, Toast.LENGTH_SHORT).show();
			}
		});
		
		clearData.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//���savedata�ļ��е�����
				SharedPreferences.Editor editor = getSharedPreferences("savedata", MODE_PRIVATE).edit();
				editor.clear();
				editor.commit();
			}
		});
	}
}
