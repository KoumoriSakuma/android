package com.wayne.eventbusfragment;

import org.greenrobot.eventbus.EventBus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wayne.eventbusdemo.R;
import com.wayne.eventbusentity.MsgEvent1;
import com.wayne.eventbusentity.MsgEvent2;

public class RightFragment extends Fragment{

	private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//���洴��ʱ��������Ϣ
		EventBus.getDefault().register(this);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//��������ʱ�����ٽ�����Ϣ
		EventBus.getDefault().unregister(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		View view = inflater.inflate(R.layout.fragment_right,null);
		tv = (TextView) view.findViewById(R.id.tv);
		return view;
	}
	
	/*
	 * �뷢������ͬһ���߳�
	 * @MsgEvent1
	 */
	public void onEvent(MsgEvent1 msg){
		String content = msg.getMsg()+"\nThreadName:"+Thread.currentThread().getName()+"\nThreadId:"+Thread.currentThread().getId();
		System.out.println("onEvent(MsgEvent1 msg)�յ�"+content);
	}
	
	/*
	 * ִ�������߳�
	 * �ǳ�ʵ�ã����������ｫ���̼߳��ص�������ֱ�����õ�UI������
	 * @MsgEvent1
	 */
	public void onEventMainThread(MsgEvent1 msg){
		String content = msg.getMsg()+"\nThreadName:"+Thread.currentThread().getName()+"\nThreadId:"+Thread.currentThread().getId();
		System.out.println("onEventMainThread(MsgEvent1 msg)�յ�"+content);
		tv.setText(content);
	}
	
	/*
	 * ִ�������߳�
	 * ��������������߳���ֱ��ִ�У���������߲������̣߳��򴴽�һ����ִ��
	 * �˴��������߳���������
	 * @MsgEvent1
	 */
	public void onEventBackgroundThread(MsgEvent1 msg){
		String content = msg.getMsg()+"\nThreadName:"+Thread.currentThread().getName()+"\nThreadId:"+Thread.currentThread().getId();
		System.out.println("onEventBackgroundThread(MsgEvent1 msg)�յ�"+content);
	}
	
	/*
	 * ִ����һ���µ����߳�
	 * �����ڶ���߳��������ڲ����̳߳ع���
	 * @MsgEvent1
	 */
	public void onEventAsync(MsgEvent1 msg){
		String content = msg.getMsg()+"\nThreadName:"+Thread.currentThread().getName()+"\nThreadId:"+Thread.currentThread().getId();
		System.out.println("onEventAsync(MsgEvent1 msg)�յ�"+content);
	}
	
	/*
	 * �뷢������ͬһ���߳�
	 * @MsgEvent2
	 */
	public void onEvent(MsgEvent2 msg){
		String content = msg.getMsg()+"\nThreadName:"+Thread.currentThread().getName()+"\nThreadId:"+Thread.currentThread().getId();
		System.out.println("onEvent(MsgEvent2 msg)�յ�"+content);
		tv.setText(content);
	}
}
