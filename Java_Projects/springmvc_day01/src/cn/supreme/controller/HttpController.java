package cn.supreme.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class HttpController implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("world", "supreme");
		
		req.getRequestDispatcher("WEB-INF/view/hello.jsp").forward(req, resp);
	}

}
