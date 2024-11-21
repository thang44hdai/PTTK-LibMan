<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.PhieuNhapTaiLieu669" %>
<%@ page import="model.NhaCungCap669" %>
<%
    // Lấy thông tin từ request
    String nhaCungCapId = request.getParameter("nhaCungCapId");
    String startDate = request.getParameter("startDate");
    String endDate = request.getParameter("endDate");

    // Dữ liệu nhà cung cấp và danh sách phiếu nhập tài liệu từ servlet
    NhaCungCap669 nhaCungCap = (NhaCungCap669) request.getAttribute("nhaCungCap");
    List<PhieuNhapTaiLieu669> danhSachPhieuNhap = (List<PhieuNhapTaiLieu669>) request.getAttribute("danhSachPhieuNhap");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LibMan - Chi Tiết Nhập Tài Liệu</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        tr:hover {
            background-color: #f2f2f2;
            cursor: pointer;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <h1>Chi Tiết Nhập Tài Liệu</h1>
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
        <h2>Thông Tin Nhà Cung Cấp</h2>
        <% if (nhaCungCap != null) { %>
            <table border="1" style="width: 100%; margin-bottom: 20px; border-collapse: collapse;">
                <tr>
                    <th>ID Nhà Cung Cấp</th>
                    <td><%= nhaCungCap.getId() %></td>
                </tr>
                <tr>
                    <th>Tên Nhà Cung Cấp</th>
                    <td><%= nhaCungCap.getTen() %></td>
                </tr>
                <tr>
                    <th>Địa Chỉ</th>
                    <td><%= nhaCungCap.getDiachi() %></td>
                </tr>
                <tr>
                    <th>Số Điện Thoại</th>
                    <td><%= nhaCungCap.getSdt() %></td>
                </tr>
            </table>
        <% } else { %>
            <p style="color: red;">Không tìm thấy thông tin nhà cung cấp.</p>
        <% } %>

        <!-- Khoảng thời gian lọc -->
        <h2>Khoảng Thời Gian Lọc</h2>
        <p>Từ: <strong><%= startDate != null ? startDate : "N/A" %></strong></p>
        <p>Đến: <strong><%= endDate != null ? endDate : "N/A" %></strong></p>

        <!-- Bảng chi tiết phiếu nhập tài liệu -->
        <h2>Chi Tiết Phiếu Nhập Tài Liệu</h2>
        <% if (danhSachPhieuNhap != null && !danhSachPhieuNhap.isEmpty()) { %>
            <table border="1" style="width: 100%; margin-top: 20px; border-collapse: collapse;">
                <thead>
                    <tr>
                        <th>ID Phiếu</th>
                        <th>Ngày Nhập</th>
                        <th>ID Nhân Viên</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (PhieuNhapTaiLieu669 phieuNhap : danhSachPhieuNhap) { %>
                        <tr onclick="directToDetail('<%= phieuNhap.getId() %>')">
                            <td><%= phieuNhap.getId() %></td>
                            <td><%= phieuNhap.getNgayNhap() %></td>
                            <td><%= phieuNhap.getNhanVienId() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } else { %>
            <p>Không có phiếu nhập tài liệu nào trong khoảng thời gian được chọn.</p>
        <% } %>
    </div>

    <script>
        function toggleDrawer() {
            const drawer = document.getElementById('drawer');
            const mainContent = document.getElementById('main-content');
            drawer.classList.toggle('drawer-open');
            mainContent.classList.toggle('content-shift');
        }

        function directToDetail(phieuNhapId) {
            // Chuyển hướng tới servlet XemChiTietHoaDonNhapCtr669
            window.location.href = 'XemChiTietHoaDonNhapCtr669?phieuNhapId=' + phieuNhapId;
        }
    </script>

</body>
</html>
