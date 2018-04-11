package com.wayne.canvasdemo;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn_again, btn_save;
	private ImageView iv_canvas;
	private Bitmap baseBitmap;
	private Canvas canvas;
	private Paint paint;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_again = (Button) findViewById(R.id.btn_again);
		btn_save = (Button) findViewById(R.id.btn_save);
		iv_canvas = (ImageView) findViewById(R.id.iv_canvas);

		// ��ʼ��һ�����ʣ��ʴ����Ϊ5����ɫΪ��ɫ
		paint = new Paint();
		paint.setStrokeWidth(5);
		paint.setColor(Color.RED);

		iv_canvas.setOnTouchListener(new OnTouchListener() {
			float startX;
			float startY;
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				// ������ָ��ʼ����������
				switch (event.getAction()) {
				// �û����¶���
				case MotionEvent.ACTION_DOWN:
					// ��һ�λ�ͼ��ʼ�ڴ�ͼƬ��ָ������Ϊ��ɫ
					if (baseBitmap == null) {
						baseBitmap = Bitmap.createBitmap(iv_canvas.getWidth(),
								iv_canvas.getHeight(), Bitmap.Config.ARGB_8888);
						canvas = new Canvas(baseBitmap);
						canvas.drawColor(Color.WHITE);
					}
					// ��¼��ʼ�����ĵ������
					startX = event.getX();
					startY = event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					// ��¼�ƶ�λ�õĵ������
					float stopX = event.getX();
					float stopY = event.getY();

					// ������������,��������
					canvas.drawLine(startX, startY, stopX, stopY, paint);

					// ���¿�ʼ���λ��
					startX = event.getX();
					startY = event.getY();

					// ��ͼƬչʾ��ImageView��
					iv_canvas.setImageBitmap(baseBitmap);
					break;
				case MotionEvent.ACTION_UP:
					break;
				default:
					break;
			
			}
				return true;
			}
		});
		
		btn_again.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				againCanvas();
			}
		});
		
		btn_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				saveBitmap();
			}
		});
	}

	protected void againCanvas() {
			// TODO Auto-generated method stub
			// �ֶ��������Ļ�ͼ�����´���һ������
			if (baseBitmap != null) {
				baseBitmap = Bitmap.createBitmap(iv_canvas.getWidth(),
						iv_canvas.getHeight(), Bitmap.Config.ARGB_8888);
				canvas = new Canvas(baseBitmap);
				canvas.drawColor(Color.WHITE);
				iv_canvas.setImageBitmap(baseBitmap);
				Toast.makeText(MainActivity.this, "�������ɹ����������¿�ʼ��ͼ", 0).show();
			}
		}
	
	protected void saveBitmap() {
		// TODO Auto-generated method stub
		try {
			// ����ͼƬ��SD����
			File file = new File(Environment.getExternalStorageDirectory(),
					System.currentTimeMillis() + ".png");
			FileOutputStream os = new FileOutputStream(file);
			baseBitmap.compress(CompressFormat.PNG, 100, os);

			// android�豸GallaryӦ��ֻ����������ʱ��ɨ��ϵͳ�ļ���
			// ����ģ��һ��ý��װ�صĹ㲥������ʹ�����ͼƬ������Gallary�в鿴
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
			intent.setData(Uri.fromFile(Environment
					.getExternalStorageDirectory()));
			sendBroadcast(intent);
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(MainActivity.this, "����ͼƬʧ��", 0).show();
			e.printStackTrace();
		}
	}
}
