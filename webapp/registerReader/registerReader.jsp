<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LibMan - Đăng ký Bạn đọc</title>
    <link rel="stylesheet" href="../styles.css">
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
        <a href="../home.jsp">Trang chủ</a>
        <hr>
        <h3>Chức năng Bạn đọc</h3>
        <a href="registerReader.jsp">Đăng ký Làm thẻ Bạn đọc</a>
        <a>Tìm kiếm Tài liệu</a>
        <a>Mượn Tài liệu</a>
        <a>Trả Tài liệu</a>
    </div>

    <!-- Nội dung Chính -->
    <div id="main-content" class="main-content">
        <h2>Đăng ký Làm thẻ Bạn đọc</h2>
        <form action="RegisterReaderServlet669" method="post">
            <label for="fullName">Họ và tên:</label>
            <input type="text" id="fullName" name="fullName" required>
            <button type="submit">Đăng ký</button>
        </form>
    </div>

    <script>
        // Hàm mở/đóng drawer
        function toggleDrawer() {
            const drawer = document.getElementById('drawer');
            const mainContent = document.getElementById('main-content');

            drawer.classList.toggle('drawer-open');
            mainContent.classList.toggle('content-shift');
        }
    </script>

</body>
</html>
