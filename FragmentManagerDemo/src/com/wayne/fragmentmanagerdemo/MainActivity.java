package com.wayne.fragmentmanagerdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	private Button btn_add, btn_remove, btn_replace, btn_attach, btn_detach,
			btn_show, btn_hide;
	private FrameLayout fl_content;

	TextFragment textFragment;
	ImageFragment imageFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_add = (Button) findViewById(R.id.btn_add);
		btn_remove = (Button) findViewById(R.id.btn_remove);
		btn_replace = (Button) findViewById(R.id.btn_replace);
		btn_attach = (Button) findViewById(R.id.btn_attach);
		btn_detach = (Button) findViewById(R.id.btn_detach);
		btn_show = (Button) findViewById(R.id.btn_show);
		btn_hide = (Button) findViewById(R.id.btn_hide);
		fl_content = (FrameLayout) findViewById(R.id.fl_content);

		textFragment = new TextFragment();
		imageFragment = new ImageFragment();

		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				add(fl_content);
			}
		});

		btn_remove.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				remove(fl_content);
			}
		});

		btn_replace.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				replaceTextFragment(fl_content);
				replaceImageFragment(fl_content);
			}
		});

		btn_attach.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				attach(fl_content);
			}
		});

		btn_detach.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				detach(fl_content);
			}
		});

		btn_show.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showTextFragment(fl_content);
				showImageFragment(fl_content);
			}
		});

		btn_hide.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideTextFragment(fl_content);
				hideImageFragment(fl_content);
			}
		});
	}

	public void add(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// ����ָ��
		ft.add(R.id.fl_content, textFragment);
		// �ύ����
		ft.commit();
	}

	public void remove(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// ��Activity���Ƴ�һ��Fragment
		ft.remove(textFragment);
		// �ύ����
		ft.commit();
	}

	public void replaceTextFragment(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// �滻Activity�е�һ��Fragment
		ft.replace(R.id.fl_content, textFragment);
		// �ύ����
		ft.commit();
	}
	
	public void replaceImageFragment(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// �滻Activity�е�һ��Fragment
		ft.replace(R.id.fl_content, imageFragment);
		// �ύ����
		ft.commit();
	}

	public void attach(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// ��Fragment���ӵ�Activity��
		ft.attach(textFragment);
		// �ύ���� ==>ft.commit(Api 13)
		ft.commit();
	}

	@SuppressLint("NewApi")
	public void detach(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// �Ὣv��UI���Ƴ�������remove()��ͬ����ʱfragment��״̬��Ȼ��FragmentManagerά��
		ft.detach(textFragment);
		// �ύ����
		ft.commit();
	}

	public void showTextFragment(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// ��ʾ֮ǰ���ص�Fragment
		ft.show(textFragment);
		// �ύ����
		ft.commit();
	}
	
	public void showImageFragment(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// ��ʾ֮ǰ���ص�Fragment
		ft.show(imageFragment);
		// �ύ����
		ft.commit();
	}

	public void hideTextFragment(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// ��Fragment�����̶�����ʱ���ص�ǰ��Fragment,����Ϊ���ɼ�������������
		ft.hide(textFragment);
		// �ύ����
		ft.commit();
	}

	public void hideImageFragment(View v) {
		// ��������
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		// ��Fragment�����̶�����ʱ���ص�ǰ��Fragment,����Ϊ���ɼ�������������
		ft.hide(imageFragment);
		// �ύ����
		ft.commit();
	}

}
