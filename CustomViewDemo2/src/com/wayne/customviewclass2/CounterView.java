package com.wayne.customviewclass2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

public class CounterView extends View implements OnClickListener {

	private Paint mPaint;
	// ���ڻ�ȡ���ֵĿ�͸�
	private Rect mBounds;
	// ��������ÿ���һ�α��ؼ�����ֵ����1
	private int mCount;

	public CounterView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//��ʼ������
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		//��ʼ��Rect
		mBounds = new Rect();
		//���ؼ��ĵ���¼�
		setOnClickListener(this);
	}

	
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		mPaint.setColor(Color.YELLOW);
		mPaint.setTextSize(40);
		String text = String.valueOf(mCount);
		//��ȡ���ֵĿ�͸� 
		mPaint.getTextBounds(text, 0, text.length(), mBounds);
		float textWidth = mBounds.width();
		float textHeight = mBounds.height();
		
		//�����ַ���
		canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2 - textHeight / 2, mPaint);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		mCount++;
		
		//���»���
		invalidate();
	}

}
