<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.NguoiDung669" %>
<%
    NguoiDung669 user = (NguoiDung669) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LibMan - Hệ thống Quản lý Thư viện</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

    <!-- Thanh điều hướng -->
    <div class="navbar">
        <h1>Hệ thống Quản lý Thư viện LibMan</h1>
        <span class="menu-icon" onclick="toggleDrawer()"><i class="fas fa-bars"></i></span>
    </div>

    <!-- Menu Drawer -->
    <div id="drawer" class="drawer">
        <a href="javascript:void(0)" onclick="toggleDrawer()">Đóng &times;</a>
        <a href="GDTrangChu669.jsp">Trang chủ</a>
        <hr>
        <% if (user != null) { %>
                    <% if (user.getChucvu() == 2) { %>
                        <h3>Chức năng Quản lý</h3>
                        <a href="GDXemBaoCao669.jsp">Xem Báo Cáo</a>
                    <% } else if (user.getChucvu() == 1) { %>
                        <h3>Chức năng Nhân viên</h3>
                        <a>Thêm Tài liệu</a>
                        <a>Tìm kiếm Tài liệu</a>
                        <a>Mượn Tài liệu</a>
                        <a>Trả Tài liệu</a>
                        <a>Quản lý Nhà cung cấp</a>
                    <% } else if (user.getChucvu() == 0) { %>
                        <h3>Chức năng Bạn đọc</h3>
                        <a href="GDDangKiLamTheBanDoc669.jsp">Đăng ký Làm thẻ Bạn đọc</a>
                        <a>Tìm kiếm Tài liệu</a>
                        <a>Mượn Tài liệu</a>
                        <a>Trả Tài liệu</a>
                    <% } %>
        <% } %>
        <hr>
        <a href="login.jsp">Đăng xuất</a>
    </div>

    <!-- Nội dung Chính -->
    <div id="main-content" class="main-content">
        <h2>Chào mừng, <%= user != null ? user.getTen() : "Khách" %>!</h2>
        <p>Chọn một chức năng từ menu để bắt đầu.</p>
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
