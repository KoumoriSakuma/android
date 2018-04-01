package com.wayne.propertyanimationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
/*
 * ���Զ����ͽ��䡢��֡����������
 * 1>��֡�������ԣ� ��������������gifЧ��ͼ
 * 2>���䶯�����ԣ�ֻ����ʾ��λ�ñ䶯��View��ʵ��λ��δ�ı䣬����ΪView�ƶ��������ط�������¼�����Զ��������Ӧ
 * 3>���Զ������ԣ�api11�Ժ���ֵĹ��ܣ����ĵ���Viewʵ�ʵ����ԣ����Բ���Ӱ�����ڶ���ִ�к�����λ�õ�����ʹ��
 */
public class MainActivity extends Activity {
	private ImageView iv_animation;
	private Button btn_tween;
	private Button btn_property;
	private Button btn_reset;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		iv_animation = (ImageView) findViewById(R.id.iv_animation);
		btn_tween = (Button) findViewById(R.id.btn_tween);
		btn_property = (Button) findViewById(R.id.btn_property);
		btn_reset = (Button) findViewById(R.id.btn_reset);

		iv_animation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "�����ͼƬ", Toast.LENGTH_SHORT)
						.show();
			}
		});

		btn_tween.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				testTweenAnimation(iv_animation);
			}
		});

		btn_property.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				testPropertyAnimation(iv_animation);
			}
		});

		btn_reset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				testResetTweenAnimation(iv_animation);
			}
		});

	}

	// ���Բ��䶯��
	public void testTweenAnimation(View v) {
		TranslateAnimation animation = new TranslateAnimation(0,
				iv_animation.getWidth(), 0, iv_animation.getHeight());
		animation.setDuration(5000);
		animation.setFillAfter(true);
		v.startAnimation(animation);
	}

	// �������Զ���
	private AnimatorSet animatorSet;

	public void testPropertyAnimation(View v) {
		// x�����ƶ�
		ObjectAnimator animator3 = ObjectAnimator.ofFloat(iv_animation,
				"translationX", 0, iv_animation.getWidth());
		// y�����ƶ�
		ObjectAnimator animator4 = ObjectAnimator.ofFloat(iv_animation,
				"translationY", 0, iv_animation.getHeight());
		AnimatorSet set = new AnimatorSet();
		set.playTogether(animator3, animator4);
		set.start();
	}

	// ���ò��䶯��
	public void testResetTweenAnimation(View v) {
		v.clearAnimation();
	}

}
