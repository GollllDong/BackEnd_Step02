package org.zerock.w1.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")

public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력화면을 볼 수 있도록 구성");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);
        // DB에 req의 parameter를 꺼내서 저장
        // redirect:list
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("입력을 처리하고 목록 페이지로 이동");

        System.out.println("DB에 req의 parameter를 꺼내어 저장");

        resp.sendRedirect("/todo/list");
        // DB에 req의 parameter를 꺼내서 저장
        // redirect:list
    }

}



