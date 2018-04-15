package com.wayne.downrefuploademo;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements
		AbsListView.OnScrollListener {
	private SwipeRefreshLayout swipeRefreshLayout;
	private ListView lv;
	private ArrayAdapter adapter;
	private List<String> list;
	private View footerView;
	//���ɼ�ҳ����
	private int visibleLastIndex;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case 0x456:

				list.addAll(Arrays.asList("Json", "Gson", "XML"));
				adapter.notifyDataSetChanged();
				//����footerView�ؼ�
				// footerView.setVisibility(View.INVISIBLE);

				if (swipeRefreshLayout.isRefreshing()) {
					// adapter.notifyDataSetChanged();
					swipeRefreshLayout.setRefreshing(false);
				}
				break;

			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.main_sr1);
		lv = (ListView) findViewById(R.id.main_lv);

		//Ϊ footerView�ؼ���䲼���ļ�
		footerView = getLayoutInflater().inflate(R.layout.menu_layout, null);
		//��footerView�ؼ���ӵ�ListView��
		lv.addFooterView(footerView);

		//ΪListView�ؼ��󶨻���������
		lv.setOnScrollListener(this);

		//newһ��ArrayList����ΪListView�ؼ��ṩ����
		list = new ArrayList<>();
		list.addAll(Arrays.asList("java", "php", "C", "C++", ".net", "C#",
				"Html", "Go", "VB", "Kotlin", "JavaScript", "Python", "CSS",
				"Object-C"));

		//ΪListView�ؼ�����һ��������
		adapter = new ArrayAdapter<>(MainActivity.this,
				android.R.layout.simple_expandable_list_item_1,
				android.R.id.text1, list);
		//ΪListView�ؼ�����������
		lv.setAdapter(adapter);

		//swipeRefreshLayout������ɫ
		swipeRefreshLayout.setColorSchemeResources(
				android.R.color.holo_blue_bright,
				android.R.color.holo_blue_dark,
				android.R.color.holo_blue_light,
				android.R.color.holo_green_light);

		swipeRefreshLayout
				.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

					@Override
					public void onRefresh() {
						// TODO Auto-generated method stub
						new LoadDataThread().start();
					}
				});
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		//���ɼ�ҳ=��һ���ɼ�ҳ+�ܹ��ɼ�ҳ-1
		visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		if (adapter.getCount() == visibleLastIndex
				&& scrollState == SCROLL_STATE_IDLE) {
			new LoadDataThread().start();
		}
	}

	class LoadDataThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			// initData();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//ͨ��handler����һ����Ϣ�ı�UI�߳̽���
			handler.sendEmptyMessage(0x456);
		}

		// private void initData() {
		// list.addAll(Arrays.asList("Json", "Gson", "XML"));
		// }
	}

}
