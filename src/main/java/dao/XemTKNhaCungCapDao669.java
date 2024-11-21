package dao;

import database.DBConnection669;
import model.NhaCungCap669;
import model.PhieuNhapTaiLieu669;
import model.TKNhaCungCap669;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XemTKNhaCungCapDao669 {

    public List<TKNhaCungCap669> getTKNhaCungCap(Date startDate, Date endDate) {
        List<TKNhaCungCap669> result = new ArrayList<>();
        String query = "SELECT ncc.id AS nhaCungCapId, ncc.ten, ncc.diachi, ncc.sdt, COUNT(pntl.id) AS soLuongTaiLieuNhap " +
                "FROM tblPhieuNhapTaiLieu669 pntl " +
                "JOIN tblNhaCungCap669 ncc ON pntl.tblNhaCungCap669id = ncc.id " +
                "WHERE pntl.ngayNhap BETWEEN ? AND ? " +
                "GROUP BY ncc.id, ncc.ten, ncc.diachi, ncc.sdt";

        try (Connection connection = DBConnection669.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set giá trị cho các tham số trong query
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, endDate);

            // Thực thi câu truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            // Mapping dữ liệu từ ResultSet sang List<TKNhaCungCap669>
            while (resultSet.next()) {
                // Tạo đối tượng NhaCungCap669
                NhaCungCap669 nhaCungCap = new NhaCungCap669();
                nhaCungCap.setId(resultSet.getInt("nhaCungCapId"));
                nhaCungCap.setTen(resultSet.getString("ten"));
                nhaCungCap.setDiachi(resultSet.getString("diachi"));
                nhaCungCap.setSdt(resultSet.getString("sdt"));

                // Tạo đối tượng TKNhaCungCap669
                TKNhaCungCap669 tkNhaCungCap = new TKNhaCungCap669();
                tkNhaCungCap.setNhaCungCap(nhaCungCap);
                tkNhaCungCap.setSoLuongTaiLieuNhap(resultSet.getInt("soLuongTaiLieuNhap"));

                // Thêm vào danh sách kết quả
                result.add(tkNhaCungCap);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi
        }

        return result; // Trả về danh sách TKNhaCungCap669
    }

    public NhaCungCap669 getNhaCungCapById(int id) {
        String query = "SELECT * FROM tblnhacungcap669 WHERE id = ?";
        try (Connection connection = DBConnection669.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    NhaCungCap669 nhaCungCap = new NhaCungCap669();
                    nhaCungCap.setId(resultSet.getInt("id"));
                    nhaCungCap.setTen(resultSet.getString("ten"));
                    nhaCungCap.setDiachi(resultSet.getString("diachi"));
                    nhaCungCap.setSdt(resultSet.getString("sdt"));
                    return nhaCungCap;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
