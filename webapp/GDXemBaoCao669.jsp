<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.NguoiDung669" %>
<%@ page import="java.time.LocalDate" %>
<%
    NguoiDung669 user = (NguoiDung669) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LibMan - Đăng ký Bạn đọc</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>

    <div class="navbar">
        <h1>Hệ thống Quản lý Thư viện LibMan</h1>
        <span class="menu-icon" onclick="toggleDrawer()"><i class="fas fa-bars"></i></span>
    </div>

    <!-- Menu Drawer -->
    <div id="drawer" class="drawer">
        <a href="javascript:void(0)" onclick="toggleDrawer()">Đóng &times;</a>
        <a href="GDTrangChu669.jsp">Trang chủ</a>
        <hr>
         <h3>Chức năng Quản lý</h3>
         <a href="GDXemBaoCao669.jsp">Xem Báo Cáo</a>
         <hr>
         <a href="login.jsp">Đăng xuất</a>
    </div>

    <div id="main-content" class="main-content">
        <h2>Xem báo cáo</h2>
    <div style="margin-top: 20px;">
            <button onclick="location.href='GDThongKeNhaCungCap669.jsp'">
                Xem thống kê nhà cung cấp theo số lượng nhập
            </button>
        </div>
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
