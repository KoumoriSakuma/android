package com.wayne.sqliteopenhelperdemo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DBHelper extends SQLiteOpenHelper {

	// ���ݿ�汾
	private static final int VERSION = 1;
	// �½�һ�� ��
	String sql = "create table if not exists TestUsers"
			+ "(id int primary key,name varchar,sex varchar)";

	//�ĸ������Ĺ��캯��
	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	//���������Ĺ��캯�������ĸ������Ĺ��캯��
	public DBHelper(Context context, String name, int version) {
		//������һ�����캯��
		this(context, name, null, version);
	}

	//���������Ĺ��캯���������������Ĺ��캯��
	public DBHelper(Context context, String name) {
		this(context, name, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
}
