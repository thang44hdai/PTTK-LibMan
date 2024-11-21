package servlet;

import dao.PhieuNhapTaiLieuDao669;
import dao.XemChiTietHoaDonNhapDao669;
import model.PhieuNhapChiTiet669;
import model.PhieuNhapTaiLieu669;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/XemChiTietHoaDonNhapCtr669")
public class XemChiTietHoaDonNhapCtr669 extends HttpServlet {

    private XemChiTietHoaDonNhapDao669 dao = new XemChiTietHoaDonNhapDao669();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Lấy ID phiếu nhập từ URL
            String phieuNhapIdStr = request.getParameter("phieuNhapId");
            if (phieuNhapIdStr == null || phieuNhapIdStr.isEmpty()) {
                response.sendRedirect("GDXemBaoCao669.jsp?error=missing_id");
                return;
            }

            int phieuNhapId = Integer.parseInt(phieuNhapIdStr);

            // Truy vấn thông tin chi tiết phiếu nhập
            PhieuNhapChiTiet669 chiTietPhieuNhap = dao.getChiTietPhieuNhapById(phieuNhapId);

            // Nếu không tìm thấy thông tin, chuyển hướng với thông báo lỗi
            if (chiTietPhieuNhap == null) {
                response.sendRedirect("GDXemBaoCao669.jsp?error=no_data_found");
                return;
            }

            // Truyền thông tin sang JSP
            request.setAttribute("chiTietPhieuNhap", chiTietPhieuNhap);

            // Chuyển hướng đến JSP
            request.getRequestDispatcher("GDXemChiTietHoaDonNhap669.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("GDXemBaoCao669.jsp?error=processing_error");
        }
    }
}

