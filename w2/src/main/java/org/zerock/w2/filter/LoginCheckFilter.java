package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Login check filter......");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo") == null) {
            resp.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
        // 로그인 정보가 세션이 존재하는지 여부를 판단

        // 다음 필터 또는 서블릿으로 전달
        // filterChain.doFilter(servletRequest, servletResponse);
    }
}
