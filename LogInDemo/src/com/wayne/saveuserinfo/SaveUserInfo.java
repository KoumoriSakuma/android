package com.wayne.saveuserinfo;

import java.io.File;
import java.io.FileOutputStream;

public class SaveUserInfo {

	public static boolean SaveUser(String username,String password){
		
		//����һ�������������һ���ļ�
		File file = new File("/data/data/com.wayne.Login/cache","userinfo.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			//songweiqi##12345678
			fos.write((username + "##" + password).getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
}
