package com.wayne.gesturescalepicdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * 
 * @author user ͨ����������ͼƬ
 */
public class MainActivity extends Activity implements
		GestureDetector.OnGestureListener {
	private ImageView iv_show;
	// ���������Ƽ����
	private GestureDetector mDetector;
	// ������λͼ��
	private Bitmap bitmap;
	// ����ͼƬ�Ŀ��
	private int width, height;
	// ��¼��ǰ�����ű�
	private float currentScale = 10;
	// ����������ͼƬ���ŵ���
	private Matrix mMatrix;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// �������Ƽ�����
		mDetector = new GestureDetector(this, this);

		iv_show = (ImageView) findViewById(R.id.iv_show);

		mMatrix = new Matrix();

		// ��ȡ�����ŵ�ԭͼƬ
		bitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ic_launcher);

		// ���λͼ�Ŀ��
		width = bitmap.getWidth();
		height = bitmap.getHeight();

		// ����ImageView��ʼ��ʱ��ͼƬ
		iv_show.setImageBitmap(BitmapFactory.decodeResource(
				this.getResources(), R.drawable.ic_launcher));

	}

	// ��д�÷�����Ҫ��Activity�Ĵ����¼� ����GestureDetector��������
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return mDetector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		velocityX = velocityX > 4000 ? 4000 : velocityX;
		velocityY = velocityY > -4000 ? -4000 : velocityY;

		// �������Ƶ��ٶ����������űȣ����velocityX > 0 ��Ŵ�ͼƬ��������СͼƬ
		currentScale += currentScale * velocityX / 4000.0f;

		// ��֤currentScale �������0
		currentScale = currentScale > 0.01 ? currentScale : 0.01f;

		// ����mMatrix
		mMatrix.reset();

		// ����mMatrix
		mMatrix.setScale(currentScale, currentScale, 200, 300);

		BitmapDrawable temp = (BitmapDrawable) iv_show.getDrawable();

		// �����δ���գ���ǿ�ƻ���
		if (!temp.getBitmap().isRecycled() && null != temp) {
			temp.getBitmap().recycle();
		}

		// ����ԭλͼ�����µ�λͼ
		Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height,
				mMatrix, true);

		iv_show.setImageBitmap(newBitmap);

		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
}
