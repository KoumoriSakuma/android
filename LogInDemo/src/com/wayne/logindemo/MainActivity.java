package com.wayne.logindemo;

import com.wayne.saveuserinfo.SaveUserInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText et_accout;
	private EditText et_password;
	private CheckBox cb_remember;
	private Button btn_submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et_accout = (EditText) findViewById(R.id.et_accout);
		et_password = (EditText) findViewById(R.id.et_password);
		cb_remember = (CheckBox) findViewById(R.id.cb_remember);
		btn_submit = (Button) findViewById(R.id.btn_submit);
		btn_submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				testLogIn(btn_submit);
			}
		});
	}

	public void testLogIn(View v) {
		// ��ȡ�û���
		String username = et_accout.getText().toString().trim();
		// ��ȡ����
		String password = et_password.getText().toString().trim();

		if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
			Toast.makeText(this, "�˺ź����벻��Ϊ��", 100).show();
			if(TextUtils.isEmpty(username)){
				Toast.makeText(this, "�˺Ų���Ϊ��", 100).show();
			}
			if(TextUtils.isEmpty(password)){
				Toast.makeText(this, "���벻��Ϊ��", 100).show();
			}
			
		} else {
			if ("songweiqi".equals(username) && "12345678".equals(password)) {
				Toast.makeText(this, "��¼�ɹ�", 100).show();
				Intent intent = new Intent(MainActivity.this,
						SecondActivity.class);
				startActivity(intent);
			}
		}

		if(cb_remember.isChecked()){
			boolean istrue = SaveUserInfo.SaveUser(username, password);
			if(istrue){
				Toast.makeText(this, "�洢�ɹ�", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "�洢ʧ��", Toast.LENGTH_SHORT).show();
			}
		}

	}

}
