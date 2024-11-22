<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.NguoiDung669" %>
<%@ page import="java.time.LocalDate" %>
<%
    NguoiDung669 user = (NguoiDung669) session.getAttribute("user");
    LocalDate currentDate = LocalDate.now();

    String status = (String) request.getAttribute("status");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LibMan - Đăng ký Bạn đọc</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script>
        window.onload = function () {
            const status = '<%= status %>';
            if (status === 'success') {
                window.location.href = 'GDDangKiLamTheBanDoc669.jsp';
                alert('Đăng ký thẻ bạn đọc thành công!');
            } else if (status === 'failure') {
                window.location.href = 'GDDangKiLamTheBanDoc669.jsp';
                alert('Đăng ký thẻ bạn đọc thất bại. Vui lòng thử lại!');
            }
        }
    </script>
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
        <h3>Chức năng Bạn đọc</h3>
        <a href="GDDangKiLamTheBanDoc669.jsp">Đăng ký Làm thẻ Bạn đọc</a>
        <hr>
        <a href="login.jsp">Đăng xuất</a>
    </div>

    <div id="main-content" class="main-content">
        <h2>Đăng ký Làm thẻ Bạn đọc</h2>
        <form action="DangKiTheCtr669" method="post">
            <label for="id">Id:</label>
            <input type="text" id="id" name="id" value="<%= user != null ? user.getId() : "" %>" readonly>

            <label for="fullName">Họ và tên:</label>
            <input type="text" id="fullName" name="fullName" value="<%= user != null ? user.getTen() : "" %>" readonly>

            <label for="registerDate">Ngày đăng ký:</label>
            <input type="text" id="registerDate" name="registerDate" value="<%= currentDate.toString() %>" readonly>

            <label for="expiryMonths">Chọn thời hạn (tháng):</label>
            <select id="expiryMonths" name="expiryMonths" required>
                <option value="3">3 tháng</option>
                <option value="6">6 tháng</option>
                <option value="9">9 tháng</option>
                <option value="12">12 tháng</option>
            </select>

            <button type="submit">Đăng ký</button>
        </form>
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
