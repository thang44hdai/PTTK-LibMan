package servlet;

import dao.XemTKNhaCungCapDao669;
import model.NhaCungCap669;
import model.PhieuNhapTaiLieu669;
import model.TKNhaCungCap669;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/XemTKNhaCungCapCtr669")
public class XemTKNhaCungCapCtr669 extends HttpServlet {

    private XemTKNhaCungCapDao669 dao = new XemTKNhaCungCapDao669();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Lấy tham số ngày bắt đầu và ngày kết thúc từ form
            String startDateStr = request.getParameter("startDate");
            String endDateStr = request.getParameter("endDate");

            // Chuyển đổi chuỗi thành kiểu Date
            Date startDate = Date.valueOf(startDateStr);
            Date endDate = Date.valueOf(endDateStr);

            // Lấy danh sách phiếu nhập trong khoảng ngày
            List<TKNhaCungCap669> tkNhaCungCap669List = dao.getTKNhaCungCap(startDate, endDate);

            request.setAttribute("tkNhaCungCap669List", tkNhaCungCap669List);
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);

            // Chuyển hướng đến JSP hiển thị kết quả
            request.getRequestDispatcher("GDThongKeNhaCungCap669.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("GDXemBaoCao669.jsp?error=processing_error");
        }
    }
}

