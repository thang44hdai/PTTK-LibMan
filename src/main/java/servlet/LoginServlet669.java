package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao669;
import model.NguoiDung669;

@WebServlet("/LoginServlet669")
public class LoginServlet669 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static LoginDao669 userDao = new LoginDao669();
    
    public LoginServlet669() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (userDao.isValidUser(username, password)) {
            HttpSession session = request.getSession();
            NguoiDung669 user = userDao.getUser(username, password);

            session.setAttribute("user", user);

            request.getRequestDispatcher("GDTrangChu669.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
