package com.wayne.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");

		String password = req.getParameter("password");
		resp.setContentType("text/html;charset=utf-8");
		// �����Ĭ�ϵı�����iso-8859-1ת����utf-8�������ת������������롣
		String name = new String(username.getBytes("iso-8859-1"), "utf-8");
		String pass = new String(password.getBytes("iso-8859-1"), "utf-8");
		System.out.println("username" + name);
		System.out.println("password" + pass);
		// �����½����������������123����½�ɹ��������½ʧ�ܡ�
		if ("����".equals(name) && pass.equals("123")) {
			resp.getWriter().print("��¼�ɹ�");
		} else
			resp.getWriter().write("�û������������");

	}
}
