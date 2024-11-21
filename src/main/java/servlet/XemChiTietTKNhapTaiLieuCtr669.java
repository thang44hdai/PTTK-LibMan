package servlet;

import dao.XemTKNhaCungCapDao669;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NhaCungCap669;
import model.PhieuNhapTaiLieu669;
import dao.PhieuNhapTaiLieuDao669;

@WebServlet("/XemChiTietTKNhapTaiLieuCtr669")
public class XemChiTietTKNhapTaiLieuCtr669 extends HttpServlet {

    private XemTKNhaCungCapDao669 nhaCungCapDao = new XemTKNhaCungCapDao669();
    private PhieuNhapTaiLieuDao669 phieuNhapTaiLieuDao = new PhieuNhapTaiLieuDao669();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Lấy tham số từ URL
            String nhaCungCapIdStr = request.getParameter("nhaCungCapId");
            String startDateStr = request.getParameter("startDate");
            String endDateStr = request.getParameter("endDate");

            if (nhaCungCapIdStr == null || startDateStr == null || endDateStr == null) {
                response.sendRedirect("GDXemBaoCao669.jsp?error=missing_params");
                return;
            }

            // Chuyển đổi tham số
            int nhaCungCapId = Integer.parseInt(nhaCungCapIdStr);
            Date startDate = Date.valueOf(startDateStr);
            Date endDate = Date.valueOf(endDateStr);

            // Query thông tin nhà cung cấp
            NhaCungCap669 nhaCungCap = nhaCungCapDao.getNhaCungCapById(nhaCungCapId);

            // Query danh sách phiếu nhập tài liệu
            List<PhieuNhapTaiLieu669> danhSachPhieuNhap = phieuNhapTaiLieuDao.getPhieuNhapByNhaCungCapAndDate(nhaCungCapId, startDate, endDate);

            // Set thuộc tính cho JSP
            request.setAttribute("nhaCungCap", nhaCungCap);
            request.setAttribute("danhSachPhieuNhap", danhSachPhieuNhap);
            request.setAttribute("startDate", startDateStr);
            request.setAttribute("endDate", endDateStr);

            // Chuyển hướng đến JSP
            request.getRequestDispatcher("GDXemChiTietThongKeNhapTaiLieu669.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("GDXemBaoCao669.jsp?error=processing_error");
        }
    }
}

