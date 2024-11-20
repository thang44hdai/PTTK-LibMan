package servlet;

import dao.RegisterReaderDao669;
import model.TheBanDoc669;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet("/RegisterReaderServlet669")
public class RegisterReaderServlet669 extends HttpServlet {
    private static final RegisterReaderDao669 readerDao669 = new RegisterReaderDao669();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String registerDate = request.getParameter("registerDate");
            int expiryMonths = Integer.parseInt(request.getParameter("expiryMonths"));

            // Xử lý ngày tháng
            LocalDate registerDateParsed = LocalDate.parse(registerDate);
            LocalDate expiryDateParsed = registerDateParsed.plusMonths(expiryMonths);
            Date sqlRegisterDate = Date.valueOf(registerDateParsed);
            Date sqlExpiryDate = Date.valueOf(expiryDateParsed);

            // Tạo đối tượng và lưu
            TheBanDoc669 theBanDoc669 = new TheBanDoc669(id, sqlRegisterDate, sqlExpiryDate);
            boolean success = readerDao669.saveRegisterReader(theBanDoc669);

            if (success) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failure");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("status", "failure");
        }

        request.getRequestDispatcher("GDDangKiLamTheBanDoc669.jsp").forward(request, response);

    }
}
