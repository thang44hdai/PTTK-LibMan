<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.PhieuNhapChiTiet669" %>
<%@ page import="model.TaiLieu669" %>
<%@ page import="model.NhaCungCap669" %>
<%@ page import="model.NguoiDung669" %>
<%
    // Lấy thông tin từ servlet
    PhieuNhapChiTiet669 chiTietPhieuNhap = (PhieuNhapChiTiet669) request.getAttribute("chiTietPhieuNhap");

    // Lấy thông tin chi tiết
    NguoiDung669 nguoiDung = chiTietPhieuNhap != null ? chiTietPhieuNhap.getNguoiDung() : null;
    NhaCungCap669 nhaCungCap = chiTietPhieuNhap != null ? chiTietPhieuNhap.getNhaCungCap() : null;
    java.sql.Date ngayNhap = chiTietPhieuNhap != null ? chiTietPhieuNhap.getNgayNhap() : null;
    List<TaiLieu669> danhSachTaiLieu = chiTietPhieuNhap != null ? chiTietPhieuNhap.getDanhSachTaiLieu() : null;
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LibMan - Chi Tiết Phiếu Nhập</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

    <div class="navbar">
        <h1>Chi Tiết Phiếu Nhập</h1>
        <span class="menu-icon" onclick="toggleDrawer()"><i class="fas fa-bars"></i></span>
    </div>

    <!-- Menu Drawer -->
    <div id="drawer" class="drawer">
        <a href="javascript:void(0)" onclick="toggleDrawer()">Đóng &times;</a>
        <a href="GDTrangChu669.jsp">Trang chủ</a>
        <hr>
        <h3>Chức năng Quản lý</h3>
        <a href="GDXemBaoCao669.jsp">Xem Báo Cáo</a>
    </div>

    <div id="main-content" class="main-content">
        <!-- Thông tin nhà cung cấp -->
        <h2>Thông Tin Phiếu Nhập</h2>
        <%
            if (chiTietPhieuNhap != null) {
        %>
            <table border="1" style="width: 100%; margin-bottom: 20px; border-collapse: collapse;">
                <tr>
                    <th>Ngày Nhập</th>
                    <td><%= ngayNhap %></td>
                </tr>
                <tr>
                    <th>Nhà Cung Cấp</th>
                    <td><%= nhaCungCap != null ? nhaCungCap.getTen() : "N/A" %></td>
                </tr>
                <tr>
                    <th>Nhân Viên Nhập</th>
                    <td><%= nguoiDung != null ? nguoiDung.getTen() : "N/A" %></td>
                </tr>
            </table>

            <!-- Danh sách tài liệu -->
            <h3>Danh Sách Tài Liệu</h3>
            <%
                if (danhSachTaiLieu != null && !danhSachTaiLieu.isEmpty()) {
            %>
                <table border="1" style="width: 100%; margin-top: 20px; border-collapse: collapse;">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên Tài Liệu</th>
                            <th>Tác Giả</th>
                            <th>Năm Xuất Bản</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (TaiLieu669 taiLieu : danhSachTaiLieu) { %>
                            <tr>
                                <td><%= taiLieu.getId() %></td>
                                <td><%= taiLieu.getTen() %></td>
                                <td><%= taiLieu.getTacgia() %></td>
                                <td><%= taiLieu.getNamXB() %></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <%
                } else {
            %>
                <p>Không có tài liệu nào trong phiếu nhập.</p>
            <%
                }
            %>
        <%
            } else {
        %>
            <p style="color: red;">Không tìm thấy thông tin phiếu nhập.</p>
        <%
            }
        %>
    </div>

    <script>
        function toggleDrawer() {
            const drawer = document.getElementById('drawer');
            const mainContent = document.getElementById('main-content');
            drawer.classList.toggle('drawer-open');
            mainContent.classList.toggle('content-shift');
        }
    </script>

</body>
</html>
