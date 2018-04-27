package com.wayne.webviewinterjsclass;



import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class MyObject {

	Context mContext;

	public MyObject(Context c) {
		// TODO Auto-generated constructor stub
		mContext = c;
	}

	@JavascriptInterface
	public void showToast(String name) {
		Toast.makeText(mContext, name + ",���ã�", Toast.LENGTH_LONG).show();
	}

	@JavascriptInterface
	public void showList() {
		AlertDialog.Builder b = new AlertDialog.Builder(mContext);
		b.setTitle("ͼ���б�");
		b.setIcon(R.drawable.ic_menu_slideshow);
		b.setItems(
				new String[] { "���java����", "���android����", "������Java EE��ҵӦ��ʵս" },
				null);
		b.setPositiveButton("ȷ��", null);

		b.create().show();
	}
}
