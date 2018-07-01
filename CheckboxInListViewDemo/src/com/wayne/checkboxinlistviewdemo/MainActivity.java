package com.wayne.checkboxinlistviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListView mListView;
	private List<String> mStringList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mStringList = new ArrayList<>();
		mStringList.add("������");
		mStringList.add("�����");
		mStringList.add("�Ϻ���");
		mStringList.add("�ӱ�ʡ");
		mStringList.add("����ʡ");
		mStringList.add("����ʡ");
		mStringList.add("ɽ��ʡ");
		mStringList.add("����ʡ");
		mStringList.add("����ʡ");
		mStringList.add("����ʡ");
		mStringList.add("����ʡ");
		mStringList.add("����ʡ");
		mStringList.add("����ʡ");
		mStringList.add("����ʡ");
		mStringList.add("�Ĵ�ʡ");
		mStringList.add("ɽ��ʡ");
		mStringList.add("����ʡ");
		mStringList.add("����ʡ");
		mStringList.add("̨��ʡ");
		mStringList.add("����ʡ");
		mStringList.add("�㽭ʡ");
		mListView = (ListView) findViewById(R.id.lv_main);
		MyAdapter adapter = new MyAdapter(this,mStringList);
		mListView.setAdapter(adapter);
	}
	
	public class MyAdapter extends BaseAdapter{

		List<String> mStringList;
		Context mContext;
		private Map<Integer,Boolean> map = new HashMap<>();//����ѱ�ѡ�е�CheckBox
		
		public MyAdapter(Context context,List<String> stringList){
			mStringList = stringList;
			mContext = context;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mStringList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			MyViewHolder holder;
			if(convertView==null){
				convertView = View.inflate(mContext, R.layout.item, null);
				holder = new MyViewHolder();
				holder.mTextView = (TextView)convertView.findViewById(R.id.mTextView);
				holder.mCheckBox = (CheckBox)convertView.findViewById(R.id.mCheckBox);
				convertView.setTag(holder);
			}else{
				holder = (MyViewHolder)convertView.getTag();
			}
			
			holder.mTextView.setText(MainActivity.this.mStringList.get(position));
			
			holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true){
						map.put(position, true);
					}else{
						map.remove(position);
					}
				}
			});
			
			if(map!=null&&map.containsKey(position)){
				holder.mCheckBox.setChecked(true);
				
			}else{
				holder.mCheckBox.setChecked(false);
			}
			
			return convertView;
		}
		
	}
	
	public static class MyViewHolder{
		TextView mTextView;
		CheckBox mCheckBox;
	}
}
