package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection669;
import model.PhieuNhapTaiLieu669;

public class PhieuNhapTaiLieuDao669 {
    public List<PhieuNhapTaiLieu669> getPhieuNhapByNhaCungCapAndDate(int nhaCungCapId, Date startDate, Date endDate) {
        String query = "SELECT * FROM tblphieunhaptailieu669 WHERE tblNhaCungCap669id = ? AND ngayNhap BETWEEN ? AND ?";
        List<PhieuNhapTaiLieu669> danhSachPhieuNhap = new ArrayList<>();

        try (Connection connection = DBConnection669.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nhaCungCapId);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, endDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    PhieuNhapTaiLieu669 phieuNhap = new PhieuNhapTaiLieu669();
                    phieuNhap.setId(resultSet.getInt("id"));
                    phieuNhap.setNgayNhap(resultSet.getDate("ngayNhap"));
                    phieuNhap.setNhaCungCapId(resultSet.getInt("tblNhaCungCap669id"));
                    phieuNhap.setNhanVienId(resultSet.getInt("tblNhanVien669tblNguoiDung669id"));

                    danhSachPhieuNhap.add(phieuNhap);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachPhieuNhap;
    }

    public PhieuNhapTaiLieu669 getPhieuNhapById(int id) {
        String query = "SELECT * FROM tblphieunhaptailieu669 WHERE id = ?";
        try (Connection connection = DBConnection669.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                PhieuNhapTaiLieu669 phieuNhap = new PhieuNhapTaiLieu669();
                phieuNhap.setId(resultSet.getInt("id"));
                phieuNhap.setNgayNhap(resultSet.getDate("ngayNhap"));
                phieuNhap.setNhaCungCapId(resultSet.getInt("tblNhaCungCap669id"));
                phieuNhap.setNhanVienId(resultSet.getInt("tblNhanVien669tblNguoiDung669id"));
                return phieuNhap;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
