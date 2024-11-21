<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.TKNhaCungCap669" %>
<%@ page import="model.NhaCungCap669" %>
<%@ page import="model.NguoiDung669" %>
<%
    NguoiDung669 user = (NguoiDung669) session.getAttribute("user");
    List<TKNhaCungCap669> danhSachThongKe = (List<TKNhaCungCap669>) request.getAttribute("tkNhaCungCap669List");
    java.sql.Date startDate = (java.sql.Date) request.getAttribute("startDate");
    java.sql.Date endDate = (java.sql.Date) request.getAttribute("endDate");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LibMan - Thống kê nhà cung cấp</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        tr:hover {
            background-color: #f2f2f2;
            cursor: pointer;
        }
    </style>
    <script>
        function directToDetail(nhaCungCapId) {
            const startDate = document.getElementById('startDate').value;
            const endDate = document.getElementById('endDate').value;
            // Kiểm tra nếu startDate hoặc endDate bị rỗng
            if (!startDate || !endDate) {
                alert('Vui lòng chọn ngày bắt đầu và ngày kết thúc.');
                return;
            }

            // Chuyển hướng sang trang chi tiết với tham số query string
            const url = 'XemChiTietTKNhapTaiLieuCtr669?nhaCungCapId=' + nhaCungCapId + '&startDate=' + startDate + '&endDate=' + endDate;
            window.location.href = url;
        }
    </script>
</head>
<body>

    <div class="navbar">
        <h1>Hệ thống Quản lý Thư Viện LibMan</h1>
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
        <h2>Xem Thống Kê Nhà Cung Cấp</h2>
        <!-- Form lọc thời gian -->
        <form action="XemTKNhaCungCapCtr669" method="post" style="margin-top: 20px;">
            <div>
                <label for="startDate">Ngày bắt đầu:</label>
                <input type="date" id="startDate" name="startDate" required value="<%= startDate != null ? startDate.toString() : "" %>">
            </div>
            <div style="margin-top: 10px;">
                <label for="endDate">Ngày kết thúc:</label>
                <input type="date" id="endDate" name="endDate" required value="<%= endDate != null ? endDate.toString() : "" %>">
            </div>
            <div style="margin-top: 20px;">
                <button type="submit">Xem Thống Kê</button>
            </div>
        </form>

        <!-- Bảng thống kê nhà cung cấp -->
        <h3>Kết quả thống kê</h3>
        <%
            if (danhSachThongKe != null && !danhSachThongKe.isEmpty()) {
        %>
            <table border="1" style="width: 100%; margin-top: 20px; border-collapse: collapse;">
                <thead>
                    <tr>
                        <th>ID Nhà Cung Cấp</th>
                        <th>Tên Nhà Cung Cấp</th>
                        <th>Địa Chỉ</th>
                        <th>Số Điện Thoại</th>
                        <th>Số Lượng Tài Liệu Nhập</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (TKNhaCungCap669 tk : danhSachThongKe) {
                        NhaCungCap669 nhaCungCap = tk.getNhaCungCap(); %>
                        <tr onclick="directToDetail('<%= nhaCungCap.getId() %>')">
                            <td><%= nhaCungCap.getId() %></td>
                            <td><%= nhaCungCap.getTen() %></td>
                            <td><%= nhaCungCap.getDiachi() %></td>
                            <td><%= nhaCungCap.getSdt() %></td>
                            <td><%= tk.getSoLuongTaiLieuNhap() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <%
            } else {
        %>
            <p>Không có dữ liệu trong khoảng thời gian được chọn.</p>
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
